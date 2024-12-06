package com.neoutils.xregex.extension

import com.neoutils.xregex.JsMatch
import kotlin.js.RegExp

fun String.matchAll(jsRegex: RegExp): List<JsMatch> {

    val result = asDynamic().matchAll(jsRegex)

    val matches = mutableListOf<JsMatch>()

    var current = result.next()

    var index = 0

    while (current.done == false) {

        val match = current.value
        val groups = mutableListOf<JsMatch.Group?>()

        match.iterator().withIndex().forEach { (index, group) ->

            val range = match.indices[index]
                ?.unsafeCast<IntArray>()
                ?.toRange()

            val text = group.unsafeCast<String?>()

            groups.add(
                range?.let {
                    text?.let {
                        JsMatch.Group(
                            index = index,
                            text = text,
                            range = range
                        )
                    }
                }
            )
        }

        val fullyMatch = checkNotNull(groups[0])

        matches.add(
            JsMatch(
                index = index,
                text = fullyMatch.text,
                range = fullyMatch.range,
                groups = groups,
            )
        )

        current = result.next()
        index++
    }

    return matches
}
