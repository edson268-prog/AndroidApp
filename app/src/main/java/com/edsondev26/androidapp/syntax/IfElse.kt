package com.edsondev26.androidapp.syntax

fun main() {
    basicIf("Edson")
    nestedIf("Toucan")
    orAndExample("Adriana")
    getSemester(2)
}

fun basicIf(name:String) {
    if(name == "Pepe"){
        println("The name is Pepe")
    } else {
        println("The name is not Pepe is $name" )
    }
}

fun nestedIf(animal:String) {
    val result = when (animal) {
        "Dog" -> "It's a dog"
        "Cat" -> "It's a cat"
        "Vulture", "Toucan", "Hummingbird" -> "It's a bird"
        else -> "Is other animal"
    }
    println(result)
}

fun getSemester(month: Int) {
    when(month) {
        in 1..6 -> println("First Semester")
        in 7..12 -> println("Second Semester")
        !in 1..12 -> println("Semester not valid!!")
    }
}

fun orAndExample(name:String) {
    if(name == "Edson" || name == "Pepe") {
        println("The name is valid!!")
    }
    else {
        println("The name is not valid!!")
    }
}