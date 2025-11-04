plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.allopen)
    alias(libs.plugins.benchmark)
}

allOpen {
    annotation("org.openjdk.jmh.annotations.State")
}

benchmark {
    targets {
        register("jvm")
    }
}

kotlin {
    jvm()

    sourceSets {
        commonMain.dependencies {
            implementation(libs.benchmark)
            implementation(libs.coroutines)

            implementation(project(":cache"))
            implementation(libs.benchmark.kache)
            implementation(libs.benchmark.cache4k)
        }
    }
}