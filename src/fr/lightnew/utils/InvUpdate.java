package fr.lightnew.utils;

import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InvUpdate {
    public static void updateInvBuy(Player player, Inventory inventory, int slot, ItemStack itemStack) {
        inventory.setItem(slot, itemStack);
        player.openInventory(inventory);
    }

    public static void updateInv (Inventory inventory, int slot, ItemStack itemStack) {
        for (HumanEntity p : inventory.getViewers()) {
            inventory.setItem(slot, itemStack);
            p.openInventory(inventory);
        }
    }
}
