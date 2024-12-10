plugins {
    kotlin("multiplatform")
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