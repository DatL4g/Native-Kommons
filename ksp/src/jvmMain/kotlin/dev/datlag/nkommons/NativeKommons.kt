package dev.datlag.nkommons

import com.google.devtools.ksp.KspExperimental
import com.google.devtools.ksp.getAnnotationsByType
import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.processing.SymbolProcessorProvider
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSFunctionDeclaration
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.MemberName
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.ksp.toTypeName
import com.squareup.kotlinpoet.ksp.writeTo
import dev.datlag.nkommons.TypeMatcher.typeOf

class NativeKommons : SymbolProcessorProvider {
    var called: Boolean = false
        private set

    override fun create(environment: SymbolProcessorEnvironment): SymbolProcessor {
        called = true
        return NativeKommonsProcessor(environment)
    }

    class NativeKommonsProcessor(
        private val env: SymbolProcessorEnvironment,
    ) : SymbolProcessor {

        private val codeGenerator: CodeGenerator
            get() = env.codeGenerator

        override fun process(resolver: Resolver): List<KSAnnotated> {
            getAnnotatedFunctions(resolver).forEach(::generateJNIMethod)

            return emptyList()
        }

        private fun getAnnotatedFunctions(resolver: Resolver): List<KSFunctionDeclaration> {
            val jniConnectAnnotated = resolver.getSymbolsWithAnnotation(JNIConnect::class.java.name).toList()

            return (jniConnectAnnotated).filterIsInstance<KSFunctionDeclaration>().distinct()
        }

        @OptIn(KspExperimental::class)
        private fun generateJNIMethod(declaration: KSFunctionDeclaration) {
            val packageName = declaration.packageName.asString()
            val functionName = declaration.simpleName.asString()
            val returnType = declaration.returnType?.toTypeName() ?: TypeMatcher.UnitOrVoid
            val source = listOfNotNull(
                declaration.containingFile,
                declaration.parentDeclaration?.containingFile
            )

            val packageNameAnnotation = declaration.getAnnotationsByType(JNIPackageName::class).firstOrNull()
            val classNameAnnotation = declaration.getAnnotationsByType(JNIClassName::class).firstOrNull()
            val functionNameAnnotation = declaration.getAnnotationsByType(JNIFunctionName::class).firstOrNull()
            val expectedPackageName = packageNameAnnotation?.packageName?.ifBlank { null } ?: packageName
            val expectedClassName = classNameAnnotation?.className?.ifBlank { null }
            val expectedFunctionName = functionNameAnnotation?.functionName?.ifBlank { null } ?: functionName
            val expectedReturnType = TypeMatcher.jniTypeFor(returnType, forReturn = true)
            val finalReturnType = expectedReturnType ?: returnType

            val jniCName = CNameUtils.jniFunctionCName(
                packageName = expectedPackageName,
                className = expectedClassName,
                functionName = expectedFunctionName
            )

            var envName: String = "env"
            var attachEnv: Boolean = true
            var attachClazz: Boolean = true

            val params = declaration.parameters.mapIndexed { index, param ->
                val name = "p$index"
                val typeName = param.type.toTypeName()
                val expectedTypeName = TypeMatcher.jniTypeFor(typeName, forReturn = false) ?: typeName
                val nullCheck = if (finalReturnType.isNullable) {
                    " ?: return null"
                } else {
                    "!!"
                }
                if (index == 0) {
                    attachEnv = !(typeName typeOf TypeMatcher.Environment)
                    if (!attachEnv) {
                        envName = name
                    }
                }
                if (index == 1 && !attachEnv) {
                    attachClazz = !(typeName typeOf TypeMatcher.JObject)
                }

                val (code, subMember) = when {
                    expectedTypeName typeOf TypeMatcher.JBoolean && typeName typeOf TypeMatcher.KBoolean -> {
                        "$name.%M()" to TypeMatcher.Method.ToKBoolean
                    }
                    expectedTypeName typeOf TypeMatcher.JBooleanArray && typeName typeOf TypeMatcher.KBooleanArray -> {
                        "$name.%M($envName)$nullCheck" to TypeMatcher.Method.ToKBooleanArray
                    }
                    expectedTypeName typeOf TypeMatcher.JByteArray && typeName typeOf TypeMatcher.KByteArray -> {
                        "$name.%M($envName)$nullCheck" to TypeMatcher.Method.ToKByteArray
                    }
                    expectedTypeName typeOf TypeMatcher.JChar && typeName typeOf TypeMatcher.KChar -> {
                        "$name.%M()" to TypeMatcher.Method.ToKChar
                    }
                    expectedTypeName typeOf TypeMatcher.JCharArray && typeName typeOf TypeMatcher.KCharArray -> {
                        "$name.%M($envName)$nullCheck" to TypeMatcher.Method.ToKCharArray
                    }
                    expectedTypeName typeOf TypeMatcher.JDoubleArray && typeName typeOf TypeMatcher.KDoubleArray -> {
                        "$name.%M($envName)$nullCheck" to TypeMatcher.Method.ToKDoubleArray
                    }
                    expectedTypeName typeOf TypeMatcher.JFloatArray && typeName typeOf TypeMatcher.KFloatArray -> {
                        "$name.%M($envName)$nullCheck" to TypeMatcher.Method.ToKFloatArray
                    }
                    expectedTypeName typeOf TypeMatcher.JIntArray && typeName typeOf TypeMatcher.KIntArray -> {
                        "$name.%M($envName)$nullCheck" to TypeMatcher.Method.ToKIntArray
                    }
                    expectedTypeName typeOf TypeMatcher.JLongArray && typeName typeOf TypeMatcher.KLongArray -> {
                        "$name.%M($envName)$nullCheck" to TypeMatcher.Method.ToKLongArray
                    }
                    expectedTypeName typeOf TypeMatcher.JShortArray && typeName typeOf TypeMatcher.KShortArray -> {
                        "$name.%M($envName)$nullCheck" to TypeMatcher.Method.ToKShortArray
                    }
                    expectedTypeName typeOf TypeMatcher.JString && typeName typeOf TypeMatcher.KString -> {
                        "$name.%M($envName)$nullCheck" to TypeMatcher.Method.ToKString
                    }

                    expectedTypeName typeOf TypeMatcher.JObject && typeName typeOf TypeMatcher.NLocale -> {
                        "%T($envName, $name)$nullCheck" to TypeMatcher.NLocale
                    }
                    else -> name to null
                }

                val spec = ParameterSpec.builder(name, expectedTypeName).build()

                ParamInfo(code, subMember, spec)
            }

            val (code, subMember) = when {
                expectedReturnType typeOf TypeMatcher.JBoolean && returnType typeOf TypeMatcher.KBoolean -> {
                    "return %M(${params.joinToString { it.code }}).%M()" to TypeMatcher.Method.ToJBoolean
                }
                expectedReturnType typeOf TypeMatcher.JBooleanArray && returnType typeOf TypeMatcher.KBooleanArray -> {
                    "return %M(${params.joinToString { it.code }}).%M($envName)" to TypeMatcher.Method.ToJBooleanArray
                }
                expectedReturnType typeOf TypeMatcher.JByteArray && returnType typeOf TypeMatcher.KByteArray -> {
                    "return %M(${params.joinToString { it.code }}).%M($envName)" to TypeMatcher.Method.ToJByteArray
                }
                expectedReturnType typeOf TypeMatcher.JChar && returnType typeOf TypeMatcher.KChar -> {
                    "return %M(${params.joinToString { it.code }}).%M()" to TypeMatcher.Method.ToJChar
                }
                expectedReturnType typeOf TypeMatcher.JCharArray && returnType typeOf TypeMatcher.KCharArray -> {
                    "return %M(${params.joinToString { it.code }}).%M($envName)" to TypeMatcher.Method.ToJCharArray
                }
                expectedReturnType typeOf TypeMatcher.JDoubleArray && returnType typeOf TypeMatcher.KDoubleArray -> {
                    "return %M(${params.joinToString { it.code }}).%M($envName)" to TypeMatcher.Method.ToJDoubleArray
                }
                expectedReturnType typeOf TypeMatcher.JFloatArray && returnType typeOf TypeMatcher.KFloatArray -> {
                    "return %M(${params.joinToString { it.code }}).%M($envName)" to TypeMatcher.Method.ToJFloatArray
                }
                expectedReturnType typeOf TypeMatcher.JIntArray && returnType typeOf TypeMatcher.KIntArray -> {
                    "return %M(${params.joinToString { it.code }}).%M($envName)" to TypeMatcher.Method.ToJIntArray
                }
                expectedReturnType typeOf TypeMatcher.JLongArray && returnType typeOf TypeMatcher.KLongArray -> {
                    "return %M(${params.joinToString { it.code }}).%M($envName)" to TypeMatcher.Method.ToJLongArray
                }
                expectedReturnType typeOf TypeMatcher.JShortArray && returnType typeOf TypeMatcher.KShortArray -> {
                    "return %M(${params.joinToString { it.code }}).%M($envName)" to TypeMatcher.Method.ToJShortArray
                }
                expectedReturnType typeOf TypeMatcher.JString && returnType typeOf TypeMatcher.KString -> {
                    "return %M(${params.joinToString { it.code }}).%M($envName)" to TypeMatcher.Method.ToJString
                }

                expectedReturnType typeOf TypeMatcher.JObject && returnType typeOf TypeMatcher.NLocale -> {
                    "return %M(${params.joinToString { it.code }}).toJObject($envName)" to null
                }
                else -> "return %M(${params.joinToString { it.code }})" to null
            }

            val finalParams = if (!attachEnv && attachClazz) {
                val mutableParams = params.toMutableList()
                mutableParams.add(
                    index = 1,
                    element = ParamInfo(
                        code = "",
                        member = null,
                        spec = ParameterSpec.builder("clazz", TypeMatcher.JObject).build()
                    )
                )

                mutableParams.toList()
            } else {
                params
            }

            val method = FunSpec.builder("_${functionName}JNI")
                .addAnnotation(CNameUtils.NativeOptIn)
                .addAnnotation(CNameUtils.cnameFor(jniCName))
                .apply {
                    if (attachEnv) {
                        addParameter(envName, TypeMatcher.Environment)
                        if (attachClazz) {
                            addParameter("clazz", TypeMatcher.JObject)
                        }
                    }
                }
                .addParameters(finalParams.map { it.spec })
                .returns(finalReturnType)
                .apply {
                    val originalMethod = MemberName(packageName, functionName)
                    val memberCalls = listOfNotNull(*finalParams.mapNotNull { it.member }.toTypedArray(), subMember)

                    addComment("FORCING BODY")
                    addStatement(code, originalMethod, *memberCalls.toTypedArray())
                }
                .build()

            FileSpec.builder(packageName, "_${functionName}JNI")
                .addFunction(method)
                .build()
                .writeTo(codeGenerator, Dependencies(false, *source.toTypedArray()))
        }

        data class ParamInfo(
            val code: String,
            val member: Any?,
            val spec: ParameterSpec
        )
    }
}