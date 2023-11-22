import java.awt.datatransfer.StringSelection
import java.io.FileInputStream
import java.security.MessageDigest

@OptIn(ExperimentalStdlibApi::class)
fun String.toSha256(): String{
    val bytes =
        MessageDigest.getInstance("sha256").digest(this.toByteArray())
    return bytes.toHexString()
}

fun String.read(): MutableList<Pair<String, String>> {
    val finps = FileInputStream(this)
    val lines:List<String> =  finps.reader().readLines()
    val linePairs:MutableList<Pair<String, String>> = mutableListOf()
    lines.forEach {
        val l = it.split(",")
        val line = Pair(l[0], l[1])
        linePairs += line
    }
    return linePairs
}
fun main(){

}

