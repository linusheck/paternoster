package me.glatteis.paternoster

import me.glatteis.paternoster.operations.AssignOperation
import me.glatteis.paternoster.operations.PrintOperation
import me.glatteis.paternoster.operations.StringOperation
import me.glatteis.paternoster.operations.VariableOperation
import java.util.*

object RAM {
    val variables = HashMap<String, Any>()
    var operation: Operation? = null
}

class Direction(var x: Int, var y: Int) {
    fun setDirection(arrow: Char) {
        when (arrow) {
            '←', '↤' -> set(0, -1)
            '↑', '↥' -> set(-1, 0)
            '→', '↦' -> set(0, 1)
            '↓', '↧' -> set(1, 0)
            '↖' -> set(-1, -1)
            '↗' -> set(-1, 1)
            '↘' -> set(1, 1)
            '↙' -> set(1, -1)
        }
    }
    fun set(x: Int, y: Int) {
        this.x = x
        this.y = y
    }
}
class Location(var x: Int, var y: Int) {
    fun add(direction: Direction) {
        x += direction.x
        y += direction.y
    }
}

fun findOperation(initChar: Char): Operation? {
    when (initChar) {
        'A' -> return AssignOperation()
        '"' -> return StringOperation()
        'P' -> return PrintOperation()
        '$' -> return VariableOperation()
        'X' -> System.exit(0)
        ' ' -> return null //Skip whitespace
    }
    throw UnsupportedOperationException("paternoster does not know that char: " + initChar)
}