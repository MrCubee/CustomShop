package fr.lightnew.gui;

import fr.lightnew.files.FolderGuiFile;
import fr.lightnew.utils.ColorList;
import fr.lightnew.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GuiInterface {
    /**CONSTRUCT ITEMS*/
    //Items | Clay
    public static ItemStack CLAY_ITEM = ItemBuilder.create(Material.valueOf(
            FolderGuiFile.guiFileConfig.getString("gui-clay.item.material")),
            FolderGuiFile.guiFileConfig.getInt("gui-clay.item.amount"),
            FolderGuiFile.guiFileConfig.getString("gui-clay.item.name").replace('&', '§'));
    //Ores
    public static ItemStack ORES_ITEM = ItemBuilder.create(Material.valueOf(
                    FolderGuiFile.guiFileConfig.getString("gui-ores.item.material")),
            FolderGuiFile.guiFileConfig.getInt("gui-ores.item.amount"),
            FolderGuiFile.guiFileConfig.getString("gui-ores.item.name").replace('&', '§'));
    //Sword
    public static ItemStack SWORD_ITEM = ItemBuilder.create(Material.valueOf(
                    FolderGuiFile.guiFileConfig.getString("gui-sword.item.material")),
            FolderGuiFile.guiFileConfig.getInt("gui-sword.item.amount"),
            FolderGuiFile.guiFileConfig.getString("gui-sword.item.name").replace('&', '§'));
    //Stuff
    public static ItemStack STUFF_ITEM = ItemBuilder.create(Material.valueOf(
                    FolderGuiFile.guiFileConfig.getString("gui-stuff.item.material")),
            FolderGuiFile.guiFileConfig.getInt("gui-stuff.item.amount"),
            FolderGuiFile.guiFileConfig.getString("gui-stuff.item.name").replace('&', '§'));
    //Dye
    public static ItemStack DYE_ITEM = ItemBuilder.create(Material.valueOf(
                    FolderGuiFile.guiFileConfig.getString("gui-dye.item.material")),
            FolderGuiFile.guiFileConfig.getInt("gui-dye.item.amount"),
            FolderGuiFile.guiFileConfig.getString("gui-dye.item.name").replace('&', '§'));
    //Food
    public static ItemStack FOOD_ITEM = ItemBuilder.create(Material.valueOf(
                    FolderGuiFile.guiFileConfig.getString("gui-food.item.material")),
            FolderGuiFile.guiFileConfig.getInt("gui-food.item.amount"),
            FolderGuiFile.guiFileConfig.getString("gui-food.item.name").replace('&', '§'));
    //Log
    public static ItemStack LOG_ITEM = ItemBuilder.create(Material.valueOf(
                    FolderGuiFile.guiFileConfig.getString("gui-log.item.material")),
            FolderGuiFile.guiFileConfig.getInt("gui-log.item.amount"),
            FolderGuiFile.guiFileConfig.getString("gui-log.item.name").replace('&', '§'));
    //UnBy
    public static ItemStack UNBY_ITEM = ItemBuilder.create(Material.valueOf(
                    FolderGuiFile.guiFileConfig.getString("gui-unby.item.material")),
            FolderGuiFile.guiFileConfig.getInt("gui-unby.item.amount"),
            FolderGuiFile.guiFileConfig.getString("gui-unby.item.name").replace('&', '§'));
    //Block
    public static ItemStack BLOCK_ITEM = ItemBuilder.create(Material.valueOf(
                    FolderGuiFile.guiFileConfig.getString("gui-block.item.material")),
            FolderGuiFile.guiFileConfig.getInt("gui-block.item.amount"),
            FolderGuiFile.guiFileConfig.getString("gui-block.item.name").replace('&', '§'));
    //Pane
    public static ItemStack GLASS_PANE_ITEM = ItemBuilder.create(
            Material.valueOf(FolderGuiFile.guiFileConfig.getString("gui-pane.item.material")),
            FolderGuiFile.guiFileConfig.getInt("gui-pane.item.amount"),
            (byte) FolderGuiFile.guiFileConfig.getInt("gui-pane.item.data"),
            FolderGuiFile.guiFileConfig.getString("gui-pane.item.name").replace('&', '§'));
    //RETURN
    public static ItemStack RETURN_HUB = ItemBuilder.create(
            Material.valueOf(FolderGuiFile.guiFileConfig.getString("gui-shop.return.material")),
            FolderGuiFile.guiFileConfig.getInt("gui-shop.return.amount"),
            (byte) FolderGuiFile.guiFileConfig.getInt("gui-shop.return.data"),
            FolderGuiFile.guiFileConfig.getString("gui-shop.return.name").replace('&', '§'));

    /**ADD META ON ITEM*/
    private static void sendOtherItemMeta(){
        //lists
        ColorList.send(FolderGuiFile.guiFileConfig.getStringList("gui-clay.item.lores"));
        //clay
        ItemMeta metaClay = CLAY_ITEM.getItemMeta();
        metaClay.setLore(ColorList.send(FolderGuiFile.guiFileConfig.getStringList("gui-clay.item.lores")));
        if (FolderGuiFile.guiFileConfig.getBoolean("gui-clay.item.glowing")) {
            metaClay.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            metaClay.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }else return;
        CLAY_ITEM.setItemMeta(metaClay);
        //ores
        ItemMeta metaOres = ORES_ITEM.getItemMeta();
        metaOres.setLore(ColorList.send(FolderGuiFile.guiFileConfig.getStringList("gui-ores.item.lores")));
        if (FolderGuiFile.guiFileConfig.getBoolean("gui-ores.item.glowing")) {
            metaOres.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            metaOres.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }else return;
        ORES_ITEM.setItemMeta(metaOres);
        //sword
        ItemMeta metaSword = SWORD_ITEM.getItemMeta();
        metaSword.setLore(ColorList.send(FolderGuiFile.guiFileConfig.getStringList("gui-sword.item.lores")));
        if (FolderGuiFile.guiFileConfig.getBoolean("gui-sword.item.glowing")) {
            metaSword.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            metaSword.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }else return;
        SWORD_ITEM.setItemMeta(metaSword);
        //stuff *
        ItemMeta metaStuff = STUFF_ITEM.getItemMeta();
        metaStuff.setLore(ColorList.send(FolderGuiFile.guiFileConfig.getStringList("gui-stuff.item.lores")));
        if (FolderGuiFile.guiFileConfig.getBoolean("gui-stuff.item.glowing")) {
            metaStuff.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            metaStuff.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }else return;
        STUFF_ITEM.setItemMeta(metaStuff);
        //dye
        ItemMeta metaDye = DYE_ITEM.getItemMeta();
        metaDye.setLore(ColorList.send(FolderGuiFile.guiFileConfig.getStringList("gui-dye.item.lores")));
        if (FolderGuiFile.guiFileConfig.getBoolean("gui-dye.item.glowing")) {
            metaDye.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            metaDye.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }else return;
        DYE_ITEM.setItemMeta(metaDye);
        //food
        ItemMeta metaFood = FOOD_ITEM.getItemMeta();
        metaFood.setLore(ColorList.send(FolderGuiFile.guiFileConfig.getStringList("gui-food.item.lores")));
        if (FolderGuiFile.guiFileConfig.getBoolean("gui-food.item.glowing")) {
            metaFood.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            metaFood.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }else return;
        FOOD_ITEM.setItemMeta(metaFood);
        //log
        ItemMeta metaLog = LOG_ITEM.getItemMeta();
        metaLog.setLore(ColorList.send(FolderGuiFile.guiFileConfig.getStringList("gui-log.item.lores")));
        if (FolderGuiFile.guiFileConfig.getBoolean("gui-log.item.glowing")) {
            metaLog.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            metaLog.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }else return;
        LOG_ITEM.setItemMeta(metaLog);
        //unby
        ItemMeta metaUnby = UNBY_ITEM.getItemMeta();
        metaUnby.setLore(ColorList.send(FolderGuiFile.guiFileConfig.getStringList("gui-unby.item.lores")));
        if (FolderGuiFile.guiFileConfig.getBoolean("gui-unby.item.glowing")) {
            metaUnby.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            metaUnby.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }else return;
        UNBY_ITEM.setItemMeta(metaUnby);
        //pane
        ItemMeta metaPane = GLASS_PANE_ITEM.getItemMeta();
        if (FolderGuiFile.guiFileConfig.getBoolean("gui-pane.item.glowing")) {
            metaPane.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            metaPane.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }else return;
        GLASS_PANE_ITEM.setItemMeta(metaPane);
        //return
        ItemMeta metaReturn = RETURN_HUB.getItemMeta();
        if (FolderGuiFile.guiFileConfig.getBoolean("gui-shop.return.glowing")) {
            metaReturn.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            metaReturn.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }else return;
        RETURN_HUB.setItemMeta(metaReturn);
    }
    /**CREATE INVENTORY*/
    public static Inventory GuiShopInv = Bukkit.createInventory(null, FolderGuiFile.guiFileConfig.getInt("gui-shop.size")*9, FolderGuiFile.guiFileConfig.getString("gui-shop.name"));
    /**SEND INVENTORY WITH ALL MODIFICATION*/
    public static void send(Player player) {
        GuiShopInv.clear();
        sendOtherItemMeta();
        GuiShopInv.setItem(FolderGuiFile.guiFileConfig.getInt("gui-shop.item.slot"), CLAY_ITEM);
        GuiShopInv.setItem(FolderGuiFile.guiFileConfig.getInt("gui-ores.item.slot"), ORES_ITEM);
        GuiShopInv.setItem(FolderGuiFile.guiFileConfig.getInt("gui-sword.item.slot"), SWORD_ITEM);
        GuiShopInv.setItem(FolderGuiFile.guiFileConfig.getInt("gui-stuff.item.slot"), STUFF_ITEM);
        GuiShopInv.setItem(FolderGuiFile.guiFileConfig.getInt("gui-dye.item.slot"), DYE_ITEM);
        GuiShopInv.setItem(FolderGuiFile.guiFileConfig.getInt("gui-food.item.slot"), FOOD_ITEM);
        GuiShopInv.setItem(FolderGuiFile.guiFileConfig.getInt("gui-log.item.slot"), LOG_ITEM);
        GuiShopInv.setItem(FolderGuiFile.guiFileConfig.getInt("gui-unby.item.slot"), UNBY_ITEM);
        GuiShopInv.setItem(FolderGuiFile.guiFileConfig.getInt("gui-block.item.slot"), BLOCK_ITEM);
        GuiShopInv.setItem(FolderGuiFile.guiFileConfig.getInt("gui-pane.item.slot"), GLASS_PANE_ITEM);
        GuiShopInv.setItem(FolderGuiFile.guiFileConfig.getInt("gui-shop.return.slot"), RETURN_HUB);
        player.openInventory(GuiShopInv);
    }
    public static void sendReturn(Inventory inventory, Boolean if_Config_Enable_Item_Return, YamlConfiguration configuration, String line_config, int slot) {
        if (inventory != null && configuration != null) {
            if (if_Config_Enable_Item_Return) {
                //config

                //META
                ItemMeta metaReturn = RETURN_HUB.getItemMeta();
                if (FolderGuiFile.guiFileConfig.getBoolean(line_config + ".glowing")) {
                    metaReturn.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                    metaReturn.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                } else return;
                RETURN_HUB.setItemMeta(metaReturn);
                //
                inventory.setItem(slot, RETURN_HUB);
            } else return;
        } else return;
    }
}
