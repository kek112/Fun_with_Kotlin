package main.de.kotlin.test

data class Money(val amount: Int, val currency: String)

fun main() {
    val tickets = Money(100,"$")
    val popcorn = tickets.copy(500, "Euro ")

    if (tickets != popcorn) {
        println("different ")
    }

}


