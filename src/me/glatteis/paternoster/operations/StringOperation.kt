package me.glatteis.paternoster.operations

import me.glatteis.paternoster.Operation

/**
 * Created by Linus on 05.06.2016!
 */
class StringOperation: Operation() {
    var string = ""
    override fun add(char: Char) {
        if (char == '"') finished = true
        else string += char
    }
    override fun result(): Any {
        return string
    }
}