package me.glatteis.paternoster.operations.comparison

import me.glatteis.paternoster.Operation
import me.glatteis.paternoster.Pointing
import me.glatteis.paternoster.findOperation

/**
 * Created by Linus on 05.06.2016!
 */
class ConditionOperation : Operation() {

    var operation: Operation? = null
    var firstChar = true

    override fun add(char: Char) {
        if (firstChar) {
            firstChar = false
            return
        }
        if (operation == null) {
            if (char == ' ') return
            operation = findOperation(char)
        }
        if (operation != null && !(operation!!.finished)) {
            operation!!.add(char)
            return
        }
        if (operation!!.finished) {
            if (char == ' ') return
            val result = operation!!.result() == 1F
            if (!result && operation!!.result() != 0F) throw UnsupportedOperationException("Boolean must be 0 or 1, was " + operation!!.result())
            finished = true
            if (!result) return //Continue when false
            var direction = '!'
            when (char) {
                '↿', '↾' -> direction = '↑'
                '⇃', '⇂' -> direction = '↓'
                '↼', '↽' -> direction = '←'
                '⇀', '⇁' -> direction = '→'
            }
            if (direction == '!') throw UnsupportedOperationException("$char is not a valid arrow for conditions.")
            Pointing.direction.setDirection(direction)
        }
    }


}