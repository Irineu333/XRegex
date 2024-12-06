import com.neoutils.xregex.XRegex
import com.neoutils.xregex.extension.findAll
import com.neoutils.xregex.extension.toXRegex

fun main() {
    println(
        "(\\((\\w+|(?1))\\))".toXRegex(
            flags = listOf(XRegex.Flag.PCRE)
        ).findAll("((name))")
    )
}