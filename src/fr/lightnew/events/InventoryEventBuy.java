package fr.lightnew.events;

import fr.lightnew.gui.GuiBuy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class InventoryEventBuy implements Listener {
    @EventHandler
    public void onInteract(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        ItemStack item = event.getCurrentItem();
        Inventory inv = event.getInventory();

        /**METTRE A ITEM DANS GUIBUY LE PRIX EN LORE ET AU FURE ET A MESURE L'AUGMENTER OU BAISSER*/
        if (player != null && item != null && inv != null) {
            if (inv.getName().equalsIgnoreCase(ChatColor.GREEN + "Choix Achat")) {
                //ADD ITEM
                if (item.isSimilar(GuiBuy.GREEN_ADD_ONE)){
                    player.playSound(player.getLocation(), Sound.NOTE_PLING, 10, 10);
                    GuiBuy.addToItemToBuy(1);
                    //InvUpdate.updateInvBuy(player, GuiBuy.inventory, GuiBuy.slot, GuiBuy.addToItemToBuy(1));
                }
                if (item.isSimilar(GuiBuy.GREEN_ADD_TEEN)){
                    player.playSound(player.getLocation(), Sound.NOTE_PLING, 10, 10);
                    GuiBuy.addToItemToBuy(10);
                    //InvUpdate.updateInvBuy(player, GuiBuy.inventory, GuiBuy.slot, GuiBuy.addToItemToBuy(10));
                }
                if (item.isSimilar(GuiBuy.GREEN_ADD_STACK)){
                    player.playSound(player.getLocation(), Sound.NOTE_PLING, 10, 10);

                    GuiBuy.addToItemToBuy(64);
                    GuiBuy.itemToBy.setAmount(GuiBuy.addToItemToBuy(64));

                    ItemMeta meta = GuiBuy.itemToBy.getItemMeta();
                    List<String> tt = new ArrayList<>();
                    tt.add("TEST LORE");
                    meta.setLore(tt);
                    GuiBuy.itemToBy.setItemMeta(meta);

                    Bukkit.getConsoleSender().sendMessage("TEST DE GREEND STACK (64) -> " + GuiBuy.itemToBy.getAmount());
                    Bukkit.getConsoleSender().sendMessage("LORE DE GREEND STACK -> " + GuiBuy.itemToBy.getItemMeta().getLore());
                    //InvUpdate.updateInvBuy(player, GuiBuy.inventory, GuiBuy.slot, GuiBuy.addToItemToBuy(64));
                }
                //REMOVE ITEM
                if (item.isSimilar(GuiBuy.RED_ADD_ONE)){
                    player.playSound(player.getLocation(), Sound.NOTE_BASS, 10, 10);
                    GuiBuy.removeToItemToBuy(1);
                }
                if (item.isSimilar(GuiBuy.RED_ADD_TEEN)){
                    player.playSound(player.getLocation(), Sound.NOTE_BASS, 10, 10);
                    GuiBuy.removeToItemToBuy(10);
                }
                if (item.isSimilar(GuiBuy.RED_ADD_STACK)){
                    player.playSound(player.getLocation(), Sound.NOTE_BASS, 10, 10);
                    GuiBuy.removeToItemToBuy(64);
                }
                //VALID TRANSACT
                if (item.isSimilar(GuiBuy.CHECK_VALID_TRANSACT)){}
                event.setCancelled(true);
            }
        }
    }
}
