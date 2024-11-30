package com.neoutils.regexp

data class Match(
    val text: String,
    val index: Int,
    val range: IntRange,
    val groups: List<Group?>
) {
    data class Group(
        val index: Int,
        val text: String,
        val range: IntRange
    )
}