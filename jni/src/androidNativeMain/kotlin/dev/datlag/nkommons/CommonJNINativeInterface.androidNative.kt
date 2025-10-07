package dev.datlag.nkommons

import dev.datlag.nkommons.binding.jbooleanVar
import dev.datlag.nkommons.binding.jbyte
import dev.datlag.nkommons.binding.jbyteArray
import dev.datlag.nkommons.binding.jcharVar
import dev.datlag.nkommons.binding.jclass
import dev.datlag.nkommons.binding.jfieldID
import dev.datlag.nkommons.binding.jfloat
import dev.datlag.nkommons.binding.jint
import dev.datlag.nkommons.binding.jlong
import dev.datlag.nkommons.binding.jlongArray
import dev.datlag.nkommons.binding.jmethodID
import dev.datlag.nkommons.binding.jobject
import dev.datlag.nkommons.binding.jsize
import dev.datlag.nkommons.binding.jstring
import dev.datlag.nkommons.binding.jthrowable
import kotlinx.cinterop.ByteVarOf
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.ExperimentalForeignApi
import platform.android.jcharArray

@OptIn(ExperimentalForeignApi::class)
actual class CommonJNINativeInterface(
    actual val platform: JNINativeInterface
) {

    actual var NewLongArray: CPointer<CFunction<(CPointer<JNIEnvVar>?, jsize) -> jlongArray?>>?
        get() = platform.NewLongArray
        set(value) {
            platform.NewLongArray = value
        }

    actual var GetByteArrayElements: CPointer<CFunction<(CPointer<JNIEnvVar>?, jbyteArray?, CPointer<jbooleanVar>?) -> CPointer<ByteVarOf<jbyte>>?>>?
        get() = platform.GetByteArrayElements
        set(value) {
            platform.GetByteArrayElements = value
        }

    actual var ExceptionClear: CPointer<CFunction<(CPointer<JNIEnvVar>?) -> Unit>>?
        get() = platform.ExceptionClear
        set(value) {
            platform.ExceptionClear = value
        }

    actual var CallNonvirtualCharMethod: COpaquePointer?
        get() = platform.CallNonvirtualCharMethod
        set(value) {
            platform.CallNonvirtualCharMethod = value
        }

    actual var SetStaticByteField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?, jbyte) -> Unit>>?
        get() = platform.SetStaticByteField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?, jbyte) -> Unit>>?
        set(value) {
            platform.SetStaticByteField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, platform.android.jfieldID?, jbyte) -> Unit>>?
        }

    actual var CallNonvirtualDoubleMethod: COpaquePointer?
        get() = platform.CallNonvirtualDoubleMethod
        set(value) {
            platform.CallNonvirtualDoubleMethod = value
        }

    actual var CallStaticFloatMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, CPointer<jvalue>?) -> jfloat>>?
        get() = platform.CallStaticFloatMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, CPointer<jvalue>?) -> jfloat>>?
        set(value) {
            platform.CallStaticFloatMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, platform.android.jmethodID?, CPointer<jvalue>?) -> jfloat>>?
        }

    actual var CallStaticLongMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, CPointer<jvalue>?) -> jlong>>?
        get() = platform.CallStaticLongMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, CPointer<jvalue>?) -> jlong>>?
        set(value) {
            platform.CallStaticLongMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, platform.android.jmethodID?, CPointer<jvalue>?) -> jlong>>?
        }

    actual var CallBooleanMethod: COpaquePointer?
        get() = platform.CallBooleanMethod
        set(value) {
            platform.CallBooleanMethod = value
        }

    actual var GetStringUTFLength: CPointer<CFunction<(CPointer<JNIEnvVar>?, jstring?) -> jsize>>?
        get() = platform.GetStringUTFLength
        set(value) {
            platform.GetStringUTFLength = value
        }

    actual var CallVoidMethod: COpaquePointer?
        get() = platform.CallVoidMethod
        set(value) {
            platform.CallVoidMethod = value
        }

    actual var Throw: CPointer<CFunction<(CPointer<JNIEnvVar>?, jthrowable?) -> jint>>?
        get() = platform.Throw
        set(value) {
            platform.Throw = value
        }

    actual var NewByteArray: CPointer<CFunction<(CPointer<JNIEnvVar>?, jsize) -> jbyteArray?>>?
        get() = platform.NewByteArray
        set(value) {
            platform.NewByteArray = value
        }

    actual var CallLongMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jmethodID?, CPointer<jvalue>?) -> jlong>>?
        get() = platform.CallLongMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jmethodID?, CPointer<jvalue>?) -> jlong>>?
        set(value) {
            platform.CallLongMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, platform.android.jmethodID?, CPointer<jvalue>?) -> jlong>>?
        }

    actual var FatalError: CPointer<CFunction<(CPointer<JNIEnvVar>?, CPointer<ByteVarOf<Byte>>?) -> Unit>>?
        get() = platform.FatalError
        set(value) {
            platform.FatalError = value
        }

    actual var NewCharArray: CPointer<CFunction<(CPointer<JNIEnvVar>?, jsize) -> jcharArray?>>?
        get() = platform.NewCharArray
        set(value) {
            platform.NewCharArray = value
        }

    actual var CallFloatMethod: COpaquePointer?
        get() = platform.CallFloatMethod
        set(value) {
            platform.CallFloatMethod = value
        }

    actual var EnsureLocalCapacity: CPointer<CFunction<(CPointer<JNIEnvVar>?, jint) -> jint>>?
        get() = platform.EnsureLocalCapacity
        set(value) {
            platform.EnsureLocalCapacity = value
        }

    actual var CallNonvirtualObjectMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jclass?, jmethodID?, CPointer<jvalue>?) -> jobject?>>?
        get() = platform.CallNonvirtualObjectMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jclass?, jmethodID?, CPointer<jvalue>?) -> jobject?>>?
        set(value) {
            platform.CallNonvirtualObjectMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jclass?, platform.android.jmethodID?, CPointer<jvalue>?) -> jobject?>>?
        }

    actual var AllocObject: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?) -> jobject?>>?
        get() = platform.AllocObject
        set(value) {
            platform.AllocObject = value
        }

    actual var ExceptionOccurred: CPointer<CFunction<(CPointer<JNIEnvVar>?) -> jthrowable?>>?
        get() = platform.ExceptionOccurred
        set(value) {
            platform.ExceptionOccurred = value
        }

    actual var GetObjectField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?) -> jobject?>>?
        get() = platform.GetObjectField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?) -> jobject?>>?
        set(value) {
            platform.GetObjectField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, platform.android.jfieldID?) -> jobject?>>?
        }

    actual var NewString: CPointer<CFunction<(CPointer<JNIEnvVar>?, CPointer<jcharVar>?, jsize) -> jstring?>>?
        get() = platform.NewString
        set(value) {
            platform.NewString = value
        }

    actual companion object {
        actual operator fun invoke(platform: JNINativeInterface) = CommonJNINativeInterface(platform)
    }
}