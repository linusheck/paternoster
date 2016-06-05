package me.glatteis.paternoster

import me.glatteis.paternoster.operations.*
import me.glatteis.paternoster.operations.comparison.*
import me.glatteis.paternoster.operations.math.AddOperation
import me.glatteis.paternoster.operations.math.DivOperation
import me.glatteis.paternoster.operations.math.MulOperation
import me.glatteis.paternoster.operations.math.SubOperation
import java.util.*
import java.util.concurrent.locks.Condition

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
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.' -> return NumberOperation()
        '+' -> return AddOperation()
        '-' -> return SubOperation()
        '*' -> return MulOperation()
        '/' -> return DivOperation()
        '?' -> return ConditionOperation()
        '=' -> return EqualsOperation()
        '>' -> return BiggerThanOperation()
        '<' -> return SmallerThanOperation()
        'X' -> System.exit(0)
        ' ' -> return null //Skip whitespace
    }
    throw UnsupportedOperationException("paternoster does not know that char: " + initChar)
}