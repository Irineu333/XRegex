package com.neoutils.xregex.extension

actual fun Regex.xRegex() = pattern.xRegex(
    flags = options.map {
        when (it) {
            RegexOption.IGNORE_CASE -> "i"
            RegexOption.MULTILINE -> "m"
        }
    }
)