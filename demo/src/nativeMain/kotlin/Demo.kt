import dev.datlag.nkommons.JNIClassName
import dev.datlag.nkommons.JNIConnect
import dev.datlag.nkommons.JNIFunctionName
import dev.datlag.nkommons.JNIPackageName

@JNIConnect
fun boolExample(): Boolean {
    return true
}

@JNIConnect
fun intExample(): Int {
    return 2 + 3
}

@JNIConnect
fun longExample(): Long {
    return 42L
}

@JNIConnect
fun floatExample(): Float {
    return 0.5F
}

@JNIConnect
fun doubleExample(): Double {
    return 0.2
}

@JNIConnect
@JNIFunctionName("characterExample")
fun charExample(): Char {
    return 'j'
}

@JNIConnect
@JNIPackageName("dev.datlag.nkommons")
@JNIClassName("MainKt")
fun stringExample(): String {
    return "Hello Native!"
}

@JNIConnect
fun intArrayExample(): IntArray {
    return intArrayOf(0, 2)
}

@JNIConnect
fun addition(a: Int, b: Long): Int {
    return a + b.toInt()
}

@JNIConnect
fun concat(a: String, b: String): String {
    return "$a$b"
}

@JNIConnect
@JNIPackageName("dev.datlag.nkommons")
@JNIClassName("MainKt")
fun mixed(a: String, b: Int, c: Boolean, d: IntArray, e: Char): String {
    return "$a, $b, $c, ${d.joinToString(separator = "|", prefix = "[", postfix = "]")}, $e"
}