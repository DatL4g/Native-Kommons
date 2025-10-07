plugins {
    alias(libs.plugins.multiplatform)
}

kotlin {
    jvm()

    sourceSets {
        commonMain.dependencies {
            implementation(project(":annotations"))
        }

        jvmMain.dependencies {
            implementation(libs.ksp)
            implementation(libs.kotlinpoet)
            implementation(libs.kotlinpoet.ksp)
        }
    }
}