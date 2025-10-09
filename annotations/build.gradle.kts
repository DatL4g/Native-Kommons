plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.publish)
    `maven-publish`
    signing
}

val libGroup = VersionCatalog.artifactName()
val libName = "annotations"
group = libGroup
version = libVersion

kotlin {
    androidLibrary {
        compileSdk = Configuration.compileSdk
        minSdk = Configuration.minSdk

        namespace = "$libGroup.$libName"
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

mavenPublishing {
    publishToMavenCentral(automaticRelease = true)
    signAllPublications()

    coordinates(
        groupId = libGroup,
        artifactId = libName,
        version = libVersion
    )

    pom {
        name.set("Native-Kommons Annotations")
        description.set("Annotations library for KSP plugin")
        url.set("https://github.com/DatL4g/Native-Kommons")
        inceptionYear.set("2025")

        licenses {
            license {
                name.set("Apache License 2.0")
                url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }

        scm {
            url.set("https://github.com/DatL4g/Native-Kommons")
            connection.set("scm:git:git://github.com/DATL4G/Native-Kommons.git")
            developerConnection.set("scm:git:git://github.com/DATL4G/Native-Kommons.git")
        }

        developers {
            developer {
                id.set("DatL4g")
                name.set("Jeff Retz")
                url.set("https://github.com/DatL4g")
            }
        }
    }
}