package me.glatteis.paternoster.operations

import me.glatteis.paternoster.Operation
import me.glatteis.paternoster.findOperation

/**
 * Created by Linus on 05.06.2016!
 */

class PrintOperation: Operation() {
    var operation: Operation? = null
    override fun init() {}
    override fun add(char: Char) {
        if ((char == ' ' || char == 'P' ) && operation == null) return
        if (char != ' ' && operation == null) {
            operation = findOperation(char)
        }
        if (!(operation!!.finished)) {
            operation!!.add(char)
        }
        if (operation!!.finished) {
            println(operation!!.result())
            finished = true
        }
    }
}