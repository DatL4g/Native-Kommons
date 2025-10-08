import dev.datlag.nkommons.JNIEnvVar
import dev.datlag.nkommons.binding.jobject
import dev.datlag.nkommons.binding.jstring
import dev.datlag.nkommons.toJString
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.ExperimentalForeignApi
import kotlin.experimental.ExperimentalNativeApi

@OptIn(ExperimentalForeignApi::class, ExperimentalNativeApi::class)
@CName("Java_dev_datlag_nkommons_MainKt_nativeHello")
fun helloFromNative(env: CPointer<JNIEnvVar>, clazz: jobject): jstring? {
    return "Hello from Native!".toJString(env)
}