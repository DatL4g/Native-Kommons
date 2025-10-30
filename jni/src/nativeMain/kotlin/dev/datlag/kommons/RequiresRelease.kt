package dev.datlag.kommons

@RequiresOptIn(message = "This API allocates memory which needs to be freed. Call the according release method if available.")
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.BINARY)
annotation class RequiresRelease
