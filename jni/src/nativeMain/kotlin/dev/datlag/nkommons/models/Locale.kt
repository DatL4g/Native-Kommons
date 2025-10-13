package dev.datlag.nkommons.models

import dev.datlag.nkommons.Encoding.UTF8.toJString
import dev.datlag.nkommons.Encoding.UTF8.toKString
import dev.datlag.nkommons.JNIEnvVar
import dev.datlag.nkommons.binding.jclass
import dev.datlag.nkommons.binding.jobject
import dev.datlag.nkommons.binding.jstring
import dev.datlag.nkommons.pointedCommon
import dev.datlag.nkommons.utils.attachToJValue
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.cstr
import kotlinx.cinterop.invoke
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.pointed
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Locale(
    @SerialName("language") val language: String,
    @SerialName("region") val region: String? = null,
    @SerialName("script") val script: String? = null,
    @SerialName("variant") val variant: String? = null
) {

    /**
     * Creates a JVM object of type java.util.Locale
     */
    @OptIn(ExperimentalForeignApi::class)
    fun toJObject(env: CPointer<JNIEnvVar>): jobject? = memScoped {
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
            builderClass = common.FindClass?.invoke(env, JVM_LOCALE_BUILDER.cstr.ptr)
            val builderConstructor = common.GetMethodID?.invoke(env, builderClass, "<init>".cstr.ptr, "()V".cstr.ptr)

            currentBuilderObject = common.NewObjectA?.invoke(env, builderClass, builderConstructor, null)
            currentBuilderObject = callBuilderSetter(currentBuilderObject, JVM_LOCALE_SET_LANGUAGE, language)

            if (!region.isNullOrBlank()) {
                currentBuilderObject = callBuilderSetter(currentBuilderObject, JVM_LOCALE_SET_COUNTRY, region)
            }
            if (!script.isNullOrBlank()) {
                currentBuilderObject = callBuilderSetter(currentBuilderObject, JVM_LOCALE_SET_SCRIPT, script)
            }
            if (!variant.isNullOrBlank()) {
                currentBuilderObject = callBuilderSetter(currentBuilderObject, JVM_LOCALE_SET_VARIANT, variant)
            }

            val buildMethod = common.GetMethodID?.invoke(
                env,
                builderClass,
                "build".cstr.ptr,
                JVM_LOCALE_DEFAULT_TYPE.cstr.ptr
            )

            common.CallObjectMethodA?.invoke(env, currentBuilderObject, buildMethod, null)
        } catch (ignored: Throwable) {
            null
        } finally {
            common.DeleteLocalRef?.invoke(env, currentBuilderObject)
            common.DeleteLocalRef?.invoke(env, builderClass)
        }
    }

    companion object {
        private const val JVM_LOCALE = "java/util/Locale"
        private const val JVM_LOCALE_BUILDER = "java/util/Locale\$Builder"
        private const val JVM_STRING_METHOD_TYPE = "()Ljava/lang/String;"
        private const val JVM_LOCALE_DEFAULT = "getDefault"
        private const val JVM_LOCALE_DEFAULT_TYPE = "()Ljava/util/Locale;"
        private const val JVM_LOCALE_LANGUAGE = "getLanguage"
        private const val JVM_LOCALE_SET_LANGUAGE = "setLanguage"
        private const val JVM_LOCALE_COUNTRY = "getCountry"
        private const val JVM_LOCALE_SET_COUNTRY = "setRegion"
        private const val JVM_LOCALE_SCRIPT = "getScript"
        private const val JVM_LOCALE_SET_SCRIPT = "setScript"
        private const val JVM_LOCALE_VARIANT = "getVariant"
        private const val JVM_LOCALE_SET_VARIANT = "setVariant"

        /**
         * Returns the default Locale available in JVM.
         */
        @OptIn(ExperimentalForeignApi::class)
        operator fun invoke(env: CPointer<JNIEnvVar>): Locale? = memScoped {
            val common = env.pointed.pointedCommon ?: return@memScoped null

            var jvmLocale: jclass? = null
            var defaultObject: jobject? = null
            try {
                jvmLocale = common.FindClass?.invoke(env, JVM_LOCALE.cstr.ptr)
                val defaultMethod = common.GetStaticMethodID?.invoke(
                    env,
                    jvmLocale,
                    JVM_LOCALE_DEFAULT.cstr.ptr,
                    JVM_LOCALE_DEFAULT_TYPE.cstr.ptr
                )
                defaultObject =
                    common.CallStaticObjectMethodA?.invoke(env, jvmLocale, defaultMethod, null)

                val language = env.getLanguage(jvmLocale, defaultObject)
                val region = env.getRegion(jvmLocale, defaultObject)
                val script = env.getScript(jvmLocale, defaultObject)
                val variant = env.getVariant(jvmLocale, defaultObject)

                Locale(
                    language = language ?: return@memScoped null,
                    region = region,
                    script = script,
                    variant = variant
                )
            } catch (ignored: Throwable) {
                null
            } finally {
                common.DeleteLocalRef?.invoke(env, defaultObject)
                common.DeleteLocalRef?.invoke(env, jvmLocale)
            }
        }

        /**
         * Returns the a Locale from JVM instance.
         */
        @OptIn(ExperimentalForeignApi::class)
        operator fun invoke(
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
                    region = region,
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

        @OptIn(ExperimentalForeignApi::class)
        private fun CPointer<JNIEnvVar>.getLanguage(objectClass: jclass?, instance: jobject?): String? {
            return this.getStringMethod(objectClass, instance, JVM_LOCALE_LANGUAGE)
        }

        @OptIn(ExperimentalForeignApi::class)
        private fun CPointer<JNIEnvVar>.getRegion(objectClass: jclass?, instance: jobject?): String? {
            return this.getStringMethod(objectClass, instance, JVM_LOCALE_COUNTRY)
        }

        @OptIn(ExperimentalForeignApi::class)
        private fun CPointer<JNIEnvVar>.getScript(objectClass: jclass?, instance: jobject?): String? {
            return this.getStringMethod(objectClass, instance, JVM_LOCALE_SCRIPT)
        }

        @OptIn(ExperimentalForeignApi::class)
        private fun CPointer<JNIEnvVar>.getVariant(objectClass: jclass?, instance: jobject?): String? {
            return this.getStringMethod(objectClass, instance, JVM_LOCALE_VARIANT)
        }

        @OptIn(ExperimentalForeignApi::class)
        private fun CPointer<JNIEnvVar>.getStringMethod(
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
}
