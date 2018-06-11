package org.pixeltime.enchantmentsenhance.gui.menu.icons;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.pixeltime.enchantmentsenhance.event.inventory.Inventory;
import org.pixeltime.enchantmentsenhance.interfaces.Clickable;
import org.pixeltime.enchantmentsenhance.manager.SettingsManager;
import org.pixeltime.enchantmentsenhance.util.ItemBuilder;
import org.pixeltime.enchantmentsenhance.util.Util;

public class InventoryIcon extends Clickable {

    public static String getOneStoneCountAsString(Player player, int stoneId) {
        int[] inv = Inventory.getPlayer(player);
        return (SettingsManager.lang.getString("Item.listing").replaceAll(
                "%ITEM%", SettingsManager.lang.getString("Item." + stoneId))
                .replaceAll("%COUNT%", Integer.toString(inv[stoneId])));
    }

    public static int getOneStoneCountAsInt(Player player, int stoneId) {
        return Inventory.getPlayer(player)[stoneId];
    }

    @Override
    public ItemStack getItem() {
        return new ItemBuilder(Material.CHEST).setName(SettingsManager.lang.getString("Item.gui")).addLoreLine(SettingsManager.lang.getString("Item.gui1")).toItemStack();
    }

    @Override
    public int getPosition() {
        return Util.getSlot(7, 1);
    }

}
