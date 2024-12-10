package com.neoutils.xregex.extension

import com.neoutils.xregex.Flavor
import com.neoutils.xregex.XRegex
import com.neoutils.xregex.flavor.JavaFlavor
import com.neoutils.xregex.flavor.PcreFlavor

actual fun XRegex.findAll(
    text: String,
    range: IntRange
) = when (flavors.jvm) {
    Flavor.JVM.Native -> JavaFlavor.findAll(regex = this, text, range)
    Flavor.JVM.PCRE -> PcreFlavor.findAll(regex = this, text, range)
}
