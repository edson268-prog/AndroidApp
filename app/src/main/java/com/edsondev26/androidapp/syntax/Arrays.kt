package com.edsondev26.androidapp.syntax

val weekDays= arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

fun main() {
    println(weekDays[2])
    println(weekDays.size)
//    modifyValue()
    arrayLoop()
}

fun modifyValue() {
    println(weekDays[0])
    weekDays[0] = "Hello"
    println(weekDays[0])
}

fun arrayLoop() {
    for(position in weekDays.indices) {
        println(weekDays[position])
    }

    for((position, value) in weekDays.withIndex()) {
        println("The position $position contains the day $value")
    }

    for(day in weekDays) {
        println("Today is $day")
    }
}