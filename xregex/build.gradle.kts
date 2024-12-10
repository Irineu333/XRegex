plugins {
    id("com.neoutils.xregex")
}

kotlin {

    jvm()

    js(IR) {
        browser()
        nodejs()
        binaries.library()
    }

    sourceSets {
        jvmMain.dependencies {
            api(libs.pcre4j.regex)
            api(libs.pcre4j.jna)
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}