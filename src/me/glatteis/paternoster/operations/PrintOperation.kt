package me.glatteis.paternoster.operations

import me.glatteis.paternoster.Operation
import me.glatteis.paternoster.PlaceholderOperation
import me.glatteis.paternoster.findOperation

/**
 * Created by Linus on 05.06.2016!
 */

class PrintOperation(val newLine: Boolean): Operation() {

    var operation: Operation = PlaceholderOperation
    var firstChar = true

    override fun add(char: Char) {
        if (firstChar) {
            firstChar = false
            return
        }
        if (operation == PlaceholderOperation) {
            operation = findOperation(char) ?: return
        }

        if (!operation.finished) {
            operation.add(char)
        }

        if (operation.finished) {
            if (newLine) {
                println(operation.result())
            } else {
                print(operation.result())
            }
            finished = true
        }
    }
}