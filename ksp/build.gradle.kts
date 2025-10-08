plugins {
    alias(libs.plugins.multiplatform)
}

kotlin {
    jvm()

    sourceSets {
        commonMain.dependencies {
            api(project(":annotations"))
        }

        commonTest.dependencies {
            implementation(libs.test)
        }

        jvmMain.dependencies {
            implementation(libs.ksp)
            implementation(libs.kotlinpoet)
            implementation(libs.kotlinpoet.ksp)
        }

        jvmTest.dependencies {
            implementation(libs.test.compile)
            implementation(libs.test.ksp)
            implementation(libs.mockito)
        }
    }
}