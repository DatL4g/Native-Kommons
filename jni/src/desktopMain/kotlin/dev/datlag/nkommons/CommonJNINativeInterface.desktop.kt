package dev.datlag.nkommons

import dev.datlag.nkommons.binding.jbooleanVar
import dev.datlag.nkommons.binding.jbyte
import dev.datlag.nkommons.binding.jbyteArray
import dev.datlag.nkommons.binding.jbyteVar
import dev.datlag.nkommons.binding.jcharArray
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

@OptIn(markerClass = [ExperimentalForeignApi::class])
actual class CommonJNINativeInterface(
    actual val platform: JNINativeInterface
) {

    actual var NewLongArray: CPointer<CFunction<(CPointer<JNIEnvVar>?, jsize) -> jlongArray?>>?
        get() = platform.NewLongArray as CPointer<CFunction<(CPointer<JNIEnvVar>?, jsize) -> jlongArray?>>?
        set(value) {
            platform.NewLongArray = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jsize) -> jni.jlongArray?>>?
        }

    actual var GetByteArrayElements: CPointer<CFunction<(CPointer<JNIEnvVar>?, jbyteArray?, CPointer<jbooleanVar>?) -> CPointer<ByteVarOf<jbyte>>?>>?
        get() = platform.GetByteArrayElements as CPointer<CFunction<(CPointer<JNIEnvVar>?, jbyteArray?, CPointer<jbooleanVar>?) -> CPointer<ByteVarOf<jbyte>>?>>?
        set(value) {
            platform.GetByteArrayElements = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jbyteArray?, CPointer<jbooleanVar>?) -> CPointer<jbyteVar>?>>?
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
            platform.SetStaticByteField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jclass?, jni.jfieldID?, jbyte) -> Unit>>?
        }

    actual var CallNonvirtualDoubleMethod: COpaquePointer?
        get() = platform.CallNonvirtualDoubleMethod
        set(value) {
            platform.CallNonvirtualDoubleMethod = value
        }

    actual var CallStaticFloatMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, CPointer<jvalue>?) -> jfloat>>?
        get() = platform.CallStaticFloatMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, CPointer<jvalue>?) -> jfloat>>?
        set(value) {
            platform.CallStaticFloatMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jclass?, jni.jmethodID?, CPointer<jvalue>?) -> jfloat>>?
        }

    actual var CallStaticLongMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, CPointer<jvalue>?) -> jlong>>?
        get() = platform.CallStaticLongMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, CPointer<jvalue>?) -> jlong>>?
        set(value) {
            platform.CallStaticLongMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jclass?, jni.jmethodID?, CPointer<jvalue>?) -> jlong>>?
        }

    actual var CallBooleanMethod: COpaquePointer?
        get() = platform.CallBooleanMethod
        set(value) {
            platform.CallBooleanMethod = value
        }

    actual var GetStringUTFLength: CPointer<CFunction<(CPointer<JNIEnvVar>?, jstring?) -> jsize>>?
        get() = platform.GetStringUTFLength as CPointer<CFunction<(CPointer<JNIEnvVar>?, jstring?) -> jsize>>?
        set(value) {
            platform.GetStringUTFLength = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jstring?) -> jsize>>?
        }

    actual var CallVoidMethod: COpaquePointer?
        get() = platform.CallVoidMethod
        set(value) {
            platform.CallVoidMethod = value
        }

    actual var Throw: CPointer<CFunction<(CPointer<JNIEnvVar>?, jthrowable?) -> jint>>?
        get() = platform.Throw as CPointer<CFunction<(CPointer<JNIEnvVar>?, jthrowable?) -> jint>>?
        set(value) {
            platform.Throw = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jthrowable?) -> jint>>?
        }

    actual var NewByteArray: CPointer<CFunction<(CPointer<JNIEnvVar>?, jsize) -> jbyteArray?>>?
        get() = platform.NewByteArray as CPointer<CFunction<(CPointer<JNIEnvVar>?, jsize) -> jbyteArray?>>?
        set(value) {
            platform.NewByteArray = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jsize) -> jni.jbyteArray?>>?
        }

    actual var CallLongMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jmethodID?, CPointer<jvalue>?) -> jlong>>?
        get() = platform.CallLongMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jmethodID?, CPointer<jvalue>?) -> jlong>>?
        set(value) {
            platform.CallLongMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?, jni.jmethodID?, CPointer<jvalue>?) -> jlong>>?
        }

    actual var FatalError: CPointer<CFunction<(CPointer<JNIEnvVar>?, CPointer<ByteVarOf<Byte>>?) -> Unit>>?
        get() = platform.FatalError
        set(value) {
            platform.FatalError = value
        }

    actual var NewCharArray: CPointer<CFunction<(CPointer<JNIEnvVar>?, jsize) -> jcharArray?>>?
        get() = platform.NewCharArray as CPointer<CFunction<(CPointer<JNIEnvVar>?, jsize) -> jcharArray?>>?
        set(value) {
            platform.NewCharArray = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jsize) -> jni.jcharArray?>>?
        }

    actual var NewString: CPointer<CFunction<(CPointer<dev.datlag.nkommons.JNIEnvVar>?, CPointer<jcharVar>?, jsize) -> jstring?>>?
        get() = platform.NewString as CPointer<CFunction<(CPointer<JNIEnvVar>?, CPointer<jcharVar>?, jsize) -> jstring?>>?
        set(value) {
            platform.NewString = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, CPointer<jcharVar>?, jsize) -> jni.jstring?>>?
        }

    actual companion object {
        actual operator fun invoke(platform: JNINativeInterface) = CommonJNINativeInterface(platform)
    }
}