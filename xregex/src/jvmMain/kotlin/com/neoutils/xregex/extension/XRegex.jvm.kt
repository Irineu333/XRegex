package com.neoutils.xregex.extension

import com.neoutils.xregex.XMatch
import com.neoutils.xregex.XRegex
import org.pcre4j.Pcre4j
import org.pcre4j.jna.Pcre2
import org.pcre4j.regex.Pattern

actual fun XRegex.findAll(
    text: String,
    range: IntRange
): List<XMatch> {

    if (flags.any { it == XRegex.Flag.PCRE }) {

        Pcre4j.setup(Pcre2())

        val matcher = Pattern.compile(pattern).matcher(text.substring(range))

        return buildList {

            var index = 0

            while (matcher.find()) {
                add(
                    XMatch(
                        index = index,
                        text = matcher.group(),
                        range = (matcher.start() until matcher.end()) + range,
                        groups = IntRange(
                            start = 0,
                            endInclusive = matcher.groupCount()
                        ).map { groupIndex ->

                            val groupStart = matcher.start(groupIndex)
                            val groupEnd = matcher.end(groupIndex)

                            XMatch.Group(
                                index = groupIndex,
                                text = matcher.group(groupIndex),
                                range = (groupStart until groupEnd) + range
                            )
                        }
                    )
                )

                index++
            }
        }
    }

    val results = Regex(
        pattern = pattern
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