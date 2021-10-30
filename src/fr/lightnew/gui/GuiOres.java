package fr.lightnew.gui;

import fr.lightnew.CustomShop;
import fr.lightnew.files.FolderOres;
import fr.lightnew.utils.ColorList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.List;

public class GuiOres {
    private static String line_config = "ores";
    /**CONSTRUCT ITEMS*/
    public static void create(Inventory inventory, String line_config_modif) {
        ConfigurationSection section = FolderOres.folderOresConfig.getConfigurationSection("gui-shop-"+line_config+".items");
        FileConfiguration fc = FolderOres.folderOresConfig;
        for (String key : section.getKeys(false)) {
            /**Parameter*/
            int amount = fc.getInt(line_config_modif+"."+key+".amount");
            List<Integer> slot = fc.getIntegerList(line_config_modif+"."+key+".slot");
            int data = fc.getInt(line_config_modif+"."+key+".data");
            String name = fc.getString(line_config_modif+"."+key+".name");
            String material = fc.getString(line_config_modif+"."+key+".material");
            List<String> lores = fc.getStringList(line_config_modif+"."+key+".lores");
            lores = ColorList.send(lores);

            /**Create items*/
            ItemStack item = new ItemStack(Material.getMaterial(material), amount);
            MaterialData materialData = new MaterialData(data);
            item.setData(materialData);
            ItemMeta meta = item.getItemMeta();

            meta.setDisplayName(name.replace('&', '§'));
            meta.setLore(lores);
            if (fc.getBoolean(line_config_modif+"."+key+".glowing")) {
                meta.addEnchant(Enchantment.ARROW_DAMAGE, 1, false);
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            }

            item.setItemMeta(meta);

            for (int loc : slot)
                inventory.setItem(loc, item);
        }
    }
    /**CREATE INVENTORY*/
    public static Inventory GuiShopOreInv = Bukkit.createInventory(null,
            FolderOres.folderOresConfig.getInt("gui-shop-"+line_config+".size")*9,
            FolderOres.folderOresConfig.getString("gui-shop-"+line_config+".name").replace('&', '§'));
    /**SEND INVENTORY WITH ALL MODIFICATION*/
    public static Inventory send() {
        GuiShopOreInv.clear();
        create(GuiShopOreInv, "gui-shop-" + line_config + ".items");
        return GuiShopOreInv;
    }
}
