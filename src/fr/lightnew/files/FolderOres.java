package fr.lightnew.files;

import org.bukkit.Material;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FolderOres {
    public static File folderOres = new File(CreateFiles.dataFolder, "OresCategories.yml");
    public static YamlConfiguration folderOresConfig = YamlConfiguration.loadConfiguration(folderOres);

    public static void send() {
        try {
            int[] ints = {0,1,2,3};
            List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());

            /**CREER UNE LISTE DE INT & UTILISER DANS LE CODE*/
            //
            folderOresConfig.set("gui-shop-ores.name", "Ores");
            folderOresConfig.set("gui-shop-ores.size", 3); //3 = 3*9
            //Item example
            folderOresConfig.set("gui-shop-ores.items.exemple.material", "COAL_ORE");
            folderOresConfig.set("gui-shop-ores.items.exemple.slot", list);
            folderOresConfig.set("gui-shop-ores.items.exemple.amount", 1);
            folderOresConfig.set("gui-shop-ores.items.exemple.data", 0);
            folderOresConfig.set("gui-shop-ores.items.exemple.name", "exemple");
            folderOresConfig.set("gui-shop-ores.items.exemple.lores", Arrays.asList("&cLores", "&eexemple ITEM"));
            folderOresConfig.set("gui-shop-ores.items.exemple.glowing", false);
            //buy
            folderOresConfig.set("gui-shop-ores.items.exemple.buy.price", 34);
            folderOresConfig.set("gui-shop-ores.items.exemple.buy.mini-price", 34);
            folderOresConfig.set("gui-shop-ores.items.exemple.buy.max-price", 34);
            //sale
            folderOresConfig.set("gui-shop-ores.items.exemple.sale.price", 34);
            folderOresConfig.set("gui-shop-ores.items.exemple.sale.mini-price", 34);
            folderOresConfig.set("gui-shop-ores.items.exemple.sale.max-price", 34);
            //save
            folderOresConfig.load(folderOres);
            folderOresConfig.save(folderOres);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
}
