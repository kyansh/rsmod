package gg.rsmod.game.fs.def

import gg.rsmod.game.fs.Definition
import gg.rsmod.util.BufferUtils
import io.netty.buffer.ByteBuf

/**
 * @author Tom <rspsmods@gmail.com>
 */
class EnumDef(override val id: Int) : Definition(id) {

    var keyType = 0

    var valueType = 0

    var defaultInt = 0

    var defaultString = ""

    val values = hashMapOf<Int, Any>()

    override fun decode(buf: ByteBuf, opcode: Int) {
        when (opcode) {
            1 -> keyType = buf.readUnsignedByte().toInt()
            2 -> valueType = buf.readUnsignedByte().toInt()
            3 -> defaultString = BufferUtils.readString(buf)
            4 -> defaultInt = buf.readInt()
            5, 6 -> {
                val count = buf.readUnsignedShort()
                for (i in 0 until count) {
                    val key = buf.readInt()
                    if (opcode == 5) {
                        values[key] = BufferUtils.readString(buf)
                    } else {
                        values[key] = buf.readInt()
                    }
                }
            }
        }
    }

    fun getInt(key: Int): Int = values[key] as? Int ?: defaultInt

    fun getString(key: Int): String = values[key] as? String ?: defaultString
}