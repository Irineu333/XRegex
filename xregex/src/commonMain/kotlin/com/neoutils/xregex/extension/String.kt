package com.neoutils.xregex.extension

import com.neoutils.xregex.XRegex

fun String.toXRegex(
    flags: List<XRegex.Flag> = listOf()
) = XRegex(
    pattern = this, flags = flags
)