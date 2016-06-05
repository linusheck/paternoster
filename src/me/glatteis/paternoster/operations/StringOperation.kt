package me.glatteis.paternoster.operations

import me.glatteis.paternoster.Operation

/**
 * Created by Linus on 05.06.2016!
 */
class StringOperation: Operation() {
    var string = ""
    var firstChar = true
    override fun add(char: Char) {
        if (firstChar) {
            firstChar = false
            return
        }
        if (char == '"') finished = true
        else string += char
    }
    override fun result(): String {
        return string
    }
}