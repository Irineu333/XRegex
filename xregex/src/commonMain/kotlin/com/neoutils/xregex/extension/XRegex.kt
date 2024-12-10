package com.neoutils.xregex.extension

import com.neoutils.xregex.XMatch
import com.neoutils.xregex.XRegex

expect fun XRegex.findAll(
    text: CharSequence,
    range: IntRange = IntRange(0, text.lastIndex)
): List<XMatch>