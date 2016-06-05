package me.glatteis.paternoster.operations

import me.glatteis.paternoster.Operation

/**
 * Created by Linus on 05.06.2016!
 */
class NumberOperation: Operation() {
    val numberChars = listOf<Char>('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.')
    var numberString = ""
    override fun add(char: Char) {

        if (!numberChars.contains(char)) finished = true
        else numberString += char
    }
    override fun result(): Float {
        return numberString.toFloat()
    }
}