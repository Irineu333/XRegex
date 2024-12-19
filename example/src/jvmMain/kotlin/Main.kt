import com.neoutils.xregex.Flavor
import com.neoutils.xregex.extension.findAll
import com.neoutils.xregex.extension.xRegex

fun main() {
    val pattern = "(\\((\\w+|(?1))\\))"

    val xRegex = pattern.xRegex().apply {
        flavors.jvm = Flavor.JVM.PCRE
    }

    println(
        xRegex.findAll("((name))")
    )
}