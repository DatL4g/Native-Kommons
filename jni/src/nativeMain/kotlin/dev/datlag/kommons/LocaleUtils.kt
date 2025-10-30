package dev.datlag.kommons

import dev.datlag.kommons.Locale
import dev.datlag.kommons.invoke
import dev.datlag.kommons.Encoding.UTF8.toJString
import dev.datlag.kommons.Encoding.UTF8.toKString
import dev.datlag.kommons.binding.jclass
import dev.datlag.kommons.binding.jobject
import dev.datlag.kommons.binding.jstring
import dev.datlag.kommons.LocaleUtils.getLanguage
import dev.datlag.kommons.LocaleUtils.getRegion
import dev.datlag.kommons.LocaleUtils.getScript
import dev.datlag.kommons.LocaleUtils.getVariant
import dev.datlag.kommons.utils.attachToJValue
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.cstr
import kotlinx.cinterop.invoke
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.pointed

internal data object LocaleUtils {
    const val JVM_LOCALE = "java/util/Locale"
    const val JVM_LOCALE_BUILDER = "java/util/Locale\$Builder"
    const val JVM_STRING_METHOD_TYPE = "()Ljava/lang/String;"
    const val JVM_LOCALE_DEFAULT = "getDefault"
    const val JVM_LOCALE_DEFAULT_TYPE = "()Ljava/util/Locale;"
    const val JVM_LOCALE_LANGUAGE = "getLanguage"
    const val JVM_LOCALE_SET_LANGUAGE = "setLanguage"
    const val JVM_LOCALE_COUNTRY = "getCountry"
    const val JVM_LOCALE_SET_COUNTRY = "setRegion"
    const val JVM_LOCALE_SCRIPT = "getScript"
    const val JVM_LOCALE_SET_SCRIPT = "setScript"
    const val JVM_LOCALE_VARIANT = "getVariant"
    const val JVM_LOCALE_SET_VARIANT = "setVariant"


    @OptIn(ExperimentalForeignApi::class)
    internal fun CPointer<JNIEnvVar>.getLanguage(objectClass: jclass?, instance: jobject?): String? {
        return this.getStringMethod(objectClass, instance, JVM_LOCALE_LANGUAGE)
    }

    @OptIn(ExperimentalForeignApi::class)
    internal fun CPointer<JNIEnvVar>.getRegion(objectClass: jclass?, instance: jobject?): String? {
        return this.getStringMethod(objectClass, instance, JVM_LOCALE_COUNTRY)
    }

    @OptIn(ExperimentalForeignApi::class)
    internal fun CPointer<JNIEnvVar>.getScript(objectClass: jclass?, instance: jobject?): String? {
        return this.getStringMethod(objectClass, instance, JVM_LOCALE_SCRIPT)
    }

    @OptIn(ExperimentalForeignApi::class)
    internal fun CPointer<JNIEnvVar>.getVariant(objectClass: jclass?, instance: jobject?): String? {
        return this.getStringMethod(objectClass, instance, JVM_LOCALE_VARIANT)
    }

    @OptIn(ExperimentalForeignApi::class)
    internal fun CPointer<JNIEnvVar>.getStringMethod(
        objectClass: jclass?,
        instance: jobject?,
        methodName: String,
        methodSignature: String = JVM_STRING_METHOD_TYPE
    ): String? = memScoped {
        val common = this@getStringMethod.pointed.pointedCommon ?: return@memScoped null
        var value: jstring? = null

        try {
            val method = common.GetMethodID?.invoke(
                this@getStringMethod,
                objectClass,
                methodName.cstr.ptr,
                methodSignature.cstr.ptr
            )

            value = common.CallObjectMethodA?.invoke(this@getStringMethod, instance, method, null)
            value?.toKString(this@getStringMethod)?.ifBlank { null }
        } catch (ignored: Throwable) {
            null
        } finally {
            common.DeleteLocalRef?.invoke(this@getStringMethod, value)
        }
    }
}

@OptIn(ExperimentalForeignApi::class)
fun Locale.toJObject(env: CPointer<JNIEnvVar>): jobject? = memScoped {
    val common = env.pointed.pointedCommon ?: return@memScoped null
    fun callBuilderSetter(builderObject: jobject?, methodName: String, value: String): jobject? {
        if (builderObject == null) {
            return null
        }
        var builderClass: jclass? = null
        var jValue: jstring? = null

        return try {
            builderClass = common.GetObjectClass?.invoke(env, builderObject)

            val setterMethod = common.GetMethodID?.invoke(
                env,
                builderClass,
                methodName.cstr.ptr,
                "(Ljava/lang/String;)Ljava/util/Locale\$Builder;".cstr.ptr
            )

            jValue = value.toJString(env)
            val v = attachToJValue(jValue) ?: return null

            common.CallObjectMethodA?.invoke(
                env,
                builderObject,
                setterMethod,
                v
            )
        } catch (ignored: Throwable) {
            null
        } finally {
            common.DeleteLocalRef?.invoke(env, builderClass)
            common.DeleteLocalRef?.invoke(env, jValue)
            common.DeleteLocalRef?.invoke(env, builderObject)
        }
    }

    var builderClass: jclass? = null
    var currentBuilderObject: jobject? = null

    return@memScoped try {
        builderClass = common.FindClass?.invoke(env, LocaleUtils.JVM_LOCALE_BUILDER.cstr.ptr)
        val builderConstructor = common.GetMethodID?.invoke(env, builderClass, "<init>".cstr.ptr, "()V".cstr.ptr)
        val language = getLanguage()
        val region = getCountry()
        val script = getScript()
        val variant = getVariant()

        currentBuilderObject = common.NewObjectA?.invoke(env, builderClass, builderConstructor, null)
        currentBuilderObject = callBuilderSetter(currentBuilderObject, LocaleUtils.JVM_LOCALE_SET_LANGUAGE, language)

        if (!region.isNullOrBlank()) {
            currentBuilderObject = callBuilderSetter(currentBuilderObject, LocaleUtils.JVM_LOCALE_SET_COUNTRY, region)
        }
        if (!script.isNullOrBlank()) {
            currentBuilderObject = callBuilderSetter(currentBuilderObject, LocaleUtils.JVM_LOCALE_SET_SCRIPT, script)
        }
        if (!variant.isNullOrBlank()) {
            currentBuilderObject = callBuilderSetter(currentBuilderObject, LocaleUtils.JVM_LOCALE_SET_VARIANT, variant)
        }

        val buildMethod = common.GetMethodID?.invoke(
            env,
            builderClass,
            "build".cstr.ptr,
            LocaleUtils.JVM_LOCALE_DEFAULT_TYPE.cstr.ptr
        )

        common.CallObjectMethodA?.invoke(env, currentBuilderObject, buildMethod, null)
    } catch (ignored: Throwable) {
        null
    } finally {
        common.DeleteLocalRef?.invoke(env, currentBuilderObject)
        common.DeleteLocalRef?.invoke(env, builderClass)
    }
}

@OptIn(ExperimentalForeignApi::class)
operator fun Locale.Companion.invoke(env: CPointer<JNIEnvVar>): Locale? = memScoped {
    val common = env.pointed.pointedCommon ?: return@memScoped null

    var jvmLocale: jclass? = null
    var defaultObject: jobject? = null
    try {
        jvmLocale = common.FindClass?.invoke(env, LocaleUtils.JVM_LOCALE.cstr.ptr)
        val defaultMethod = common.GetStaticMethodID?.invoke(
            env,
            jvmLocale,
            LocaleUtils.JVM_LOCALE_DEFAULT.cstr.ptr,
            LocaleUtils.JVM_LOCALE_DEFAULT_TYPE.cstr.ptr
        )
        defaultObject = common.CallStaticObjectMethodA?.invoke(env, jvmLocale, defaultMethod, null)

        val language = env.getLanguage(jvmLocale, defaultObject)
        val region = env.getRegion(jvmLocale, defaultObject)
        val script = env.getScript(jvmLocale, defaultObject)
        val variant = env.getVariant(jvmLocale, defaultObject)

        Locale(
            language = language ?: return@memScoped null,
            country = region,
            script = script,
            variant = variant
        )
    } catch (ignored: Throwable) {
        null
    } finally {
        common.DeleteLocalRef?.invoke(env, defaultObject)
        common.DeleteLocalRef?.invoke(env, jvmLocale)
    }
} ?: invoke()

@OptIn(ExperimentalForeignApi::class)
operator fun Locale.Companion.invoke(
    env: CPointer<JNIEnvVar>,
    jvmInstance: jobject?,
    deleteReference: Boolean = true
): Locale? = memScoped {
    val common = env.pointed.pointedCommon ?: return@memScoped null

    var jvmLocale: jclass? = null
    try {
        jvmLocale = common.GetObjectClass?.invoke(env, jvmInstance)

        val language = env.getLanguage(jvmLocale, jvmInstance)
        val region = env.getRegion(jvmLocale, jvmInstance)
        val script = env.getScript(jvmLocale, jvmInstance)
        val variant = env.getVariant(jvmLocale, jvmInstance)

        Locale(
            language = language ?: return@memScoped null,
            country = region,
            script = script,
            variant = variant
        )
    } catch (ignored: Throwable) {
        null
    } finally {
        common.DeleteLocalRef?.invoke(env, jvmLocale)

        if (deleteReference) {
            common.DeleteLocalRef?.invoke(env, jvmInstance)
        }
    }
}