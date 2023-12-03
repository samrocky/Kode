import java.time.LocalDateTime


fun main() {
    val a = Income(5000000, LocalDateTime.now(), "salary")
    val b = Expense(32000, LocalDateTime.now(), "cigarettes")
    a.view()

}

class Expense(
    private val quantity:Int,
    private val timaAndDate: LocalDateTime,
    private val reason: String
){
    init {
        println("Expense Initialized")
        // TODO("add to database")
    }
    fun view() {
        println("$quantity - $timaAndDate - $reason")
        return
    }
    fun returnInfo(): List<Any> {
        return listOf<Any>( quantity, timaAndDate, reason)
    }
    fun delete(){ TODO()}
}

class Income(
    private val quantity:Int,
    private val timaAndDate: LocalDateTime,
    private val reason: String
    ){
    init {
        println("Income Initialized")
        // TODO("add to database")
    }
    fun view() {
        println("$quantity - $timaAndDate - $reason")
    }
    fun returnInfo(): List<Any> {
        return listOf<Any>( quantity, timaAndDate, reason)
    }
    fun delete() { TODO() }
}

