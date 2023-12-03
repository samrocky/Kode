fun main() {
    val a = arrayOf(1, 2, 3, 4, 5, 6)
    for (i in a.indices) {
        a[i] = a[i] * 2
    }
    a.forEach {
        println(it)
    }
    println(a.indices)
}

