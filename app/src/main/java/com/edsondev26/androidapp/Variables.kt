package com.edsondev26.androidapp

fun main(){
    /**
     * Numeric Variables
     */

    // Int
    val age:Int = 30
    val age2 = 29
    // Long
    val example:Long = 30
    // Float
    val floatExample:Float = 30.5f
    // Double
    val doubleExample:Double = 3241.3123155

    /**
     * AlphaNumerics Variables
     */

    // Char
    val charExample1:Char = 'e'
    val charExample2:Char = '2'
    val charExample3:Char = '@'

    // String
    val stringExample:String = "EdsonDev26"

    /**
     * Boolean Variables
     */

    // Boolean
    val booleanExample1:Boolean = true
    val booleanExample2:Boolean = false

    // Concatenated
    val concatenatedString = "Hello, my name is $stringExample"
    println(concatenatedString)

    // Convert
    val exampleString123:String = age.toString()
}