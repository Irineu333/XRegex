plugins {
    kotlin("multiplatform") version "2.0.20"
}

kotlin {
    jvmToolchain(jdkVersion = 21)

    jvm()

    sourceSets {
        commonMain.dependencies {
            implementation(project(":xregex"))
        }
    }
}