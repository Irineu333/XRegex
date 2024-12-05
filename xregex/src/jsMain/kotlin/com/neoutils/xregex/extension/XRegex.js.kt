package com.neoutils.xregex.extension

import com.neoutils.xregex.Match
import com.neoutils.xregex.XRegex
import kotlin.js.RegExp

actual fun XRegex.findAll(
    text: String,
    range: IntRange
): List<Match> {

    val jsRegExp = RegExp(pattern = pattern, flags = "gd")

    val matches = text.substring(range).matchAll(jsRegExp)

    return buildList {
        matches.forEachIndexed { matchIndex, match ->

            val indices = match.indices

            val matchRange = indices[0]
                .unsafeCast<IntArray>()
                .toRange()

            add(
                Match(
                    index = matchIndex,
                    text = match.toString(),
                    range = matchRange + range,
                    groups = buildList {
                        for ((groupIndex, group) in match.iterator().withIndex()) {

                            val groupRange = indices[groupIndex]
                                ?.unsafeCast<IntArray>()
                                ?.toRange()

                            add(
                                groupRange?.let {
                                    Match.Group(
                                        text = group.unsafeCast<String>(),
                                        range = groupRange + range,
                                        index = groupIndex
                                    )
                                }
                            )
                        }

                    }
                )
            )
        }
    }
}

fun String.matchAll(jsRegex: RegExp): List<dynamic> {

    val result = asDynamic().matchAll(jsRegex)

    return buildList {
        var current = result.next()

        while (current.done == false) {
            add(current.value)
            current = result.next()
        }
    }
}
