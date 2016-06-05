package me.glatteis.paternoster.operations

import me.glatteis.paternoster.Operation

/**
 * Created by Linus on 05.06.2016!
 */
class NumberOperation: Operation() {
    var numberString = ""
    override fun add(char: Char) {
        if (char == ' ') finished = true
        else numberString += char
    }
    override fun result(): Float {
        return numberString.toFloat()
    }
}