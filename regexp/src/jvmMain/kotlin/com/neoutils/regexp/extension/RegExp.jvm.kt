package com.neoutils.regexp.extension

import com.neoutils.regexp.Match
import com.neoutils.regexp.RegExp

actual fun RegExp.findAll(text: String): List<Match> {

    val results = Regex(
        pattern = pattern
    ).findAll(input = text)

    return buildList {
        results.forEachIndexed { index, match ->
            add(
                Match(
                    index = index,
                    text = match.value,
                    range = match.range,
                    groups = match.groups.map { group ->
                        group?.let {
                            Match.Group(
                                text = it.value,
                                range = it.range
                            )
                        }
                    }
                )
            )
        }
    }
}