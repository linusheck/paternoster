package me.glatteis.paternoster

import java.io.FileInputStream
import java.util.*

/*

paternoster is a programming language by glatteis

 */

object Pointing {
    var direction = Direction(0, 0)
    var location = Location(0, 0)
}

val startArrows = listOf<Char>('↤', '↥', '↦', '↧')
val arrows = listOf<Char>('←', '↑', '→', '↓', '↖', '↗', '↘', '↙') + startArrows

var code: ArrayList<ArrayList<Char>> = ArrayList<ArrayList<Char>>()
var currentChar: Char = '!'

fun main(args: Array<String>) {
    if (args.size == 0) throw UnsupportedOperationException("You have to specify a file.")
    val file = args[0]
    val scanner = Scanner(FileInputStream(file))
    var codeAsString = ""
    while (scanner.hasNextLine()) {
        codeAsString += scanner.nextLine() + "\n"
    }
    createCodeInListForm(codeAsString)
    Pointing.location = findStart() ?: throw UnsupportedOperationException("No start defined!")
    do {
        //println(me.glatteis.paternoster.getLocation.x.toString() + " " + me.glatteis.paternoster.getLocation.y.toString())
        currentChar = code[Pointing.location.x][Pointing.location.y]

        if (arrows.contains(currentChar)) {
            Pointing.direction.setDirection(currentChar)
            Pointing.location.add(Pointing.direction)
            continue
        }

        if (RAM.operation != null && RAM.operation?.finished!!) {
            RAM.operation = null
        }
        if (RAM.operation == null) {
            val newOperation = findOperation(currentChar)
            RAM.operation = newOperation
        }
        if (RAM.operation != null) {
            RAM.operation!!.add(currentChar)
        }

        Pointing.location.add(Pointing.direction)
    } while (true)
}

fun findStart(): Location? {
    code.forEachIndexed { i, arrayList ->
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
        code.add(list)
        for (i in 0.until(sizeY)) {
            if (line.length <= i) list.add(' ')
            else list.add(line[i])
        }
    }
}


