package gg.rsmod.plugins.osrs.content.npcs

import gg.rsmod.game.model.entity.Player
import gg.rsmod.game.plugin.Plugin
import gg.rsmod.plugins.osrs.api.InterfaceDestination
import gg.rsmod.plugins.osrs.api.cfg.Npcs
import gg.rsmod.plugins.osrs.api.ext.*

arrayOf(Npcs.BANKER, Npcs.BANKER_395).forEach { banker ->
    on_npc_option(npc = banker, option = "talk-to", lineOfSightDistance = 2) {
        it.suspendable { dialog(it) }
    }
    on_npc_option(npc = banker, option = "bank", lineOfSightDistance = 2) {
        it.player().openBank()
    }
    on_npc_option(npc = banker, option = "collect", lineOfSightDistance = 2) {
        open_collect(it.player())
    }
}

suspend fun dialog(it: Plugin) {
    it.chatNpc("Good day, how may I help you?")
    when (options(it)) {
        1 -> it.player().openBank()
        2 -> open_pin(it.player())
        3 -> open_collect(it.player())
        4 -> what_is_this_place(it)
    }
}

suspend fun options(it: Plugin): Int = it.options("I'd like to access my bank account, please.", "I'd like to check my PIN settings.", "I'd like to collect items.", "What is this place?")

suspend fun what_is_this_place(it: Plugin) {
    it.chatNpc("This is a branch of the Bank of Gielinor. We have<br>branches in many towns.", animation = 568)
    it.chatPlayer("And what do you do?", animation = 554)
    it.chatNpc("We will look after your items and money for you.<br>Leave your valuables with us if you want to keep them<br>safe.", animation = 569)
}

fun open_collect(p: Player) {
    p.setInterfaceUnderlay(color = -1, transparency = -1)
    p.openInterface(interfaceId = 402, dest = InterfaceDestination.MAIN_SCREEN)
}

fun open_pin(p: Player) {
    p.setInterfaceUnderlay(color = -1, transparency = -1)
    p.openInterface(interfaceId = 14, dest = InterfaceDestination.MAIN_SCREEN)
}