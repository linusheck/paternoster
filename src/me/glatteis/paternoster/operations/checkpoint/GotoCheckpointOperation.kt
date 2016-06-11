package me.glatteis.paternoster.operations.checkpoint

import me.glatteis.paternoster.Operation
import me.glatteis.paternoster.Pointing
import me.glatteis.paternoster.RAM

/**
 * Created by Linus on 11.06.2016!
 */
class GotoCheckpointOperation : Operation() {

    init {
        val checkpoint = RAM.checkpoint ?: throw RuntimeException("Goto Checkpoint called, yet no checkpoint defined.")
        Pointing.location = checkpoint.location.clone()
        Pointing.direction = checkpoint.direction.clone()
        finished = true
    }

}