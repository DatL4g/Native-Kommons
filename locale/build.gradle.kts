plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.publish)
    alias(libs.plugins.serialization)
    `maven-publish`
    signing
}

val libGroup = VersionCatalog.artifactName()
val libName = "locale"
group = libGroup
version = libVersion

kotlin {
    androidLibrary {
        compileSdk = Configuration.compileSdk
        minSdk = Configuration.minSdk

        namespace = "$libGroup.$libName"
    }
    jvm()

    val androidNativeTargets = listOf(
        androidNativeX86 {
            binaries {
                sharedLib()
                staticLib()
            }
        },
        androidNativeX64 {
            binaries {
                sharedLib {
                    linkerOpts += listOf(
                        "-Wl,-z,max-page-size=16384",
                        "-Wl,-z,common-page-size=16384",
                        "-v"
                    )
                }
                staticLib {
                    linkerOpts += listOf(
                        "-Wl,-z,max-page-size=16384",
                        "-Wl,-z,common-page-size=16384",
                        "-v"
                    )
                }
            }
        },
        androidNativeArm32 {
            binaries {
                sharedLib()
                staticLib()
            }
        },
        androidNativeArm64 {
            binaries {
                sharedLib()
                staticLib()
            }
        }
    )

    linuxX64 {
        binaries {
            sharedLib()
            staticLib()
        }
    }
    linuxArm64 {
        binaries {
            sharedLib()
            staticLib()
        }
    }

    mingwX64 {
        binaries {
            sharedLib()
            staticLib()
        }
    }

    macosX64 {
        binaries {
            sharedLib()
            staticLib()
        }
    }
    macosArm64 {
        binaries {
            sharedLib()
            staticLib()
        }
    }

    iosX64 {
        binaries {
            sharedLib()
            staticLib()
        }
    }
    iosArm64 {
        binaries {
            sharedLib()
            staticLib()
        }
    }
    iosSimulatorArm64 {
        binaries {
            sharedLib()
            staticLib()
        }
    }

    tvosX64 {
        binaries {
            sharedLib()
            staticLib()
        }
    }
    tvosArm64 {
        binaries {
            sharedLib()
            staticLib()
        }
    }
    tvosSimulatorArm64 {
        binaries {
            sharedLib()
            staticLib()
        }
    }

    watchosX64 {
        binaries {
            sharedLib()
            staticLib()
        }
    }
    watchosArm32 {
        binaries {
            sharedLib()
            staticLib()
        }
    }
    watchosArm64 {
        binaries {
            sharedLib()
            staticLib()
        }
    }
    watchosSimulatorArm64 {
        binaries {
            sharedLib()
            staticLib()
        }
    }
    watchosDeviceArm64 {
        binaries {
            sharedLib()
            staticLib()
        }
    }

    js {
        browser()
        nodejs()
    }

    wasmJs {
        browser()
        nodejs()
    }

    wasmWasi {
        nodejs()
    }

    applyDefaultHierarchyTemplate()

    androidNativeTargets.forEach { target ->
        target.compilations.getByName("main") {
            cinterops {
                create("sysprop") {
                    definitionFile.set(project.layout.projectDirectory.file("src/androidNativeMain/cinterop/sysprop.def"))
                }
            }
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(libs.serialization)
        }

        nativeTest.dependencies {
            implementation(libs.bundles.kotest)
        }

        webMain.dependencies {
            implementation(libs.browser)
        }
    }
}
