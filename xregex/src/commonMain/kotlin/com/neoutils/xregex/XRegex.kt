package com.neoutils.xregex

data class XRegex(
    val pattern: String,
    val flags: List<Flag> = listOf()
) {
    enum class Flag {
        PCRE // jvm only
    }
}