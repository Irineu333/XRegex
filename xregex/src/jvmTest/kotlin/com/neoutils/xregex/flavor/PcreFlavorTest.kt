package com.neoutils.xregex.flavor

import com.neoutils.xregex.Flavor
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
            pattern = "(\\((\\w+|(?1))*\\))"
        ).apply {
            flavors.jvm = Flavor.JVM.PCRE
        }.findAll(
            text = "((XRegex))"
        )

        assertEquals(
            expected,
            actual
        )
    }
}