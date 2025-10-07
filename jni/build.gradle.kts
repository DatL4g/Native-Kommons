plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.osdetector)
    alias(libs.plugins.kotest)
    alias(libs.plugins.ksp)
}

group = "io.github.kotlin"
version = "1.0.0"

kotlin {
    androidNativeX86()
    androidNativeX64()
    androidNativeArm32()
    androidNativeArm64()

    val desktopTargets = mutableListOf(
        linuxX64(),
        linuxArm64(),
        mingwX64()
    )

    if (getHost() == Host.MAC) {
        desktopTargets.add(
            macosX64()
        )
        desktopTargets.add(
            macosArm64()
        )
    }

    desktopTargets.forEach { target ->
        target.compilations.getByName("main") {
            cinterops {
                create("jni") {
                    val javaDefaultHome = System.getProperty("java.home")
                    val javaEnvHome = getSystemJavaHome()
                    val javaSdkMan = getSdkManJava()
                    val javaDefaultRuntime = getDefaultRuntimeJava()
                    val javaFallbackRuntime = getFallbackRuntimeJava()

                    includeDirs.allHeaders(
                        // Gradle or IDE specified Java Home
                        File(javaDefaultHome, "include"),
                        File(javaDefaultHome, "include/darwin"),
                        File(javaDefaultHome, "include/linux"),
                        File(javaDefaultHome, "include/win32"),

                        // System set Java Home
                        File(javaEnvHome, "include"),
                        File(javaEnvHome, "include/darwin"),
                        File(javaEnvHome, "include/linux"),
                        File(javaEnvHome, "include/win32"),

                        // SDK Man Java
                        File(javaSdkMan, "include"),
                        File(javaSdkMan, "include/darwin"),
                        File(javaSdkMan, "include/linux"),
                        File(javaSdkMan, "include/win32"),

                        // Default Runtime Java
                        File(javaDefaultRuntime, "include"),
                        File(javaDefaultRuntime, "include/darwin"),
                        File(javaDefaultRuntime, "include/linux"),
                        File(javaDefaultRuntime, "include/win32"),

                        // Fallback Runtime Java
                        File(javaFallbackRuntime, "include"),
                        File(javaFallbackRuntime, "include/darwin"),
                        File(javaFallbackRuntime, "include/linux"),
                        File(javaFallbackRuntime, "include/win32"),
                    )
                }
            }
        }
    }

    applyDefaultHierarchyTemplate()

    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
        }

        commonTest.dependencies {
            implementation(libs.bundles.kotest)
            implementation("org.jetbrains.kotlinx:kotlinx-io-core:0.8.0")
        }

        val desktopMain by creating {
            dependsOn(commonMain.get())

            linuxMain.orNull?.dependsOn(this)
            mingwMain.orNull?.dependsOn(this)

            macosMain.orNull?.dependsOn(this)
        }
    }
}

tasks.withType<Test> {
    reports {
        html.required.set(true)
    }
    systemProperty("gradle.build.dir", project.layout.buildDirectory.asFile.orNull ?: project.buildDir)
}

fun getSystemJavaHome(): String? {
    return System.getenv("JAVA_HOME")?.ifBlank { null }
}

fun getSdkManJava(): String? {
    return System.getProperty("user.home")?.ifBlank { null }?.let {
        "$it/.sdkman/candidates/java/current"
    }
}

fun getDefaultRuntimeJava(): String? {
    return "/usr/lib/jvm/default-runtime"
}

fun getFallbackRuntimeJava(): String? {
    return "/usr/lib/jvm/java"
}

fun getHost(): Host {
    return when (osdetector.os) {
        "linux" -> Host.Linux
        "osx" -> Host.MAC
        "windows" -> Host.Windows
        else -> {
            val hostOs = System.getProperty("os.name")
            val isMingwX64 = hostOs.startsWith("Windows")

            when {
                hostOs == "Linux" -> Host.Linux
                hostOs == "Mac OS X" -> Host.MAC
                isMingwX64 -> Host.Windows
                else -> throw IllegalStateException("Unknown OS: ${osdetector.classifier}")
            }
        }
    }
}

enum class Host(val label: String) {
    Linux("linux"),
    Windows("win"),
    MAC("mac");
}