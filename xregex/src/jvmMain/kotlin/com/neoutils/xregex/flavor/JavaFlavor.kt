package com.neoutils.xregex.flavor

import com.neoutils.xregex.XFlavor
import com.neoutils.xregex.XMatch
import com.neoutils.xregex.XRegex
import com.neoutils.xregex.extension.plus

object JavaFlavor : XFlavor {
    override fun findAll(
        regex: XRegex,
        text: CharSequence,
        range: IntRange
    ): List<XMatch> {
        val results = Regex(
            pattern = regex.pattern,
            options = regex.flags.mapNotNull {
                when (it) {
                    "l" -> RegexOption.LITERAL
                    "i" -> RegexOption.IGNORE_CASE
                    "m" -> RegexOption.MULTILINE
                    "c" -> RegexOption.COMMENTS
                    "s" -> RegexOption.DOT_MATCHES_ALL
                    else -> null
                }
            }.toSet()
        ).findAll(
            input = text.substring(range),
        )

        return buildList {
            results.forEachIndexed { matchIndex, match ->
                add(
                    XMatch(
                        index = matchIndex,
                        text = match.value,
                        range = match.range + range,
                        groups = match.groups.mapIndexed { groupIndex, group ->
                            group?.let {
                                XMatch.Group(
                                    index = groupIndex,
                                    text = it.value,
                                    range = it.range + range
                                )
                            }
                        }
                    )
                )
            }
        }
    }
}

