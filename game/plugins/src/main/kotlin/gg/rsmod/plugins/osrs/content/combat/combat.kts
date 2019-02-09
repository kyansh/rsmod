
import gg.rsmod.game.action.PawnPathAction
import gg.rsmod.game.model.COMBAT_TARGET_FOCUS_ATTR
import gg.rsmod.game.model.FROZEN_TIMER
import gg.rsmod.game.model.MovementQueue
import gg.rsmod.game.model.Tile
import gg.rsmod.game.model.entity.Entity
import gg.rsmod.game.model.entity.Player
import gg.rsmod.game.model.path.PathFindingStrategy
import gg.rsmod.game.plugin.Plugin
import gg.rsmod.plugins.osrs.api.EquipmentType
import gg.rsmod.plugins.osrs.api.cfg.Items
import gg.rsmod.plugins.osrs.api.helper.*
import gg.rsmod.plugins.osrs.content.combat.Combat
import gg.rsmod.plugins.osrs.content.combat.CombatConfigs
import gg.rsmod.plugins.osrs.content.combat.formula.MeleeCombatFormula
import gg.rsmod.plugins.osrs.content.combat.strategy.magic.CombatSpell
import gg.rsmod.plugins.osrs.content.inter.attack.AttackTab

onCommand("max") {
    val player = it.player()
    var specialAttackMultiplier = 1.0
    var specialPassiveMultiplier = 1.0
    if (player.hasEquipped(EquipmentType.WEAPON, Items.ARMADYL_GODSWORD, Items.ARMADYL_GODSWORD_OR) && AttackTab.isSpecialEnabled(player)) {
        specialAttackMultiplier = 1.1
        specialPassiveMultiplier = 1.25
    }
    val accuracy = MeleeCombatFormula.getAccuracy(player, player)
    val landHit = accuracy >= player.world.randomDouble()
    val max = MeleeCombatFormula.getMaxHit(player, player, specialAttackMultiplier, specialPassiveMultiplier)
    player.message("Max hit=$max - accuracy=$accuracy - land=$landHit")
}

onCombat {
    it.suspendable {
        while (true) {
            if (!cycle(it)) {
                break
            }
            it.wait(1)
        }
    }
}

suspend fun cycle(it: Plugin): Boolean {
    val pawn = it.pawn()
    val target = pawn.attr[COMBAT_TARGET_FOCUS_ATTR]

    if (target == null) {
        pawn.facePawn(null)
        return false
    }

    if (!pawn.lock.canAttack()) {
        return false
    }

    pawn.facePawn(target)

    if (target.isDead()) {
        return false
    }

    if (pawn is Player) {
        pawn.setVarp(Combat.PRIORITY_PID_VARP, target.index)

        if (!pawn.attr.has(Combat.CASTING_SPELL) && pawn.getVarbit(Combat.SELECTED_AUTOCAST_VARBIT) != 0) {
            val spell = CombatSpell.values.firstOrNull { it.autoCastId == pawn.getVarbit(Combat.SELECTED_AUTOCAST_VARBIT) }
            if (spell != null) {
                pawn.attr[Combat.CASTING_SPELL] = spell
            }
        }
    }

    val strategy = CombatConfigs.getCombatStrategy(pawn)
    val attackRange = strategy.getAttackRange(pawn)

    val pathFound = PawnPathAction.walkTo(it, pawn, target, attackRange)
    if (!pathFound) {
        pawn.movementQueue.clear()
        if (pawn.getType().isNpc()) {
            /**
             * Npcs will keep trying to find a path to engage in combat.
             */
            return true
        }
        if (pawn is Player) {
            if (!pawn.timers.has(FROZEN_TIMER)) {
                pawn.message(Entity.YOU_CANT_REACH_THAT)
            }
            pawn.clearMapFlag()
        }
        pawn.facePawn(null)
        Combat.reset(pawn)
        return false
    }

    pawn.movementQueue.clear()

    if (Combat.isAttackDelayReady(pawn)) {
        if (Combat.canAttack(pawn, target, strategy)) {
            strategy.attack(pawn, target)
            Combat.postAttack(pawn, target)
        } else {
            Combat.reset(pawn)
        }
    }
    return true
}