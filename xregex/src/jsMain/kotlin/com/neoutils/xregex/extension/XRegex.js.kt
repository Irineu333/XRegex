package com.neoutils.xregex.extension

import com.neoutils.xregex.Flavor
import com.neoutils.xregex.XMatch
import com.neoutils.xregex.XRegex
import com.neoutils.xregex.flavor.JavaScriptFlavor

actual fun XRegex.findAll(
    text: String,
    range: IntRange
): List<XMatch> {
    return when (flavors.js) {
        Flavor.JS.Native -> JavaScriptFlavor.findAll(regex = this, text, range)
    }
}

