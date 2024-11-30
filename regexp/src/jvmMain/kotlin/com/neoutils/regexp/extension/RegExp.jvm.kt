package com.neoutils.regexp.extension

import com.neoutils.regexp.Match
import com.neoutils.regexp.RegExp

actual fun RegExp.findAll(
    text: String,
    range: IntRange
): List<Match> {

    val results = Regex(
        pattern = pattern
    ).findAll(
        input = text.substring(range),
    )

    return buildList {
        results.forEachIndexed { matchIndex, match ->
            add(
                Match(
                    index = matchIndex,
                    text = match.value,
                    range = match.range + range,
                    groups = match.groups.mapIndexed { groupIndex, group ->
                        group?.let {
                            Match.Group(
                                text = it.value,
                                range = it.range + range,
                                index = groupIndex
                            )
                        }
                    }
                )
            )
        }
    }
}