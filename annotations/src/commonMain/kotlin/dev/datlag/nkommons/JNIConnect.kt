package dev.datlag.nkommons

/**
 * Auto generate JNI compatible function from native code.
 *
 * @param packageName specify custom package name for the JNI call
 * @param className specify the name of the JVM class where the function should be available in.
 * @param functionName specify custom function name for the JNI call
 */
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.SOURCE)
annotation class JNIConnect(
    val packageName: String = "",
    val className: String = "",
    val functionName: String = ""
)