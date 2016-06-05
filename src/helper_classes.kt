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
        ' ' -> return null //Skip whitespace
    }
    throw UnsupportedOperationException("paternoster does not know that char: " + initChar)
}
abstract class Operation {
    var finished = false
    constructor() {
        init()
    }
    open fun init() {}
    open fun add(char: Char) {}
    open fun result(): Any? {
        return null
    }
}
class AssignOperation : Operation() {
    var operation: Operation? = null
    var variableOperation: VariableOperation? = null
    override fun add(char: Char) {
        if (char == '$') {
            variableOperation = VariableOperation()
            return
        }
        if (variableOperation != null && !(variableOperation as VariableOperation).finished) {
            variableOperation?.add(char)
            return
        }
        if (operation == null) {
            operation = findOperation(char)
            return
        }
        (operation as Operation).add(char)
        if ((operation as Operation).finished) {
            val result = operation?.result() ?: "NULL"
            variableOperation?.saveVariable(result)
            finished = true
        }
    }
}
class StringOperation: Operation() {
    var string = ""
    override fun add(char: Char) {
        if (char == '"') finished = true
        else string += char
    }
    override fun result(): Any {
        return string
    }
}
class VariableOperation: Operation() {
    var variableName: String = ""
    override fun add(char: Char) {
        if (char == ' ') {
            finished = true
            return
        }
        variableName += char
    }
    fun saveVariable(value: Any?) {
        RAM.variables.put(variableName, value ?: "NULL")
    }
    override fun result(): Any? {
        return RAM.variables[variableName]
    }
}
class PrintOperation: Operation() {
    var operation: Operation? = null
    override fun init() {}
    override fun add(char: Char) {
        if (char == ' ' && operation == null) return
        if (char != ' ' && operation == null) {
            operation = findOperation(char)
            return
        }
        if (!operation!!.finished) {
            operation!!.add(char)
            return
        }
        println(operation!!.result())
        finished = true
    }
}