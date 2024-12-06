package com.neoutils.xregex

interface XFlavor {
    fun findAll(
        regex: XRegex,
        text: String,
        range: IntRange
    ): List<XMatch>
}
