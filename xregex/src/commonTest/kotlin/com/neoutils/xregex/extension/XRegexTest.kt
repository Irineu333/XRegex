package com.neoutils.xregex.extension

import com.neoutils.xregex.XMatch
import com.neoutils.xregex.XRegex
import kotlin.test.Test
import kotlin.test.assertEquals

class XRegexTest {

    @Test
    fun captureWord() {

        val expected = listOf(
            XMatch(
                index = 0,
                text = "XRegex",
                range = 0..5
            )
        )

        val actual = XRegex(
            pattern = "\\w+"
        ).findAll(
            text = "XRegex"
        )

        assertEquals(
            expected,
            actual
        )
    }

    @Test
    fun captureLetters() {

        val expected = listOf(
            XMatch(
                index = 0,
                text = "X",
                range = 0..0
            ),
            XMatch(
                index = 1,
                text = "R",
                range = 1..1
            ),
            XMatch(
                index = 2,
                text = "e",
                range = 2..2
            ),
            XMatch(
                index = 3,
                text = "g",
                range = 3..3
            ),
            XMatch(
                index = 4,
                text = "e",
                range = 4..4
            ),
            XMatch(
                index = 5,
                text = "x",
                range = 5..5
            )
        )

        val actual = XRegex(
            pattern = "\\w"
        ).findAll(
            text = "XRegex"
        )

        assertEquals(
            expected,
            actual
        )
    }
}