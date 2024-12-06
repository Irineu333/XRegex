package com.neoutils.xregex.extension

import com.neoutils.xregex.XMatch
import com.neoutils.xregex.XRegex
import com.neoutils.xregex.flavor.JavaFlavor
import com.neoutils.xregex.flavor.PcreFlavor

actual fun XRegex.findAll(
    text: String,
    range: IntRange
): List<XMatch> {

    if (flags.any { it == XRegex.Flag.PCRE }) {
        return PcreFlavor.findAll(regex = this, text, range)
    }

    return JavaFlavor.findAll(regex = this, text, range)
}
