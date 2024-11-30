import com.neoutils.regexp.extension.findAll
import com.neoutils.regexp.extension.toRegExp

fun main() {
    println("\\w+".toRegExp().findAll("name"))
}