package dev.datlag.nkommons

import dev.datlag.nkommons.binding.jbooleanVar
import dev.datlag.nkommons.binding.jbyte
import dev.datlag.nkommons.binding.jbyteArray
import dev.datlag.nkommons.binding.jcharVar
import dev.datlag.nkommons.binding.jclass
import dev.datlag.nkommons.binding.jfieldID
import dev.datlag.nkommons.binding.jlongArray
import dev.datlag.nkommons.binding.jmethodID
import dev.datlag.nkommons.binding.jsize
import dev.datlag.nkommons.binding.jstring
import kotlinx.cinterop.ByteVarOf
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.ExperimentalForeignApi
import platform.android.jfloat
import platform.android.jvalue

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

    var CallStaticFloatMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, CPointer<jvalue>?) -> jfloat>>?
        get() = platform.CallStaticFloatMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, CPointer<jvalue>?) -> jfloat>>?
        set(value) {
            platform.CallStaticFloatMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, platform.android.jmethodID?, CPointer<jvalue>?) -> jfloat>>?
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