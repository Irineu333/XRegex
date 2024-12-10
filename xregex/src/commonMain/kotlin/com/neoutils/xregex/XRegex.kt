package com.neoutils.xregex

data class XRegex(
    val pattern: String,
    val flags: List<String> = listOf(),
    val flavors: Flavors = Flavors()
)