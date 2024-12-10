package com.neoutils.xregex

interface XFlavor {
    fun findAll(
        regex: XRegex,
        text: CharSequence,
        range: IntRange
    ): List<XMatch>
}
