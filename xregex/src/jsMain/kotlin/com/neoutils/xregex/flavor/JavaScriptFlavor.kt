package com.neoutils.xregex.flavor

import com.neoutils.xregex.XFlavor
import com.neoutils.xregex.XMatch
import com.neoutils.xregex.XRegex
import com.neoutils.xregex.extension.matchAll
import com.neoutils.xregex.extension.plus
import kotlin.js.RegExp

object JavaScriptFlavor : XFlavor {
    override fun findAll(
        regex: XRegex,
        text: String,
        range: IntRange
    ): List<XMatch> {

        val jsRegExp = RegExp(
            pattern = regex.pattern,
            flags = "gd"
        )

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
}