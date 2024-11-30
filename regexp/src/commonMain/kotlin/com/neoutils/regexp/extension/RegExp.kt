package com.neoutils.regexp.extension

import com.neoutils.regexp.Match
import com.neoutils.regexp.RegExp

expect fun RegExp.findAll(
    text: String,
    range: IntRange = IntRange(0, text.lastIndex)
): List<Match>