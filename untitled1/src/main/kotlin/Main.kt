import java.io.FileInputStream

fun main(args: Array<String>) {
    val finps = FileInputStream("data.csv")
    val lines:List<Any> =  finps.reader().readLines()
    lines.forEach {
        println(it)
    }

}
