import com.vanniktech.maven.publish.KotlinMultiplatform
import com.vanniktech.maven.publish.SonatypeHost
import extension.config

plugins {
    id("com.vanniktech.maven.publish")
    kotlin("multiplatform")
}

group = config.group
version = config.version

mavenPublishing {

    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    coordinates(
        groupId = config.group,
        version = config.version.toString()
    )

    configure(
        KotlinMultiplatform(
            sourcesJar = true,
            androidVariantsToPublish = listOf("release"),
        )
    )

    pom {
        name.set("XRegex")
        description.set("Expanded cross-platform regular expression processor.")
        inceptionYear.set("2024")
        url.set("https://github.com/NeoUtils/XRegex")

        licenses {
            license {
                name.set("The MIT License")
                url.set("https://opensource.org/licenses/MIT")
            }
        }

        developers {
            developer {
                id.set("irineu333")
                name.set("Irineu A. Silva")
                url.set("https://github.com/Irineu333")
            }
        }

        scm {
            url.set("https://github.com/NeoUtils/XRegex")
            connection.set("scm:git:git://github.com/NeoUtils/XRegex.git")
            developerConnection.set("scm:git:ssh://git@github.com/NeoUtils/XRegex.git")
        }
    }

    signAllPublications()
}
