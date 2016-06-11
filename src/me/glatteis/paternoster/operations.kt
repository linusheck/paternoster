package me.glatteis.paternoster

abstract class Operation {
    var finished = false
    open fun add(char: Char) {}
    open fun result(): Any? {
        return null
    }
}