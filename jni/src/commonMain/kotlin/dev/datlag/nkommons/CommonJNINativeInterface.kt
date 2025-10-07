package dev.datlag.nkommons

import dev.datlag.nkommons.binding.jbooleanVar
import dev.datlag.nkommons.binding.jbyte
import dev.datlag.nkommons.binding.jbyteArray
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

@OptIn(ExperimentalForeignApi::class)
expect class CommonJNINativeInterface {
    val platform: JNINativeInterface

    var NewLongArray: CPointer<CFunction<(CPointer<JNIEnvVar>?, jsize) -> jlongArray?>>?
    var GetByteArrayElements: CPointer<CFunction<(CPointer<JNIEnvVar>?, jbyteArray?, CPointer<jbooleanVar>?) -> CPointer<ByteVarOf<jbyte>>?>>?
    var ExceptionClear: CPointer<CFunction<(CPointer<JNIEnvVar>?) -> Unit>>?
    var CallNonvirtualCharMethod: COpaquePointer?
    var SetStaticByteField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?, jbyte) -> Unit>>?
    var CallNonvirtualDoubleMethod: COpaquePointer?
    var CallStaticFloatMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, CPointer<jvalue>?) -> jfloat>>?
    var CallStaticLongMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, CPointer<jvalue>?) -> jlong>>?
    var CallBooleanMethod: COpaquePointer?
    var GetStringUTFLength: CPointer<CFunction<(CPointer<JNIEnvVar>?, jstring?) -> jsize>>?
    var CallVoidMethod: COpaquePointer?
    var Throw: CPointer<CFunction<(CPointer<JNIEnvVar>?, jthrowable?) -> jint>>?
    var NewByteArray: CPointer<CFunction<(CPointer<JNIEnvVar>?, jsize) -> jbyteArray?>>?
    var CallLongMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jmethodID?, CPointer<jvalue>?) -> jlong>>?
    var FatalError: CPointer<CFunction<(CPointer<JNIEnvVar>?, CPointer<ByteVarOf<Byte>>?) -> Unit>>?
    var NewCharArray: CPointer<CFunction<(CPointer<JNIEnvVar>?, jsize) -> jcharArray?>>?
    var CallFloatMethod: COpaquePointer?
    var EnsureLocalCapacity: CPointer<CFunction<(CPointer<JNIEnvVar>?, jint) -> jint>>?
    var CallNonvirtualObjectMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jclass?, jmethodID?, CPointer<jvalue>?) -> jobject?>>?
    var AllocObject: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?) -> jobject?>>?
    var ExceptionOccurred: CPointer<CFunction<(CPointer<JNIEnvVar>?) -> jthrowable?>>?
    var GetObjectField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?) -> jobject?>>?

    var NewString: CPointer<CFunction<(CPointer<JNIEnvVar>?, CPointer<jcharVar>?, jsize) -> jstring?>>?

    companion object {
        operator fun invoke(platform: JNINativeInterface): CommonJNINativeInterface
    }
}