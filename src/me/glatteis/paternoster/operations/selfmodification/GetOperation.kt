package me.glatteis.paternoster.operations.selfmodification

import me.glatteis.paternoster.Operation
import me.glatteis.paternoster.Pointing
import me.glatteis.paternoster.extendCode
import me.glatteis.paternoster.findOperation
import java.util.*

/**
 * Created by Linus on 16.06.2016!
 */
class GetOperation : Operation() {

    val operations = ArrayList<Operation>()
    var firstChar = true
    var result = ' '

    override fun add(char: Char) {
        if (firstChar) {
            firstChar = false
            return
        }
        if (operations.isEmpty() || operations.last().finished) {
            val newOperation = findOperation(char) ?: return
            operations.add(newOperation)
        }
        operations.last().add(char)
        if (operations.size == 2 && operations.last().finished) {
            val coordinateX = operations[0].result()
            val coordinateY = operations[1].result()
            if (coordinateX !is Number || coordinateY !is Number) throw UnsupportedOperationException("m: x and y must be numbers")
            val x = coordinateX.toInt()
            val y = coordinateY.toInt()
            extendCode(x, y)
            result = Pointing.code[x][y]
        }
    }

    override fun result(): Char {
        return result
    }

}