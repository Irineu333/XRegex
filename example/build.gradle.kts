plugins {
    kotlin("multiplatform") version "2.0.20"
}

kotlin {
    jvmToolchain(jdkVersion = 21)

    jvm()

    js(IR) {

        moduleName = "app"

        browser {
            commonWebpackConfig {
                outputFileName = "app.js"
            }
        }

        binaries.executable()
    }

    sourceSets {
        commonMain.dependencies {
            implementation(project(":xregex"))
        }
    }
}