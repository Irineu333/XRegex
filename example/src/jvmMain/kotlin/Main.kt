import com.neoutils.xregex.extension.findAll
import com.neoutils.xregex.extension.toXRegex

fun main() {
    println("(\\w)(\\w)".toXRegex().findAll("name"))
}