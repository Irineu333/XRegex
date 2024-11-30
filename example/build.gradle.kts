plugins {
    kotlin("multiplatform") version "2.0.20"
}

kotlin {
    jvmToolchain(17)

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
            implementation(project(":regexp"))
        }
    }
}