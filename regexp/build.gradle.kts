plugins {
    kotlin("multiplatform") version "2.0.20"
}

group = "com.neoutils.regexpkmp"
version = "1.0-SNAPSHOT"

kotlin {
    jvmToolchain(17)

    jvm()

    js(IR) {
        browser()
        binaries.library()
    }
}