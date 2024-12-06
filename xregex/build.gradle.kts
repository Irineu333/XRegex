plugins {
    kotlin("multiplatform") version "2.0.20"
}

group = "com.neoutils.xregex"
version = "1.0-SNAPSHOT"

kotlin {
    jvmToolchain(jdkVersion = 21)

    jvm()

    js(IR) {
        browser()
        binaries.library()
    }

    sourceSets {
        jvmMain.dependencies {
            implementation(libs.pcre4j.regex)
            implementation(libs.pcre4j.jna)
        }
    }
}