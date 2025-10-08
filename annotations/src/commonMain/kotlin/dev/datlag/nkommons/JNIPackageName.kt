package dev.datlag.nkommons

/**
 * Will be removed as soon as https://github.com/google/ksp/issues/2356 is fixed.
 *
 * Getting merged into [JNIConnect].
 */
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.SOURCE)
annotation class JNIPackageName(val packageName: String)
