plugins {
    id("com.neoutils.xregex")
}

kotlin {
    jvmToolchain(jdkVersion = 21)

    jvm()

    js(IR) {
        browser()
        nodejs()
        binaries.library()
    }

    sourceSets {
        jvmMain.dependencies {
            implementation(libs.pcre4j.regex)
            implementation(libs.pcre4j.jna)
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}