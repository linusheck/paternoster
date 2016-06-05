package me.glatteis.paternoster.operations

import me.glatteis.paternoster.Operation
import me.glatteis.paternoster.RAM

/**
 * Created by Linus on 05.06.2016!
 */
class VariableOperation: Operation() {
    var variableName: String = ""
    override fun add(char: Char) {
        if (char == '$') return
        if (char == ' ') {
            finished = true
            return
        }
        variableName += char
    }
    fun saveVariable(value: Any?) {
        RAM.variables.put(variableName, value ?: "NULL")
    }
    override fun result(): Any? {
        return RAM.variables[variableName]
    }
}