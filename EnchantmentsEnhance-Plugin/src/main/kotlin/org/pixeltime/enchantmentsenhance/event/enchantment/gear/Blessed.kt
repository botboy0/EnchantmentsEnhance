/*
 *     Copyright (C) 2017-Present 25 (https://github.com/25)
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 *
 */

package org.pixeltime.enchantmentsenhance.event.enchantment.gear

import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.player.PlayerMoveEvent
import org.pixeltime.enchantmentsenhance.listener.EnchantmentListener

class Blessed : EnchantmentListener() {
    override fun desc(): Array<String> {
        return arrayOf("Restores the wearers health and hunger while walking and running", "走路时有几率补满饥饿以及生命")
    }

    override fun lang(): Array<String> {
        return arrayOf("祝福")
    }


    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    fun onMove(playerMoveEvent: PlayerMoveEvent) {
        val player = playerMoveEvent.player
        try {
            val level = getLevel(player)
            if (level > 0 && roll(level)) {
                player.health = player.maxHealth
                player.foodLevel = 20
            }
        } catch (ex: Exception) {
        }
    }
}
