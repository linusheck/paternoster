package me.glatteis.paternoster.operations.comparison

import me.glatteis.paternoster.Operation
import me.glatteis.paternoster.PaternosterException
import me.glatteis.paternoster.findOperation
import me.glatteis.paternoster.operations.math.MathOperation

/**
 * Created by Linus on 05.06.2016!
 */
class EqualsOperation : MathOperation() {
    override fun doMath(x: Float, y: Float): Float {
        if (x == y) return 1F
        return 0F
    }
}

class BiggerThanOperation : MathOperation() {
    override fun doMath(x: Float, y: Float): Float {
        if (x > y) return 1F
        return 0F
    }
}

class SmallerThanOperation : MathOperation() {
    override fun doMath(x: Float, y: Float): Float {
        if (x < y) return 1F
        return 0F
    }
}

class NotOperation(): Operation() {
    var operation: Operation? = null
    var firstChar = true
    var result = 0F
    override fun add(char: Char) {
        if (firstChar) {
            firstChar = false
            return
        }
        if (char != ' ' && operation == null) {
            operation = findOperation(char)
        }
        if (operation == null) return
        if (!operation!!.finished) {
            operation!!.add(char)
            return
        }
        if (operation!!.result() == 1F) {
            result = 0F
        } else if (operation!!.result() == 0F) {
            result = 1F
        } else {
            throw PaternosterException("Can only invert 1 or 0.")
        }
        finished = true
    }
    override fun result(): Any {
        return result
    }
}