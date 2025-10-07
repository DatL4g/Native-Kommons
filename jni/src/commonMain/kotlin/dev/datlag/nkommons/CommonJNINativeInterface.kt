package dev.datlag.nkommons

import dev.datlag.nkommons.binding.jbooleanVar
import dev.datlag.nkommons.binding.jbyte
import dev.datlag.nkommons.binding.jbyteArray
import dev.datlag.nkommons.binding.jcharVar
import dev.datlag.nkommons.binding.jclass
import dev.datlag.nkommons.binding.jfieldID
import dev.datlag.nkommons.binding.jlongArray
import dev.datlag.nkommons.binding.jsize
import dev.datlag.nkommons.binding.jstring
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

    var NewString: CPointer<CFunction<(CPointer<JNIEnvVar>?, CPointer<jcharVar>?, jsize) -> jstring?>>?

    companion object {
        operator fun invoke(platform: JNINativeInterface): CommonJNINativeInterface
    }
}