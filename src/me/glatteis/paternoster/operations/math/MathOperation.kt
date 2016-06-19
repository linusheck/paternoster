package me.glatteis.paternoster.operations.math

import me.glatteis.paternoster.Operation
import me.glatteis.paternoster.PaternosterException
import me.glatteis.paternoster.PlaceholderOperation
import me.glatteis.paternoster.findOperation

/**
 * Created by Linus on 05.06.2016!
 */
abstract class MathOperation : Operation() {
    var operationOne: Operation = PlaceholderOperation
    var operationTwo: Operation = PlaceholderOperation
    var result: Any? = null
    var firstChar = true
    override fun add(char: Char) {
        if (firstChar) {
            println(char)
            firstChar = false
            return
        }
        if (operationOne == PlaceholderOperation) {
            operationOne = findOperation(char) ?: return
        }
        if (!operationOne.finished) {
            operationOne.add(char)
        }
        if (!operationOne.finished) return
        if (operationTwo == PlaceholderOperation) {
            operationTwo = findOperation(char) ?: return
        }
        if (!operationTwo.finished) {
            operationTwo.add(char)
        }
        if (!operationTwo.finished) return
        val resultOne = operationOne.result()
        val resultTwo = operationTwo.result()
        if (resultOne is Number && resultTwo is Number) {
            result = doMath(resultOne as Float, resultTwo as Float)
            finished = true
            return
        }
        if (resultOne is String && resultTwo is String) {
            if (this is AddOperation) {
                result = resultOne + resultTwo
                finished = true
                return
            }
        }
        throw PaternosterException("Cannot concat $resultOne and $resultTwo.")
    }

    override fun result(): Any? {
        return result
    }

    abstract fun doMath(x: Float, y: Float): Float
}