package com.neoutils.xregex.extension

import com.neoutils.xregex.XMatch
import com.neoutils.xregex.XRegex
import kotlin.test.Test
import kotlin.test.assertContentEquals

class XRegexTest {

    @Test
    fun testingFullyMatch() {

        val expected = listOf(
            XMatch(
                index = 0,
                text = "XRegex",
                range = 0..5,
                groups = listOf(
                    XMatch.Group(
                        index = 0,
                        text = "XRegex",
                        range = 0..5
                    )
                )
            )
        )

        val actual = XRegex(
            pattern = "\\w+"
        ).findAll(
            text = "XRegex"
        )

        assertContentEquals(
            expected,
            actual
        )
    }
}