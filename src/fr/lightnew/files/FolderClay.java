package fr.lightnew.files;

import org.bukkit.Material;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FolderClay {
    public static File folderClay = new File(CreateFiles.dataFolder, "ClayCategories.yml");
    public static YamlConfiguration folderClayConfig = YamlConfiguration.loadConfiguration(folderClay);

    public static void send() {
        try {
            int[] ints = {0,1,2,3};
            List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());

            /**CREER UNE LISTE DE INT & UTILISER DANS LE CODE*/
            //
            folderClayConfig.set("gui-shop-clay.name", "Clay");
            folderClayConfig.set("gui-shop-clay.size", 3); //3 = 3*9
            //Item example
            folderClayConfig.set("gui-shop-clay.items.exemple.material", "CLAY");
            folderClayConfig.set("gui-shop-clay.items.exemple.slot", list);
            folderClayConfig.set("gui-shop-clay.items.exemple.amount", 1);
            folderClayConfig.set("gui-shop-clay.items.exemple.data", 0);
            folderClayConfig.set("gui-shop-clay.items.exemple.name", "exemple");
            folderClayConfig.set("gui-shop-clay.items.exemple.lores", Arrays.asList("&cLores", "&eexemple ITEM"));
            folderClayConfig.set("gui-shop-clay.items.exemple.glowing", false);
            //buy
            folderClayConfig.set("gui-shop-clay.items.exemple.buy.price", 34);
            folderClayConfig.set("gui-shop-clay.items.exemple.buy.mini-price", 34);
            folderClayConfig.set("gui-shop-clay.items.exemple.buy.max-price", 34);
            //sale
            folderClayConfig.set("gui-shop-clay.items.exemple.sale.price", 34);
            folderClayConfig.set("gui-shop-clay.items.exemple.sale.mini-price", 34);
            folderClayConfig.set("gui-shop-clay.items.exemple.sale.max-price", 34);
            //save
            folderClayConfig.load(folderClay);
            folderClayConfig.save(folderClay);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
}
