package com.neoutils.xregex

data class Flavors(
    var jvm: Flavor.JVM = Flavor.JVM.Native,
    var js: Flavor.JS = Flavor.JS.Native
)

sealed class Flavor {
    sealed class JVM : Flavor() {
        data object Native : JVM()
        data object PCRE : JVM()
    }

    sealed class JS : Flavor() {
        data object Native : JS()
    }
}