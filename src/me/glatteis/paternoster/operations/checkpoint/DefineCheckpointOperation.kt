package me.glatteis.paternoster.operations.checkpoint

import me.glatteis.paternoster.Operation
import me.glatteis.paternoster.Pointing
import me.glatteis.paternoster.RAM

/**
 * Created by Linus on 11.06.2016!
 */
class DefineCheckpointOperation : Operation() {

    init {
        RAM.checkpoint = Checkpoint(Pointing.location.clone(), Pointing.direction.clone())
        finished = true
    }

}