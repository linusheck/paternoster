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
        if (variableOperation == null && char == 'A') return
        if (variableOperation == null && char == '$') {
            variableOperation = VariableOperation()
        }
        if (variableOperation != null && !(variableOperation as VariableOperation).finished) {
            variableOperation?.add(char)
            return
        }
        if (variableOperation == null) return
        if (operation == null) {
            operation = findOperation(char)
        }
        operation!!.add(char)
        if (operation!!.finished) {
            val result = operation!!.result() ?: "NULL"
            variableOperation!!.saveVariable(result)
            finished = true
        }
    }
}