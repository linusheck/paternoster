package me.glatteis.paternoster.operations

import me.glatteis.paternoster.Operation
import me.glatteis.paternoster.findOperation

/**
 * Created by Linus on 05.06.2016!
 */
class AssignOperation : Operation() {
    var operation: Operation? = null
    var variableOperation: NamespaceOperation? = null
    override fun add(char: Char) {
        if (variableOperation == null && (char == 'A' || char == ' ')) return
        if (variableOperation == null) {
            variableOperation = NamespaceOperation()
        }
        if (!(variableOperation?.finished ?: true)) {
            variableOperation?.add(char)
            return
        }
        if (operation == null) {
            operation = findOperation(char)
        }
        operation?.add(char)
        if (operation?.finished ?: false) {
            val result = operation!!.result() ?: "NULL"
            variableOperation?.saveVariable(result)
            finished = true
        }
    }
}