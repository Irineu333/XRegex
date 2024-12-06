package com.neoutils.xregex

data class JsMatch(
    val index: Int,
    val text: String,
    val range: IntRange,
    val groups: List<Group?>
) {
    data class Group(
        val index: Int,
        val text: String,
        val range: IntRange
    )
}
