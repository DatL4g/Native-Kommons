rootProject.name = "Native-Kommons"

include(":annotations")
include(":cache", ":cache:benchmark")
include(":jni")
include(":ksp")
include(":locale")
include(":utils")

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
