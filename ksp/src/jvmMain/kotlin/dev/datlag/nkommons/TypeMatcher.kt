package dev.datlag.nkommons

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.MemberName
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.asTypeName

internal object TypeMatcher {

    val UnitOrVoid = Unit::class.asTypeName()
    private val CPointer = ClassName("kotlinx.cinterop", "CPointer")
    private val JNIEnvVar = ClassName("dev.datlag.nkommons", "JNIEnvVar")
    val Environment = CPointer.parameterizedBy(JNIEnvVar)

    val KBoolean = Boolean::class.asTypeName()
    val KByte = Byte::class.asTypeName()
    val KInt = Int::class.asTypeName()
    val KLong = Long::class.asTypeName()
    val KFloat = Float::class.asTypeName()
    val KDouble = Double::class.asTypeName()
    val KShort = Short::class.asTypeName()
    val KChar = Char::class.asTypeName()
    val KString = String::class.asTypeName()
    val KIntArray = IntArray::class.asTypeName()

    private const val TYPE_BINDING_PACKAGE = "dev.datlag.nkommons.binding"
    val JBoolean = ClassName(TYPE_BINDING_PACKAGE, "jboolean")
    val JByte = ClassName(TYPE_BINDING_PACKAGE, "jbyte")
    val JInt = ClassName(TYPE_BINDING_PACKAGE, "jint")
    val JLong = ClassName(TYPE_BINDING_PACKAGE, "jlong")
    val JFloat = ClassName(TYPE_BINDING_PACKAGE, "jfloat")
    val JDouble = ClassName(TYPE_BINDING_PACKAGE, "jdouble")
    val JShort = ClassName(TYPE_BINDING_PACKAGE, "jshort")
    val JChar = ClassName(TYPE_BINDING_PACKAGE, "jchar")
    val JString = ClassName(TYPE_BINDING_PACKAGE, "jstring")
    val JIntArray = ClassName(TYPE_BINDING_PACKAGE, "jintArray")
    val JObject = ClassName(TYPE_BINDING_PACKAGE, "jobject")

    object Method {

        val ToJString = MemberName("dev.datlag.nkommons", "toJString")
        val ToJIntArray = MemberName("dev.datlag.nkommons", "toJIntArray")
        val ToJBoolean = MemberName("dev.datlag.nkommons", "toJBoolean")
        val ToJChar = MemberName("dev.datlag.nkommons", "toJChar")

        val ToKString = MemberName("dev.datlag.nkommons", "toKString")
        val ToKIntArray = MemberName("dev.datlag.nkommons", "toKIntArray")
        val ToKBoolean = MemberName("dev.datlag.nkommons", "toKBoolean")
        val ToKChar = MemberName("dev.datlag.nkommons", "toKChar")
    }

    fun jniTypeFor(param: TypeName, forReturn: Boolean): TypeName? {
        return when (param) {
            KBoolean -> JBoolean.copy(nullable = param.isNullable)
            KByte -> JByte.copy(nullable = param.isNullable)
            KInt -> JInt.copy(nullable = param.isNullable)
            KLong -> JLong.copy(nullable = param.isNullable)
            KFloat -> JFloat.copy(nullable = param.isNullable)
            KDouble -> JDouble.copy(nullable = param.isNullable)
            KShort -> JShort.copy(nullable = param.isNullable)
            KChar -> JChar.copy(nullable = param.isNullable)
            KString -> if (forReturn) {
                JString.copy(nullable = true)
            } else {
                JString.copy(nullable = param.isNullable)
            }
            KIntArray -> if (forReturn) {
                JIntArray.copy(nullable = true)
            } else {
                JIntArray.copy(nullable = param.isNullable)
            }
            else -> null
        }
    }

    infix fun TypeName?.typeOf(expected: TypeName): Boolean = when {
        this == null -> false
        this == expected -> true
        this.copy(nullable = false) == expected.copy(nullable = false) -> true
        this.copy(nullable = true) == expected.copy(nullable = true) -> true
        else -> false
    }

}