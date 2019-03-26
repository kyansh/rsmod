package gg.rsmod.plugins.content.skills.thieving.pickpocketing

import gg.rsmod.game.model.attr.NPC_FACING_US_ATTR
import gg.rsmod.game.model.item.Item
import gg.rsmod.game.model.weight.WeightNode
import gg.rsmod.game.model.weight.WeightNodeSet
import gg.rsmod.game.model.weight.impl.WeightItem
import gg.rsmod.game.model.weight.impl.WeightItemSet
import gg.rsmod.plugins.api.cfg.Items
import gg.rsmod.plugins.api.cfg.Npcs

/**
 * @ids = an array of NPC ids for them to pickpocket
 * @exp = the amount of experience given per pickpocket
 * @lvl = the level requirement to pickpocket that npc
 * @npcName = the name of the NPC for the chat messages
 * @rewards = a 2d array of rewards
 */
enum class PickpocketInfo(val ids: IntArray, val exp: Double, val lvl: Int, val npcName: String,
                          val rewards: WeightNodeSet<Item>, val damage: IntRange, val stunTicks: Int) {
    MAN_WOMAN(
            ids = intArrayOf(
                    //Man NPC ID's
                    Npcs.MAN_3078, Npcs.MAN_3079, Npcs.MAN_3080, Npcs.MAN_3081, Npcs.MAN_3082,
                    Npcs.MAN_1138, Npcs.MAN_3014, Npcs.MAN_3101, Npcs.MAN_3109,
                    Npcs.MAN_3260, Npcs.MAN_3264, Npcs.MAN_3265, Npcs.MAN_3266, Npcs.MAN_3652,
                    Npcs.MAN_385, Npcs.MAN_4268, Npcs.MAN_4269, Npcs.MAN_4270, Npcs.MAN_4271,
                    Npcs.MAN_4272, Npcs.MAN_6776, Npcs.MAN_6987, Npcs.MAN_6988, Npcs.MAN_6989,
                    Npcs.MAN_7281, Npcs.MAN_7547, Npcs.MAN_7919, Npcs.MAN_7920,
                    //Woman NPC ID's
                    Npcs.WOMAN_1130, Npcs.WOMAN_1131, Npcs.WOMAN_1139, Npcs.WOMAN_1140, Npcs.WOMAN_1141,
                    Npcs.WOMAN_1142, Npcs.WOMAN_3015, Npcs.WOMAN_3083, Npcs.WOMAN_3084, Npcs.WOMAN_3085,
                    Npcs.WOMAN_3110, Npcs.WOMAN_3267, Npcs.WOMAN_3268, Npcs.WOMAN_4958, Npcs.WOMAN_6990,
                    Npcs.WOMAN_6991, Npcs.WOMAN_6992, Npcs.WOMAN_7921, Npcs.WOMAN_7922, Npcs.WOMAN
            ),
            exp = 8.0,
            lvl = 1,
            npcName = "Man/Woman",
            rewards = WeightItemSet()
                    .add(WeightItem(item = Items.COINS_995, amount =  3, weight = Rarity.ALWAYS.value)),
            damage = 1..1,
            stunTicks = 8
    ),
    FARMER(
            ids = intArrayOf(
                    Npcs.FARMER_3086, Npcs.FARMER_3087, Npcs.FARMER_3088, Npcs.FARMER_3089, Npcs.FARMER_3090,
                    Npcs.FARMER_3091, Npcs.FARMER_3672, Npcs.FARMER_6947, Npcs.FARMER_6948, Npcs.FARMER_6949,
                    Npcs.FARMER_6950, Npcs.FARMER_6951, Npcs.FARMER_6952, Npcs.FARMER_6959, Npcs.FARMER_6960,
                    Npcs.FARMER_6961
            ),
            exp = 14.5,
            lvl = 10,
            npcName = "Farmer",
            rewards = WeightItemSet()
                    .add(WeightItem(item = Items.COINS_995, amount =  3, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.POTATO_SEED, amount =  1, weight = Rarity.RARE.value)),
            damage = 2..2,
            stunTicks = 8
    ),
    HAM_FEMALE(
            ids = intArrayOf(Npcs.HAM_MEMBER_2541),
            exp = 18.5,
            lvl = 15,
            npcName = "H.A.M. Member",
            rewards = WeightItemSet()
                    .add(WeightItem(item = Items.BRONZE_ARROW, amount =  1..15, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.BRONZE_AXE, amount =  1, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.BRONZE_PICKAXE, amount =  1, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.IRON_AXE, amount =  1, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.IRON_DAGGER, amount =  1, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.IRON_PICKAXE, amount =  1, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.BUTTONS, amount =  1, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.COINS_995, amount =  1..21, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.FEATHER, amount =  1..7, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.KNIFE, amount =  1, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.LOGS, amount =  1, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.NEEDLE, amount =  1, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.RAW_ANCHOVIES, amount =  1..3, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.RAW_CHICKEN, amount =  1, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.THREAD, amount =  2..10, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.TINDERBOX, amount =  1, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.UNCUT_OPAL, amount =  1, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.LEATHER_BODY, amount =  1, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.HAM_BOOTS, amount =  1, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.HAM_CLOAK, amount =  1, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.HAM_GLOVES, amount =  1, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.HAM_HOOD, amount =  1, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.HAM_LOGO, amount =  1, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.HAM_SHIRT, amount =  1, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.STEEL_ARROW, amount =  1..13, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.STEEL_AXE, amount =  1, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.STEEL_DAGGER, amount =  1, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.STEEL_PICKAXE, amount =  1, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.CLUE_SCROLL_EASY, amount =  1, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.COAL, amount =  1, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.COWHIDE, amount =  1, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.DAMAGED_ARMOUR, amount =  1, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.GRIMY_GUAM_LEAF, amount =  1, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.GRIMY_MARRENTILL, amount =  1, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.GRIMY_TARROMIN, amount =  1, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.IRON_ORE, amount =  1, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.RUSTY_SWORD, amount =  1, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.UNCUT_JADE, amount =  1, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.RAW_CHICKEN, amount =  1, weight = Rarity.UNCOMMON.value)),
            damage = 1..3,
            stunTicks = 6
    ),
    HAM_MALE(
            ids = intArrayOf(Npcs.HAM_MEMBER),
            exp = 22.5,
            lvl = 20,
            npcName = "H.A.M. Member",
            rewards =  WeightItemSet()
                    .add(WeightItem(item = Items.BRONZE_ARROW, amount =  1..15, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.BRONZE_AXE, amount =  1, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.BRONZE_PICKAXE, amount =  1, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.IRON_AXE, amount =  1, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.IRON_DAGGER, amount =  1, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.IRON_PICKAXE, amount =  1, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.BUTTONS, amount =  1, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.COINS_995, amount =  1..21, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.FEATHER, amount =  1..7, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.KNIFE, amount =  1, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.LOGS, amount =  1, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.NEEDLE, amount =  1, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.RAW_ANCHOVIES, amount =  1..3, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.RAW_CHICKEN, amount =  1, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.THREAD, amount =  2..10, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.TINDERBOX, amount =  1, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.UNCUT_OPAL, amount =  1, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.LEATHER_BODY, amount =  1, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.HAM_BOOTS, amount =  1, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.HAM_CLOAK, amount =  1, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.HAM_GLOVES, amount =  1, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.HAM_HOOD, amount =  1, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.HAM_LOGO, amount =  1, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.HAM_SHIRT, amount =  1, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.STEEL_ARROW, amount =  1..13, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.STEEL_AXE, amount =  1, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.STEEL_DAGGER, amount =  1, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.STEEL_PICKAXE, amount =  1, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.CLUE_SCROLL_EASY, amount =  1, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.COAL, amount =  1, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.COWHIDE, amount =  1, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.DAMAGED_ARMOUR, amount =  1, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.GRIMY_GUAM_LEAF, amount =  1, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.GRIMY_MARRENTILL, amount =  1, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.GRIMY_TARROMIN, amount =  1, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.IRON_ORE, amount =  1, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.RUSTY_SWORD, amount =  1, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.UNCUT_JADE, amount =  1, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.RAW_CHICKEN, amount =  1, weight = Rarity.UNCOMMON.value)),
            damage = 1..3,
            stunTicks = 6
    ),
    ALKHARID_WARRIOR(
            ids = intArrayOf(Npcs.ALKHARID_WARRIOR, Npcs.WARRIOR_WOMAN_3100),
            exp = 26.0,
            lvl = 25,
            npcName = "Warrior",
            rewards = WeightItemSet()
                    .add(WeightItem(item = Items.COINS_995, amount =  18, weight = Rarity.ALWAYS.value)),
            damage = 2..2,
            stunTicks = 8
    ),
    ROGUE(
            ids = intArrayOf(Npcs.ROGUE_2884),
            exp = 35.5,
            lvl = 32,
            npcName = "Rogue",
            rewards = WeightItemSet()
                    .add(WeightItem(item = Items.COINS_995, amount =  25..120, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.AIR_RUNE, amount =  8, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.LOCKPICK, amount =  1, weight = Rarity.VERY_RARE.value))
                    .add(WeightItem(item = Items.JUG_OF_WINE, amount =  1, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.GOLD_BAR, amount =  1, weight = Rarity.RARE.value))
                    .add(WeightItem(item = Items.IRON_DAGGERP, amount =  1, weight = Rarity.RARE.value)),
            damage = 2..2,
            stunTicks = 8
    ),
    CAVE_GOBLIN(
            ids = intArrayOf(
                    Npcs.CAVE_GOBLIN_2268, Npcs.CAVE_GOBLIN_2269, Npcs.CAVE_GOBLIN_2270, Npcs.CAVE_GOBLIN_2271,
                    Npcs.CAVE_GOBLIN_2272, Npcs.CAVE_GOBLIN_2273, Npcs.CAVE_GOBLIN_2274, Npcs.CAVE_GOBLIN_2275,
                    Npcs.CAVE_GOBLIN_2276, Npcs.CAVE_GOBLIN_2277, Npcs.CAVE_GOBLIN_2278, Npcs.CAVE_GOBLIN_2279,
                    Npcs.CAVE_GOBLIN_2280, Npcs.CAVE_GOBLIN_2281, Npcs.CAVE_GOBLIN_2282, Npcs.CAVE_GOBLIN_2283,
                    Npcs.CAVE_GOBLIN_2284, Npcs.CAVE_GOBLIN_2285, Npcs.CAVE_GOBLIN_2299, Npcs.CAVE_GOBLIN_2301,
                    Npcs.CAVE_GOBLIN_5163, Npcs.CAVE_GOBLIN_5164, Npcs.CAVE_GOBLIN_5165, Npcs.CAVE_GOBLIN_5166,
                    Npcs.CAVE_GOBLIN_5167, Npcs.CAVE_GOBLIN_5168, Npcs.CAVE_GOBLIN_6434, Npcs.CAVE_GOBLIN_6435,
                    Npcs.CAVE_GOBLIN_6436, Npcs.CAVE_GOBLIN_6437
                    ),
            exp = 40.0,
            lvl = 36,
            npcName = "Cave Goblin",
            rewards = WeightItemSet()
                    .add(WeightItem(item = Items.BAT_SHISH, amount =  1, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.COATED_FROGS_LEGS, amount =  1, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.FINGERS, amount =  1, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.FROGBURGER, amount =  1, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.FROGSPAWN_GUMBO, amount =  1, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.GREEN_GLOOP_SOUP, amount =  1, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.COINS_995, amount =  11..48, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.BULLSEYE_LANTERN, amount =  1, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.CAVE_GOBLIN_WIRE, amount =  1, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.IRON_ORE, amount =  1..4, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.OIL_LANTERN, amount =  1, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.TINDERBOX, amount =  1, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.UNLIT_TORCH, amount =  1, weight = Rarity.RARE.value)),
            damage = 1..1,
            stunTicks = 8
    ),
    MASTER_FARMER(
            ids = intArrayOf(
                    Npcs.MASTER_FARMER_3257, Npcs.MASTER_FARMER_3258
            ),
            exp = 43.0,
            lvl = 38,
            npcName = "Master Farmer",
            rewards = WeightItemSet()
                    .add(WeightItem(item = Items.POTATO_SEED, amount =  1..4, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.ONION_SEED, amount =  1..3, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.CABBAGE_SEED, amount =  1..3, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.TOMATO_SEED, amount =  1..2, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.SWEETCORN_SEED, amount =  1..2, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.STRAWBERRY_SEED, amount =  1, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.WATERMELON_SEED, amount =  1, weight = Rarity.RARE.value))
                    .add(WeightItem(item = Items.BARLEY_SEED, amount =  1..4, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.HAMMERSTONE_SEED, amount =  1..3, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.ASGARNIAN_SEED, amount =  1..2, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.JUTE_SEED, amount =  1..3, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.YANILLIAN_SEED, amount =  1..2, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.KRANDORIAN_SEED, amount =  1, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.WILDBLOOD_SEED, amount =  1, weight = Rarity.RARE.value))
                    .add(WeightItem(item = Items.MARIGOLD_SEED, amount =  1, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.NASTURTIUM_SEED, amount =  1, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.ROSEMARY_SEED, amount =  1, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.WOAD_SEED, amount =  1, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.LIMPWURT_SEED, amount =  1, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.REDBERRY_SEED, amount =  1, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.CADAVABERRY_SEED, amount =  1, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.DWELLBERRY_SEED, amount =  1, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.JANGERBERRY_SEED, amount =  1, weight = Rarity.RARE.value))
                    .add(WeightItem(item = Items.WHITEBERRY_SEED, amount =  1, weight = Rarity.RARE.value))
                    .add(WeightItem(item = Items.POISON_IVY_SEED, amount =  1, weight = Rarity.RARE.value))
                    .add(WeightItem(item = Items.GUAM_SEED, amount =  1, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.MARRENTILL_SEED, amount =  1, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.TARROMIN_SEED, amount =  1, weight = Rarity.RARE.value))
                    .add(WeightItem(item = Items.HARRALANDER_SEED, amount =  1, weight = Rarity.RARE.value))
                    .add(WeightItem(item = Items.RANARR_SEED, amount =  1, weight = Rarity.RARE.value))
                    .add(WeightItem(item = Items.TOADFLAX_SEED, amount =  1, weight = Rarity.RARE.value))
                    .add(WeightItem(item = Items.IRIT_SEED, amount =  1, weight = Rarity.RARE.value))
                    .add(WeightItem(item = Items.AVANTOE_SEED, amount =  1, weight = Rarity.RARE.value))
                    .add(WeightItem(item = Items.KWUARM_SEED, amount =  1, weight = Rarity.VERY_RARE.value))
                    .add(WeightItem(item = Items.SNAPDRAGON_SEED, amount =  1, weight = Rarity.VERY_RARE.value))
                    .add(WeightItem(item = Items.CADANTINE_SEED, amount =  1, weight = Rarity.VERY_RARE.value))
                    .add(WeightItem(item = Items.LANTADYME_SEED, amount =  1, weight = Rarity.VERY_RARE.value))
                    .add(WeightItem(item = Items.DWARF_WEED_SEED, amount =  1, weight = Rarity.VERY_RARE.value))
                    .add(WeightItem(item = Items.TORSTOL_SEED, amount =  1, weight = Rarity.VERY_RARE.value))
                    .add(WeightItem(item = Items.MUSHROOM_SPORE, amount =  1, weight = Rarity.RARE.value))
                    .add(WeightItem(item = Items.BELLADONNA_SEED, amount =  1, weight = Rarity.RARE.value))
                    .add(WeightItem(item = Items.CACTUS_SEED, amount =  1, weight = Rarity.VERY_RARE.value)),
            damage = 2..2,
            stunTicks = 8
    ),
    GUARD(
            ids = intArrayOf(Npcs.GUARD_3094),
            exp = 46.8,
            lvl = 40,
            npcName = "Guard",
            rewards = WeightItemSet()
                    .add(WeightItem(item = Items.COINS_995, amount =  30, weight = Rarity.ALWAYS.value)),
            damage = 2..2,
            stunTicks = 8
    ),
    FREMENNIK_CITIZEN(
            ids = intArrayOf(
                    /*TODO: Find fremmy citizen id*/
            ),
            exp = 65.0,
            lvl = 45,
            npcName = "Fremennik Citizen",
            rewards = WeightItemSet()
                    .add(WeightItem(item = Items.COINS_995, amount =  30, weight = Rarity.ALWAYS.value)),
            damage = 2..2,
            stunTicks = 8
    ),
    BEARDED_POLLNIVIAN_BANDIT(
            ids = intArrayOf(
                    /*TODO: Find Bearded Pollnivian Bandit ID*/
            ),
            exp = 65.0,
            lvl = 45,
            npcName = "Pollnivian Bandit",
            rewards = WeightItemSet()
                    .add(WeightItem(item = Items.COINS_995, amount =  40, weight = Rarity.ALWAYS.value)),
            damage = 5..5,
            stunTicks = 8
    ),
    DESERT_BANDIT(
            ids = intArrayOf(
                    /*TODO: Find DESERT Bandit ID*/
            ),
            exp = 79.5,
            lvl = 53,
            npcName = "Desert Bandit",
            rewards = WeightItemSet()
                    .add(WeightItem(item = Items.COINS_995, amount =  30, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.ANTIPOISON3, amount =  30, weight = Rarity.COMMON.value))
                    .add(WeightItem(item = Items.LOCKPICK, amount =  30, weight = Rarity.COMMON.value)),

            damage = 3..3,
            stunTicks = 8
    ),
    KNIGHT(
            ids = intArrayOf(
                    Npcs.KNIGHT, Npcs.KNIGHT_5793, Npcs.KNIGHT_5929,
                    Npcs.KNIGHT_OF_ARDOUGNE_3108, Npcs.KNIGHT_OF_ARDOUGNE_3111
            ),
            exp = 84.3,
            lvl = 55,
            npcName = "Knight",
            rewards =WeightItemSet()
                    .add(WeightItem(item = Items.COINS_995, amount =  50, weight = Rarity.ALWAYS.value)),
            damage = 3..3,
            stunTicks = 8
    ),
    POLLNIVIAN_BANDIT(
            ids = intArrayOf(
                    /*TODO: Find Pollnivian Bandit ID*/
            ),
            exp = 84.3,
            lvl = 55,
            npcName = "Pollnivian Bandit",
            rewards = WeightItemSet()
                    .add(WeightItem(item = Items.COINS_995, amount =  50, weight = Rarity.ALWAYS.value)),
            damage = 5..5,
            stunTicks = 8
    ),
    YANILLE_WATCHMAN(
            ids = intArrayOf(Npcs.WATCHMAN_3251),
            exp = 137.5,
            lvl = 65,
            npcName = "Watchman",
            rewards = WeightItemSet()
                    .add(WeightItem(item = Items.COINS_995, amount =  50, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.BREAD, amount =  1, weight = Rarity.COMMON.value)),
            damage = 3..3,
            stunTicks = 8
    ),
    MENAPHITE_THUG(
            ids = intArrayOf(
                    Npcs.MENAPHITE_THUG_3549,
                    Npcs.MENAPHITE_THUG_3550
            ),
            exp = 137.5,
            lvl = 65,
            npcName = "Menaphite Thug",
            rewards = WeightItemSet()
                    .add(WeightItem(item = Items.COINS_995, amount =  60, weight = Rarity.ALWAYS.value)),
            damage = 2..2,
            stunTicks = 8
    ),
    PALADIN(
            ids = intArrayOf(
                    Npcs.PALADIN_1144, Npcs.PALADIN_3104, Npcs.PALADIN_3105, Npcs.PALADIN_8150
            ),
            exp = 151.75,
            lvl = 70,
            npcName = "Paladin",
            rewards = WeightItemSet()
                    .add(WeightItem(item = Items.COINS_995, amount =  80, weight = Rarity.UNCOMMON.value))
                    .add(WeightItem(item = Items.CHAOS_RUNE, amount =  2, weight = Rarity.COMMON.value)),
            damage = 3..3,
            stunTicks = 8
    ),
    GNOME(
            ids = intArrayOf(
                    Npcs.GNOME_4233
            ),
            exp = 198.5,
            lvl = 75,
            npcName = "Gnome",
            rewards = WeightItemSet()
                    .add(WeightItem(item =Items.COINS_995, amount =  300, weight =  Rarity.COMMON.value))
                    .add(WeightItem(item =Items.EARTH_RUNE, amount =  1, weight =  Rarity.COMMON.value))
                    .add(WeightItem(item =Items.GOLD_ORE, amount =  1, weight =  Rarity.COMMON.value))
                    .add(WeightItem(item =Items.FIRE_ORB, amount =  1, weight =  Rarity.COMMON.value))
                    .add(WeightItem(item =Items.SWAMP_TOAD, amount =  1, weight =  Rarity.COMMON.value))
                    .add(WeightItem(item =Items.KING_WORM, amount =  1, weight =  Rarity.COMMON.value)),
            damage = 1..1,
            stunTicks = 8
    ),
    HERO(
            ids = intArrayOf(Npcs.HERO_3106),
            exp = 275.0,
            lvl = 80,
            npcName = "Hero",
            rewards = WeightItemSet()
                    .add(WeightItem(item =Items.COINS_995, amount =  200..300, weight =  Rarity.COMMON.value))
                    .add(WeightItem(item =Items.DEATH_RUNE, amount =  2, weight =  Rarity.UNCOMMON.value))
                    .add(WeightItem(item =Items.BLOOD_RUNE, amount =  1, weight =  Rarity.UNCOMMON.value))
                    .add(WeightItem(item =Items.GOLD_ORE, amount =  1, weight =  Rarity.UNCOMMON.value))
                    .add(WeightItem(item =Items.JUG_OF_WINE, amount =  1, weight =  Rarity.UNCOMMON.value))
                    .add(WeightItem(item =Items.FIRE_ORB, amount =  1, weight =  Rarity.UNCOMMON.value))
                    .add(WeightItem(item =Items.DIAMOND, amount =  1, weight =  Rarity.UNCOMMON.value)),
            damage = 4..4,
            stunTicks = 10
    ),
    ELF(
            ids = intArrayOf(
                    /*TODO: Find ELF ID*/
            ),
            exp = 353.0,
            lvl = 85,
            npcName = "Elf",
            rewards = WeightItemSet()
                    .add(WeightItem(item =Items.COINS_995, amount =  280..350, weight =  Rarity.COMMON.value))
                    .add(WeightItem(item =Items.DEATH_RUNE, amount =  2, weight =  Rarity.UNCOMMON.value))
                    .add(WeightItem(item =Items.NATURE_RUNE, amount =  3, weight =  Rarity.UNCOMMON.value))
                    .add(WeightItem(item =Items.GOLD_ORE, amount =  1, weight =  Rarity.UNCOMMON.value))
                    .add(WeightItem(item =Items.JUG_OF_WINE, amount =  1, weight =  Rarity.UNCOMMON.value))
                    .add(WeightItem(item =Items.FIRE_ORB, amount =  1, weight =  Rarity.UNCOMMON.value))
                    .add(WeightItem(item =Items.DIAMOND, amount =  1, weight =  Rarity.UNCOMMON.value)),
            damage = 5..5,
            stunTicks = 10
    ),
    TZHAAR_HUR(
            ids = intArrayOf(
                    Npcs.TZHAARHUR_2161
            ),
            exp = 103.5,
            lvl = 90,
            npcName = "Tzhaar Hur",
            rewards = WeightItemSet()
                    .add(WeightItem(item =Items.TOKKUL, amount =  3..14, weight =  Rarity.COMMON.value))
                    .add(WeightItem(item =Items.UNCUT_SAPPHIRE, amount =  1, weight =  Rarity.COMMON.value))
                    .add(WeightItem(item =Items.UNCUT_EMERALD, amount =  1, weight =  Rarity.COMMON.value))
                    .add(WeightItem(item =Items.UNCUT_RUBY, amount =  1, weight =  Rarity.COMMON.value))
                    .add(WeightItem(item =Items.UNCUT_DIAMOND, amount =  1, weight =  Rarity.COMMON.value)),

            damage = 4..4,
            stunTicks = 8
    );

    enum class Rarity(val value: Int) {
        ALWAYS(value = 0), COMMON(value = 256), UNCOMMON(value = 32), RARE(value = 8), VERY_RARE(value = 1);
    }
}