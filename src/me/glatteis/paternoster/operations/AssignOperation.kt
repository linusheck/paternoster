package me.glatteis.paternoster.operations

import me.glatteis.paternoster.Operation
import me.glatteis.paternoster.PlaceholderOperation
import me.glatteis.paternoster.findOperation

/**
 * Created by Linus on 05.06.2016!
 */
class AssignOperation : Operation() {

    var operation: Operation = PlaceholderOperation

    val namespaceOperation: NamespaceOperation = NamespaceOperation()
    var namespaceOperationStarted = false

    override fun add(char: Char) {
        if (!namespaceOperationStarted) {
            if (char == 'A' || char == ' ') return
            namespaceOperationStarted = true
        }
        if (!namespaceOperation.finished) {
            namespaceOperation.add(char)
            return
        }
        if (operation == PlaceholderOperation) {
            operation = findOperation(char) ?: return
        }
        operation.add(char)
        if (operation.finished) {
            val result = operation.result() ?: "NULL"
            namespaceOperation.saveVariable(result)
            finished = true
        }
    }
}