package fr.lightnew.files;

import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FolderGuiFile {
    public static File guiFile = new File(CreateFiles.dataFolder, "GuiConfig.yml");
    public static YamlConfiguration guiFileConfig = YamlConfiguration.loadConfiguration(guiFile);

    public static void send() {
        try {
            guiFileConfig.set("gui-shop.name", "SHOP");
            guiFileConfig.set("gui-shop.size", 3); //3 = 3*9
            //ITEM RETURN
            guiFileConfig.set("gui-shop.return.material", "ARROW");
            guiFileConfig.set("gui-shop.return.slot", 22);
            guiFileConfig.set("gui-shop.return.amount", 1);
            guiFileConfig.set("gui-shop.return.data", 0);
            guiFileConfig.set("gui-shop.return.name", "&cRetour");
            guiFileConfig.set("gui-shop.return.lores", Arrays.asList("&e→ &bRetour au menu principal"));
            guiFileConfig.set("gui-shop.return.glowing", false);
            //clay
            guiFileConfig.set("gui-clay.item.material", "CLAY");
            guiFileConfig.set("gui-clay.item.slot", 0);
            guiFileConfig.set("gui-clay.item.amount", 1);
            guiFileConfig.set("gui-clay.item.name", "");
            guiFileConfig.set("gui-clay.item.lores", Arrays.asList(""));
            guiFileConfig.set("gui-clay.item.glowing", false);
            //ores
            guiFileConfig.set("gui-ores.item.material", "COAL_ORE");
            guiFileConfig.set("gui-ores.item.slot", 1);
            guiFileConfig.set("gui-ores.item.amount", 1);
            guiFileConfig.set("gui-ores.item.name", "");
            guiFileConfig.set("gui-ores.item.lores", Arrays.asList(""));
            guiFileConfig.set("gui-ores.item.glowing", false);
            //sword
            guiFileConfig.set("gui-sword.item.material", "IRON_SWORD");
            guiFileConfig.set("gui-sword.item.slot", 2);
            guiFileConfig.set("gui-sword.item.amount", 1);
            guiFileConfig.set("gui-sword.item.name", "");
            guiFileConfig.set("gui-sword.item.lores", Arrays.asList(""));
            guiFileConfig.set("gui-sword.item.glowing", false);
            //stuff
            guiFileConfig.set("gui-stuff.item.material", "IRON_CHESTPLATE");
            guiFileConfig.set("gui-stuff.item.slot", 3);
            guiFileConfig.set("gui-stuff.item.amount", 1);
            guiFileConfig.set("gui-stuff.item.name", "");
            guiFileConfig.set("gui-stuff.item.lores", Arrays.asList(""));
            guiFileConfig.set("gui-stuff.item.glowing", false);
            //dye
            guiFileConfig.set("gui-dye.item.material", "INK_SACK");
            guiFileConfig.set("gui-dye.item.slot", 4);
            guiFileConfig.set("gui-dye.item.amount", 1);
            guiFileConfig.set("gui-dye.item.name", "");
            guiFileConfig.set("gui-dye.item.lores", Arrays.asList(""));
            guiFileConfig.set("gui-dye.item.glowing", false);
            //food
            guiFileConfig.set("gui-food.item.material", "COOKED_BEEF");
            guiFileConfig.set("gui-food.item.slot", 5);
            guiFileConfig.set("gui-food.item.amount", 1);
            guiFileConfig.set("gui-food.item.name", "");
            guiFileConfig.set("gui-food.item.lores", Arrays.asList(""));
            guiFileConfig.set("gui-food.item.glowing", false);
            //log
            guiFileConfig.set("gui-log.item.material", "LOG");
            guiFileConfig.set("gui-log.item.slot", 6);
            guiFileConfig.set("gui-log.item.amount", 1);
            guiFileConfig.set("gui-log.item.name", "");
            guiFileConfig.set("gui-log.item.lores", Arrays.asList(""));
            guiFileConfig.set("gui-log.item.glowing", false);
            //unby
            guiFileConfig.set("gui-unby.item.material", "BARRIER");
            guiFileConfig.set("gui-unby.item.slot", 7);
            guiFileConfig.set("gui-unby.item.amount", 1);
            guiFileConfig.set("gui-unby.item.name", "");
            guiFileConfig.set("gui-unby.item.lores", Arrays.asList(""));
            guiFileConfig.set("gui-unby.item.glowing", false);
            guiFileConfig.save(guiFile);
            //block
            guiFileConfig.set("gui-block.item.material", "SPONGE");
            guiFileConfig.set("gui-block.item.slot", 8);
            guiFileConfig.set("gui-block.item.amount", 1);
            guiFileConfig.set("gui-block.item.name", "");
            guiFileConfig.set("gui-block.item.lores", Arrays.asList(""));
            guiFileConfig.set("gui-block.item.glowing", false);
            guiFileConfig.save(guiFile);
            //glass pane
            guiFileConfig.set("gui-pane.item.material", "STAINED_GLASS_PANE");
            guiFileConfig.set("gui-pane.item.slot", 9);
            guiFileConfig.set("gui-pane.item.amount", 1);
            guiFileConfig.set("gui-pane.item.data", 0);
            guiFileConfig.set("gui-pane.item.name", "");
            guiFileConfig.set("gui-pane.item.glowing", false);
            guiFileConfig.save(guiFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
