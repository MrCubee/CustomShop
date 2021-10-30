package fr.lightnew.events;

import fr.lightnew.files.FolderOres;
import fr.lightnew.gui.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

import java.util.ArrayList;
import java.util.List;

public class InventoryEvent implements Listener {

    @EventHandler
    public void onInteractEvent(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        ItemStack item = event.getCurrentItem();
        Inventory inv = event.getInventory();
        InventoryAction action = event.getAction();

        if (player != null && inv != null && item != null && action != null) {
            /**interack with this item return in hub**/
            if (item.isSimilar(GuiInterface.RETURN_HUB)) {
                player.closeInventory();
                GuiInterface.send(player);
            }
            /**GUI SHOP HUB**/
            if (inv.getName().equalsIgnoreCase(GuiInterface.GuiShopInv.getName())) {
                if (item.isSimilar(GuiInterface.ORES_ITEM))
                    player.openInventory(GuiOres.send());
                if (item.isSimilar(GuiInterface.BLOCK_ITEM))
                    player.openInventory(GuiBlocks.send(player));
                if (item.isSimilar(GuiInterface.CLAY_ITEM))
                    player.openInventory(GuiClay.send(player));
                if (item.isSimilar(GuiInterface.DYE_ITEM))
                    player.openInventory(GuiDye.send(player));
                if (item.isSimilar(GuiInterface.FOOD_ITEM))
                    player.openInventory(GuiFood.send(player));
                if (item.isSimilar(GuiInterface.LOG_ITEM))
                    player.openInventory(GuiLog.send(player));
                if (item.isSimilar(GuiInterface.STUFF_ITEM))
                    player.openInventory(GuiStuff.send(player));
                if (item.isSimilar(GuiInterface.SWORD_ITEM))
                    player.openInventory(GuiSword.send(player));
                if (item.isSimilar(GuiInterface.UNBY_ITEM))
                    player.openInventory(GuiUnby.send(player));
                //return
                event.setCancelled(true);
            }
            /**Inventory Ores*/
            if (inv.getName().equalsIgnoreCase(GuiOres.GuiShopOreInv.getName())) {
                ConfigurationSection section = FolderOres.folderOresConfig.getConfigurationSection("gui-shop-ores.items");
                FileConfiguration fc = FolderOres.folderOresConfig;
                Bukkit.getConsoleSender().sendMessage("1");
                List<ItemStack> itemStackList = new ArrayList<>();
                for (String key : section.getKeys(false)) {
                    Bukkit.getConsoleSender().sendMessage("2");

                    ItemStack itemInFor = new ItemStack(Material.getMaterial(fc.getString("gui-shop-ores.items." + key + ".material")), fc.getInt("gui-shop-ores.items." + key + ".amount"),
                            (byte) fc.getInt("gui-shop-ores.items." + key + ".data"));
                    Bukkit.getConsoleSender().sendMessage("DATA ITEM FOR -> " + itemInFor.getData().getData() + " -> " + itemInFor.getType());

                    Bukkit.getConsoleSender().sendMessage("3");
                    itemStackList.add(itemInFor);
                    Bukkit.getConsoleSender().sendMessage("4");
                    Bukkit.getConsoleSender().sendMessage("list -> " + itemStackList);
                }
                Bukkit.getConsoleSender().sendMessage("5");

                ItemStack itemNewCurrent = new ItemStack(event.getCurrentItem().getType(), event.getCurrentItem().getAmount(),
                        event.getCurrentItem().getDurability(), event.getCurrentItem().getData().getData());

                Bukkit.getConsoleSender().sendMessage("6");
                Bukkit.getConsoleSender().sendMessage("DATA ITEM NEW " + itemNewCurrent.getData().getData() + " -> " + itemNewCurrent.getType());
                Bukkit.getConsoleSender().sendMessage("itemstack -> " + itemNewCurrent);

                if (itemStackList.contains(itemNewCurrent)) {
                    Bukkit.getConsoleSender().sendMessage("7");
                    GuiBuy.send(player, event.getCurrentItem());
                    player.sendMessage(ChatColor.GREEN + "CurrentItem -> " +  itemNewCurrent);
                    Bukkit.getConsoleSender().sendMessage("8");
                }
                GuiReturn.returnToInventory(player, GuiOres.send(), ChatColor.GREEN + "Choix Achat");
                event.setCancelled(true);
            }
        } else return;
    }
}
