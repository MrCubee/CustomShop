package fr.lightnew.gui;

import fr.lightnew.files.FolderDye;
import fr.lightnew.files.FolderUnby;
import fr.lightnew.utils.ColorList;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

import java.util.List;

public class GuiUnby {
    private static YamlConfiguration folder = FolderUnby.folderUnbyConfig;
    private static String line_config = "unby";
    /**CONSTRUCT ITEMS*/
    public static void create(Inventory inventory, String line_config_modif) {
        ConfigurationSection section = folder.getConfigurationSection("gui-shop-"+line_config+".items");
        FileConfiguration fc = folder;
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
    public static Inventory GuiShopUnbyInv = Bukkit.createInventory(null,
            folder.getInt("gui-shop-"+line_config+".size")*9,
            folder.getString("gui-shop-"+line_config+".name").replace('&', '§'));
    /**SEND INVENTORY WITH ALL MODIFICATION*/
    public static Inventory send(Player player) {
        GuiShopUnbyInv.clear();
        create(GuiShopUnbyInv, "gui-shop-"+line_config+".items");
        return GuiShopUnbyInv;
    }
}
