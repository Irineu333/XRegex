import com.neoutils.xregex.extension.findAll
import com.neoutils.xregex.extension.toXRegex
import kotlinx.browser.document

fun main() {
    document.write("\\w+".toXRegex().findAll("name").toString())
}
