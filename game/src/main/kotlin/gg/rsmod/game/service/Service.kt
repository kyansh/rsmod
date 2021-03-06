package gg.rsmod.game.service

import gg.rsmod.game.Server
import gg.rsmod.game.model.World
import gg.rsmod.util.ServerProperties

/**
 * Any service that should be initialized when our server is starting up.
 *
 * @author Tom <rspsmods@gmail.com>
 */
abstract class Service {

    /**
     * Called when the server is starting up.
     */
    abstract fun init(server: Server, world: World, serviceProperties: ServerProperties)

    /**
     * Called after the server has finished started up.
     */
    abstract fun postLoad(server: Server, world: World)

    /**
     * Called when the server is shutting off.
     */
    abstract fun terminate(server: Server, world: World)

}