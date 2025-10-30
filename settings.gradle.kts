rootProject.name = "Native-Kommons"

include(":annotations")
include(":jni")
include(":ksp")
include(":locale")
include(":demo")

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}
