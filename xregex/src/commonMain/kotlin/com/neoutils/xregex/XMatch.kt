package com.neoutils.xregex

data class XMatch(
    val index: Int,
    val text: String,
    val range: IntRange,
    val groups: List<Group?> = listOf(
        // the first group is always the full match
        Group(
            index = 0,
            text = text,
            range = range
        )
    )
) {
    data class Group(
        val index: Int,
        val text: String,
        val range: IntRange
    )
}