package me.glatteis.paternoster.operations

import me.glatteis.paternoster.Operation
import me.glatteis.paternoster.findOperation

/**
 * Created by Linus on 05.06.2016!
 */
class AssignOperation : Operation() {
    var operation: Operation? = null
    var variableOperation: VariableOperation? = null
    override fun add(char: Char) {
        if (char == '$') {
            variableOperation = VariableOperation()
            return
        }
        if (variableOperation != null && !(variableOperation as VariableOperation).finished) {
            variableOperation?.add(char)
            return
        }
        if (operation == null) {
            operation = findOperation(char)
            return
        }
        (operation as Operation).add(char)
        if ((operation as Operation).finished) {
            val result = operation?.result() ?: "NULL"
            variableOperation?.saveVariable(result)
            finished = true
        }
    }
}