package me.glatteis.paternoster.operations

import me.glatteis.paternoster.Operation
import me.glatteis.paternoster.Pointing

/**
 * Created by Linus on 06.06.2016!
 */
class SkipOperation: Operation() {
    override fun init() {
        Pointing.location.add(Pointing.direction)
    }
}