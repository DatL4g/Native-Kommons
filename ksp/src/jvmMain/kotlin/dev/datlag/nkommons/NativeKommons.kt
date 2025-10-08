package dev.datlag.nkommons

import com.google.devtools.ksp.KspExperimental
import com.google.devtools.ksp.getAnnotationsByType
import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.processing.SymbolProcessorProvider
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSFunctionDeclaration

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

            return (jniConnectAnnotated).filterIsInstance<KSFunctionDeclaration>()
        }

        @OptIn(KspExperimental::class)
        private fun generateJNIMethod(declaration: KSFunctionDeclaration) {
            val packageName = declaration.packageName.asString()
            val functionName = declaration.simpleName.asString()

            val connectAnnotation = declaration.getAnnotationsByType(JNIConnect::class).singleOrNull()
            val expectedPackageName = connectAnnotation?.packageName?.ifBlank { null } ?: packageName
            val expectedClassName = connectAnnotation?.className?.ifBlank { null }
            val expectedFunctionName = connectAnnotation?.functionName?.ifBlank { null } ?: functionName

            val jniCName = CNameUtils.jniFunctionCName(
                packageName = expectedPackageName,
                className = expectedClassName,
                functionName = expectedFunctionName
            )
        }


    }
}