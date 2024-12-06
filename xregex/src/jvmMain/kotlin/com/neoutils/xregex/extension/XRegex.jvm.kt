package com.neoutils.xregex.extension

import com.neoutils.xregex.XMatch
import com.neoutils.xregex.XRegex

actual fun XRegex.findAll(
    text: String,
    range: IntRange
): List<XMatch> {

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