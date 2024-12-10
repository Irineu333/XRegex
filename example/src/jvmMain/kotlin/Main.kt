import com.neoutils.xregex.Flavor
import com.neoutils.xregex.extension.findAll
import com.neoutils.xregex.extension.toXRegex

fun main() {
    val pattern = "(\\((\\w+|(?1))\\))"

    val xRegex = pattern.toXRegex().apply {
        flavors.jvm = Flavor.JVM.PCRE
    }

    println(
        xRegex.findAll("((name))")
    )
}