package com.neoutils.xregex.extension

import com.neoutils.xregex.XRegex

fun String.toXRegex() = XRegex(pattern = this)