package fr.lightnew.gui;

import fr.lightnew.utils.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GuiReturn implements Listener {
    public static ItemStack ITEM_RETURN = ItemBuilder.create(Material.ARROW, 1, ChatColor.RED + "Retour");
    public static String inventory;
    public static Player player;
    public static Inventory back;

    @EventHandler
    public void onInteract (InventoryClickEvent event) {
        Inventory inv = event.getInventory();
        ItemStack item = event.getCurrentItem();
        if (ITEM_RETURN != null) {
            if (inv.getName().equalsIgnoreCase(inventory)) {
                if (item.isSimilar(ITEM_RETURN)) {
                    player.closeInventory();
                    player.openInventory(back);
                }
            }
        }
    }

    public static void returnToInventory(Player player, Inventory back, String nameOfInvInPlayer) {
        GuiReturn.player=player;
        GuiReturn.inventory=nameOfInvInPlayer;
        GuiReturn.back=back;
    }
}
