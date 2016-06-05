package me.glatteis.paternoster.operations.comparison

import me.glatteis.paternoster.operations.math.MathOperation

/**
 * Created by Linus on 05.06.2016!
 */
class EqualsOperation : MathOperation() {
    override fun doMath(x: Float, y: Float): Float {
        if (x == y) return 1F
        return 0F
    }
}

class BiggerThanOperation : MathOperation() {
    override fun doMath(x: Float, y: Float): Float {
        if (x > y) return 1F
        return 0F
    }
}

class SmallerThanOperation : MathOperation() {
    override fun doMath(x: Float, y: Float): Float {
        if (x < y) return 1F
        return 0F
    }
}