import com.neoutils.regexp.extension.findAll
import com.neoutils.regexp.extension.toRegExp
import kotlinx.browser.document

fun main() {
    document.write("\\w+".toRegExp().findAll("name").toString())
}
