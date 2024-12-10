package com.neoutils.xregex.flavor

import com.neoutils.xregex.XMatch
import com.neoutils.xregex.XRegex
import com.neoutils.xregex.extension.findAll
import org.junit.Test
import kotlin.test.assertEquals

class JavaFlavorTest {

    @Test
    fun charsetChained() {

        val expected = listOf(
            XMatch(
                index = 0,
                text = "a",
                range = 0..0
            ),
            XMatch(
                index = 1,
                text = "b",
                range = 1..1
            ),
            XMatch(
                index = 2,
                text = "c",
                range = 5..5
            ),
            XMatch(
                index = 3,
                text = "d",
                range = 6..6
            )
        )

        val actual = XRegex(
            pattern = "[[ab][cd]]"
        ).findAll(
            text = "ab123cd"
        )

        assertEquals(
            expected,
            actual
        )
    }
}