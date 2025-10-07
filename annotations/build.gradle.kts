plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.android.library)
}

kotlin {
    androidLibrary {
        compileSdk = 36
        minSdk = 21

        namespace = "dev.datlag.nkommons.annotations"
    }
    jvm()

    androidNativeX64()
    androidNativeArm64()
    androidNativeX86()
    androidNativeArm32()

    linuxX64()
    linuxArm64()

    mingwX64()

    macosX64()
    macosArm64()

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    tvosX64()
    tvosArm64()
    tvosSimulatorArm64()

    watchosX64()
    watchosArm32()
    watchosArm64()
    watchosSimulatorArm64()
    watchosDeviceArm64()

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
}