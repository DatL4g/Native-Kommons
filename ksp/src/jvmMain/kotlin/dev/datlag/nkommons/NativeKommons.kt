package dev.datlag.nkommons

import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.processing.SymbolProcessorProvider
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSFunctionDeclaration

class NativeKommons : SymbolProcessorProvider {
    override fun create(environment: SymbolProcessorEnvironment): SymbolProcessor {
        return NativeKommonsProcessor(environment)
    }

    class NativeKommonsProcessor(
        private val env: SymbolProcessorEnvironment,
    ) : SymbolProcessor {
        private var invoked = false

        override fun process(resolver: Resolver): List<KSAnnotated> {
            if (invoked) {
                return emptyList()
            }

            return getAnnotatedFunctions(resolver)
        }

        private fun getAnnotatedFunctions(resolver: Resolver): List<KSFunctionDeclaration> {
            val jniConnectAnnotated = resolver.getSymbolsWithAnnotation(JNIConnect::class.java.name).toList()
            val jniImplAnnotated = resolver.getSymbolsWithAnnotation(JNIImplementation::class.java.name).toList()

            return (jniConnectAnnotated + jniImplAnnotated).filterIsInstance<KSFunctionDeclaration>()
        }
    }
}