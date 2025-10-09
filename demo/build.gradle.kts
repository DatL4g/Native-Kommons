plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.osdetector)
    alias(libs.plugins.ksp)
}

kotlin {
    jvm {
        mainRun {
            mainClass = "dev.datlag.nkommons.MainKt"
        }
    }

    androidNativeX64()
    androidNativeArm64()
    androidNativeX86()
    androidNativeArm32()

    linuxX64 {
        binaries {
            sharedLib()
        }
    }
    linuxArm64 {
        binaries {
            sharedLib()
        }
    }

    mingwX64 {
        binaries {
            sharedLib()
        }
    }

    if (getHost() == Host.MAC) {
        macosX64 {
            binaries {
                sharedLib()
            }
        }
        macosArm64 {
            binaries {
                sharedLib()
            }
        }
    }

    applyDefaultHierarchyTemplate()

    sourceSets {
        nativeMain.dependencies {
            implementation(project(":jni"))
            implementation(project(":annotations"))
        }
    }
}

dependencies {
    ksp(project(":ksp"))
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