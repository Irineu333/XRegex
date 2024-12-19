package com.neoutils.xregex.extension

import com.neoutils.xregex.Flavor
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

        val targets = listOf(
            XRegex(
                pattern = "\\w+"
            ),
            XRegex(
                pattern = "\\w+",
            ).apply {
                flavors.jvm = Flavor.JVM.PCRE
            }
        )

        val actual = targets.map {
            it.findAll(
                text = "XRegex"
            )
        }

        assertEquals(
            listOf(
                expected,
                expected
            ),
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

        val targets = listOf(
            XRegex(
                pattern = "\\w"
            ),
            XRegex(
                pattern = "\\w"
            ).apply {
                flavors.jvm = Flavor.JVM.PCRE
            }
        )

        val actual = targets.map {
            it.findAll(
                text = "XRegex"
            )
        }

        assertEquals(
            listOf(
                expected,
                expected
            ),
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
                        text = "name",
                        range = 0..3,
                    ),
                    XMatch.Group(
                        index = 2,
                        text = "XRegex",
                        range = 7..12,
                    ),
                )
            )
        )

        val targets = listOf(
            XRegex(
                pattern = "(\\w+)\\s*=\\s*(\\w+)",
            ),
            XRegex(
                pattern = "(\\w+)\\s*=\\s*(\\w+)"
            ).apply {
                flavors.jvm = Flavor.JVM.PCRE
            }
        )

        val actual = targets.map {
            it.findAll(
                text = "name = XRegex"
            )
        }

        assertEquals(
            listOf(
                expected,
                expected
            ),
            actual
        )
    }

    @Test
    fun specifyRange() {

        val expected = listOf(
            XMatch(
                index = 0,
                text = "XRegex",
                range = 4..9
            )
        )

        val targets = ".+".let {
            listOf(
                it.xRegex(),
                it.xRegex().apply {
                    flavors.jvm = Flavor.JVM.PCRE
                }
            )
        }

        val actual = targets.map {
            it.findAll(
                text = "The XRegex is multiplatform",
                range = 4..9
            )
        }

        assertEquals(
            listOf(
                expected,
                expected
            ),
            actual
        )
    }
}