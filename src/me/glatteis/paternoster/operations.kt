package me.glatteis.paternoster

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