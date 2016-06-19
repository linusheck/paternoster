package me.glatteis.paternoster

import java.io.FileInputStream
import java.util.*

/*

paternoster is a programming language by glatteis

 */

object Pointing {
    var direction = Direction(0, 0)
    var location = Location(0, 0)
    var code = ArrayList<ArrayList<Char>>()
}

val startArrows = listOf('↤', '↥', '↦', '↧')
val arrows = listOf('←', '↑', '→', '↓', '↖', '↗', '↘', '↙') + startArrows

var currentChar: Char = ' '

fun main(args: Array<String>) {
    if (args.size == 0) throw PaternosterException("You have to specify a file")
    val file = args[0]
    val scanner = Scanner(FileInputStream(file), "UTF-8")
    var codeAsString = ""
    while (scanner.hasNextLine()) {
        codeAsString += scanner.nextLine() + "\n"
    }
    createCodeInListForm(codeAsString)

    Pointing.location = findStart() ?: throw PaternosterException("No start defined")
    do {
        currentChar = Pointing.code[Pointing.location.x][Pointing.location.y]

        if (arrows.contains(currentChar)) { //Change direction if needed.
            Pointing.direction.setDirection(currentChar)
            Pointing.location.add(Pointing.direction)
            continue
        }

        if (currentChar == '#') { // # means skip
            Pointing.location.add(Pointing.direction)
            Pointing.location.add(Pointing.direction)
            continue
        }

        if (currentChar == '|') { //Hold old operation and execute next operation.
            RAM.operationOnHold = RAM.operation
            RAM.operation = PlaceholderOperation
            Pointing.location.add(Pointing.direction)
            continue
        }

        if (RAM.operation != PlaceholderOperation && RAM.operation.finished) {
            RAM.operation = RAM.operationOnHold
            RAM.operationOnHold = PlaceholderOperation
        }
        if (RAM.operation == PlaceholderOperation) {
            val newOperation = findOperation(currentChar) ?: PlaceholderOperation
            RAM.operation = newOperation
        }
        if (RAM.operation != PlaceholderOperation) {
            RAM.operation.add(currentChar)
        }

        Pointing.location.add(Pointing.direction)
    } while (Pointing.location.x < Pointing.code.size && Pointing.location.y < Pointing.code[0].size)
}

fun findStart(): Location? {
    Pointing.code.forEachIndexed { i, arrayList ->
        arrayList.forEachIndexed { i2, c ->
            if (startArrows.contains(c)) {
                return Location(i, i2)
            }
        }
    }
    return null
}

fun createCodeInListForm(codeAsString: String) {
    var sizeY = 0
    for (line in codeAsString.split("\n")) {
        if (line.length > sizeY) sizeY = line.length
    }
    for (line in codeAsString.split('\n')) {
        val list = ArrayList<Char>()
        Pointing.code.add(list)
        for (i in 0.until(sizeY)) {
            if (line.length <= i) list.add(' ')
            else list.add(line[i])
        }
    }
}

fun extendCode(x: Int, y: Int) {
    for (line in Pointing.code.size..x + 1) {
        Pointing.code.add(ArrayList(Pointing.code[0].size))
        for (char in Pointing.code[0].size..y + 1) {
            Pointing.code[line].add(' ')
        }
    }
}


