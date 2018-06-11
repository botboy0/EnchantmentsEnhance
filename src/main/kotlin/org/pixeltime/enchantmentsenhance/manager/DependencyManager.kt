/*
 *     Copyright (C) 2017-Present HealPotion
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

package org.pixeltime.enchantmentsenhance.manager


import net.milkbowl.vault.economy.Economy
import org.pixeltime.enchantmentsenhance.Main
import uk.antiperson.stackmob.StackMob

class DM {

    companion object {
        @JvmField
        var economy: Economy? = null
        @JvmField
        var stackmob: StackMob? = null


        @JvmStatic
        fun setupEconomy(): Boolean {
            val registration = Main.getMain().server.servicesManager.getRegistration<Any>(Economy::class.java as Class<Any>)
                    ?: return false
            economy = registration.provider as Economy
            return true
        }

        @JvmStatic
        fun setupStackMob(): Boolean {
            val registration = Main.getMain().server.servicesManager.getRegistration<Any>(StackMob::class.java as Class<Any>)
                    ?: return false
            stackmob = registration.provider as StackMob

            return true
        }
    }
}
