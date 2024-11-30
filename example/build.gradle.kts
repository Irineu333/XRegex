plugins {
    kotlin("multiplatform") version "2.0.20"
}

kotlin {
    jvmToolchain(17)

    jvm()

    sourceSets {
        commonMain.dependencies {
            implementation(project(":regexp"))
        }
    }
}