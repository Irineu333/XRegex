package com.neoutils.regexp.extension

import com.neoutils.regexp.RegExp

fun String.toRegExp() = RegExp(pattern = this)