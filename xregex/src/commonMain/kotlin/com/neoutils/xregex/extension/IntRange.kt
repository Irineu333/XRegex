package com.neoutils.xregex.extension

infix operator fun IntRange.plus(range: IntRange): IntRange {
    return IntRange(
        start = start + range.first,
        endInclusive = endInclusive + range.first
    )
}
