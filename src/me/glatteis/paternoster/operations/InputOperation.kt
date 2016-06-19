package me.glatteis.paternoster.operations

import me.glatteis.paternoster.Operation

/**
 * Created by Linus on 12.06.2016!
 */
class InputOperation() : Operation() {

    val line = readLine()
    var result: Any = Unit

    init {
        result = line ?: ""
        finished = true
    }

    override fun result(): Any {
        return result
    }

}