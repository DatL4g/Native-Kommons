plugins {
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.multiplatform) apply  false
    alias(libs.plugins.vanniktech.mavenPublish) apply false
    alias(libs.plugins.osdetector) apply false

    alias(libs.plugins.kotest) apply false
    alias(libs.plugins.ksp) apply false
}
