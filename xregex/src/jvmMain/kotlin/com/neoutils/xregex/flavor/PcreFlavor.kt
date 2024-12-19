package com.neoutils.xregex.flavor

import com.neoutils.xregex.XFlavor
import com.neoutils.xregex.XMatch
import com.neoutils.xregex.XRegex
import com.neoutils.xregex.extension.plus
import org.pcre4j.Pcre4j
import org.pcre4j.jna.Pcre2
import org.pcre4j.regex.Pattern

object PcreFlavor : XFlavor {

    init {
        Pcre4j.setup(Pcre2())
    }

    override fun findAll(
        regex: XRegex,
        text: CharSequence,
        range: IntRange
    ): List<XMatch> {

        val matcher = Pattern
            .compile(regex.pattern)
            .matcher(text.substring(range))

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

                            matcher.group(groupIndex)?.let { groupText ->

                                val groupStart = matcher.start(groupIndex)
                                val groupEnd = matcher.end(groupIndex)

                                val groupRange = groupStart until groupEnd

                                XMatch.Group(
                                    index = groupIndex,
                                    text = groupText,
                                    range = groupRange + range
                                )
                            }
                        }
                    )
                )

                index++
            }
        }
    }
}