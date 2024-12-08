package com.neoutils.xregex.flavor

import com.neoutils.xregex.XMatch
import com.neoutils.xregex.XRegex
import com.neoutils.xregex.extension.findAll
import kotlin.test.Test
import kotlin.test.assertEquals

class PcreFlavorTest {

    @Test
    fun subroutineReference() {

        val expected = listOf(
            XMatch(
                index = 0,
                text = "((XRegex))",
                range = 0..9,
                groups = listOf(
                    XMatch.Group(
                        index = 0,
                        text = "((XRegex))",
                        range = 0..9
                    ),
                    XMatch.Group(
                        index = 1,
                        text = "((XRegex))",
                        range = 0..9
                    ),
                    XMatch.Group(
                        index = 2,
                        text = "(XRegex)",
                        range = 1..8
                    ),
                )
            )
        )

        val actual = XRegex(
            pattern = "(\\((\\w+|(?1))*\\))",
            flags = listOf(XRegex.Flag.PCRE)
        ).findAll(
            text = "((XRegex))"
        )

        assertEquals(
            expected,
            actual
        )
    }

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
            pattern = "\\w+",
            flags = listOf(XRegex.Flag.PCRE)
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
            pattern = "\\w",
            flags = listOf(XRegex.Flag.PCRE)
        ).findAll(
            text = "XRegex"
        )

        assertEquals(
            expected,
            actual
        )
    }

    @Test
    fun captureGroups() {

        val expected = listOf(
            XMatch(
                index = 0,
                text = "name = XRegex",
                range = 0..12,
                groups = listOf(
                    XMatch.Group(
                        index = 0,
                        text = "name = XRegex",
                        range = 0..12,
                    ),
                    XMatch.Group(
                        index = 1,
                        text = """name""",
                        range = 0..3,
                    ),
                    XMatch.Group(
                        index = 2,
                        text = """XRegex""",
                        range = 7..12,
                    ),
                )
            )
        )

        val actual = XRegex(
            pattern = "(\\w+)\\s*=\\s*(\\w+)",
            flags = listOf(XRegex.Flag.PCRE)
        ).findAll(
            text = "name = XRegex"
        )

        assertEquals(
            expected,
            actual
        )
    }
}