package com.edsondev26.androidapp.syntax

fun main() {
//    var name:String? = null
    val name:String? = "EdsonDev26"

//    println(name!!.get(3))
    println(name?.get(3) ?: "It is null")
}