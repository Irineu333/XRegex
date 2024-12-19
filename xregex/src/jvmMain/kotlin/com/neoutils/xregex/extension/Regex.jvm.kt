package com.neoutils.xregex.extension

actual fun Regex.xRegex() = pattern.xRegex(
    flags = options.mapNotNull {
        when (it) {
            RegexOption.LITERAL -> "l"
            RegexOption.IGNORE_CASE -> "i"
            RegexOption.MULTILINE -> "m"
            RegexOption.COMMENTS -> "c"
            RegexOption.DOT_MATCHES_ALL -> "s"
            RegexOption.UNIX_LINES, RegexOption.CANON_EQ -> null
        }
    }
)