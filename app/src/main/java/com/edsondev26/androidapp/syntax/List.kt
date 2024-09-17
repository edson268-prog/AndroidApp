package com.edsondev26.androidapp.syntax

fun main() {
//    immutableList()
    mutableList()
}

fun mutableList() {
    val weekDays:MutableList<String> = mutableListOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    weekDays.add(3, "EdDay")
    println(weekDays)

    if (weekDays.isNotEmpty())
    {
        weekDays.forEach() {weekday -> println(weekday) }
    }

    println("The first day is: ${weekDays.first()}")
    println("The last day is: ${weekDays.last()}")
}

fun immutableList(){
    val readOnly:List<String> = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    println(readOnly.size)
    println(readOnly)
    println(readOnly[0])
    println(readOnly.last())
    println(readOnly.first())

    val example = readOnly.filter { it.contains("on") }
    println(example)

    readOnly.forEach() {weekDay -> println(weekDay)}
}