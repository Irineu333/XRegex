package com.neoutils.regexp.extension

import com.neoutils.regexp.Match
import com.neoutils.regexp.RegExp

expect fun RegExp.findAll(text: String) : List<Match>