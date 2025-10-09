plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.publish)
    `maven-publish`
    signing
}

val libGroup = VersionCatalog.artifactName()
val libName = "ksp"
group = libGroup
version = libVersion

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
    }
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
        name.set("Native-Kommons KSP")
        description.set("KSP plugin for JNI auto-generation.")
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