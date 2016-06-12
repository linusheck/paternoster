package me.glatteis.paternoster.operations

import me.glatteis.paternoster.Operation
import me.glatteis.paternoster.Pointing
import me.glatteis.paternoster.extendCode
import me.glatteis.paternoster.findOperation
import java.util.*

/**
 * Created by Linus on 12.06.2016!
 */
class ModifyOperation : Operation() {

    val operations = ArrayList<Operation>()
    var firstChar = true

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
        if (operations.size == 3 && operations.last().finished) {
            val coordinateX = operations[0].result()
            val coordinateY = operations[1].result()
            if (coordinateX !is Number || coordinateY !is Number) throw UnsupportedOperationException("m: x and y must be numbers")
            val x = coordinateX.toInt()
            val y = coordinateY.toInt()
            val string = operations[2].result().toString()
            if (string.length != 1) throw UnsupportedOperationException("m: String must be exactly 1 character long")
            extendCode(x, y)
            Pointing.code[x][y] = string.toCharArray()[0]
        }
    }

}