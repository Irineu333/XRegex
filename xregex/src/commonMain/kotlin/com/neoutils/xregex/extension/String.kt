package com.neoutils.xregex.extension

import com.neoutils.xregex.XRegex

fun String.toXRegex(
    flags: List<String> = listOf()
) = XRegex(
    pattern = this,
    flags = flags
)