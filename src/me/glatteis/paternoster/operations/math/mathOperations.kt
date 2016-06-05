package me.glatteis.paternoster.operations.math

/**
 * Created by Linus on 05.06.2016!
 */

class AddOperation: MathOperation() {
    override fun doMath(x: Float, y: Float): Float {
        return x + y
    }
}

class SubOperation: MathOperation() {
    override fun doMath(x: Float, y: Float): Float {
        return x - y
    }
}

class MulOperation: MathOperation() {
    override fun doMath(x: Float, y: Float): Float {
        return x * y
    }
}

class DivOperation: MathOperation() {
    override fun doMath(x: Float, y: Float): Float {
        return x / y
    }
}
