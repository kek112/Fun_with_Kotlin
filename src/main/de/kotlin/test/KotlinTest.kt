package main.de.kotlin.test

/*
 * This content was receated from the Talk Introduction to Kotlin Google I/O 17
 * https://www.youtube.com/watch?v=X1RVYt2QKQE&t=2042s
 */

import java.lang.IllegalArgumentException
import java.math.BigDecimal

data class Money(val amount: BigDecimal, val currency: String)

fun sum(x: Int, y: Int) = x + y

fun convertToDollars(money: Money): Money {
    return when (money.currency){
        "$" ->  money
        "Euro" -> Money(money.amount * BigDecimal(1.10),"$2")
        else -> throw IllegalArgumentException("Not the right currency")
    }
}
fun BigDecimal.percent(percentage: Int) = this.multiply(BigDecimal(percentage)).divide(BigDecimal(100))

fun Int.percentOf(money: Money) = money.amount.multiply(BigDecimal(this).divide(BigDecimal(100)))

fun main() {
    val tickets = Money(BigDecimal(100),"$")
    val popcorn = tickets.copy(BigDecimal(500), "Euro ")

    if (tickets != popcorn) {
        println("different ")
    }

    val bd1 = BigDecimal(100)

    println(7.percentOf(popcorn))

    println(bd1.percent(7))
}

