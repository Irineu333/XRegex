package com.neoutils.xregex.extension

import com.neoutils.xregex.XMatch
import com.neoutils.xregex.XRegex
import kotlin.js.RegExp

actual fun XRegex.findAll(
    text: String,
    range: IntRange
): List<XMatch> {

    val jsRegExp = RegExp(pattern = pattern, flags = "gd")

    return text
        .substring(range)
        .matchAll(jsRegExp)
        .map {
            XMatch(
                index = it.index,
                text = it.text,
                range = it.range + range,
                groups = it.groups.map { group ->
                    group?.let {
                        XMatch.Group(
                            index = group.index,
                            text = group.text,
                            range = group.range + range
                        )
                    }
                },
            )
        }
}

