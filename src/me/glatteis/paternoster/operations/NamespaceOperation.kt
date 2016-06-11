package me.glatteis.paternoster.operations

import me.glatteis.paternoster.Operation
import me.glatteis.paternoster.RAM

/**
 * Created by Linus on 11.06.2016!
 */
class NamespaceOperation : Operation() {

    /*
    This operation is called when something that is not directly defined must be fetched.
    This can only be a variable at the moment.
     */

    var name = ""

    override fun add(char: Char) {
        if (char == ' ') {
            finished = true
            return
        }
        name += char
    }

    override fun result(): Any? {
        return RAM.variables[name]
    }

    fun saveVariable(value: Any?) {
        RAM.variables.put(name, value ?: "NULL")
    }

}