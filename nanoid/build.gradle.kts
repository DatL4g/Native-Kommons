plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.publish)
    alias(libs.plugins.kotest)
    alias(libs.plugins.ksp)
    `maven-publish`
    signing
}

val libGroup = VersionCatalog.artifactName()
val libName = "nanoid"
group = libGroup
version = libVersion

kotlin {
    androidLibrary {
        compileSdk = Configuration.compileSdk
        minSdk = Configuration.minSdk

        namespace = "$libGroup.$libName"
    }
    jvm()

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

    applyDefaultHierarchyTemplate()

    sourceSets {
        commonMain.dependencies {
            implementation(libs.korlibs.crypto)
        }
    }
}