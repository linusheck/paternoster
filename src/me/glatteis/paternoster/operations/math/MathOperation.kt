package me.glatteis.paternoster.operations.math

import me.glatteis.paternoster.Operation
import me.glatteis.paternoster.findOperation

/**
 * Created by Linus on 05.06.2016!
 */
abstract class MathOperation: Operation() {
    var operationOne: Operation? = null
    var operationTwo: Operation? = null
    var result: Any? = null
    var firstChar = true
    override fun add(char: Char) {
        if (firstChar) {
            firstChar = false
            return
        }
        if (operationOne == null) {
            if (char == ' ') return
            operationOne = findOperation(char)
        }
        if (operationOne != null && !(operationOne!!.finished)) {
            operationOne!!.add(char)
        }
        if (!operationOne!!.finished) {
            return
        }
        if (operationTwo == null) {
            if (char == ' ') return
            else operationTwo = findOperation(char)
        }
        if (operationTwo != null && !(operationTwo!!.finished)) {
            operationTwo!!.add(char)
        }
        if (!operationTwo!!.finished) {
            return
        }
        val resultOne = operationOne!!.result()
        val resultTwo = operationTwo!!.result()
        if ((resultOne is Number) && (resultTwo is Number)) { //Will extend for Strings. Maybe.
            result = doMath(resultOne as Float, resultTwo as Float)
            finished = true
            return
        }
        throw UnsupportedOperationException("Cannot concat $resultOne and $resultTwo.")
    }
    override fun result(): Any? {
        return result
    }
    abstract fun doMath(x: Float, y: Float): Float
}