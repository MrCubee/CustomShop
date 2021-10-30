package fr.lightnew.files;

import org.bukkit.Material;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FolderStuff {
    private static String nameConfig = "Stuff";
    private static String nameInConfig = "stuff";
    public static File folderStuff = new File(CreateFiles.dataFolder, nameConfig+"Categories.yml");
    public static YamlConfiguration folderStuffConfig = YamlConfiguration.loadConfiguration(folderStuff);

    public static void send() {
        try {
            int[] ints = {0,1,2,3};
            List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());
            //
            folderStuffConfig.set("gui-shop-"+nameInConfig+".name", "Stuff");
            folderStuffConfig.set("gui-shop-"+nameInConfig+".size", 3); //3 = 3*9
            //Item example
            folderStuffConfig.set("gui-shop-"+nameInConfig+".items.exemple.material", "IRON_CHESTPLATE");
            folderStuffConfig.set("gui-shop-"+nameInConfig+".items.exemple.slot", list);
            folderStuffConfig.set("gui-shop-"+nameInConfig+".items.exemple.amount", 1);
            folderStuffConfig.set("gui-shop-"+nameInConfig+".items.exemple.data", 0);
            folderStuffConfig.set("gui-shop-"+nameInConfig+".items.exemple.name", "exemple");
            folderStuffConfig.set("gui-shop-"+nameInConfig+".items.exemple.lores", Arrays.asList("&cLores", "&eexemple ITEM"));
            folderStuffConfig.set("gui-shop-"+nameInConfig+".items.exemple.glowing", false);
            //buy
            folderStuffConfig.set("gui-shop-"+nameInConfig+".items.exemple.buy.price", 34);
            folderStuffConfig.set("gui-shop-"+nameInConfig+".items.exemple.buy.mini-price", 34);
            folderStuffConfig.set("gui-shop-"+nameInConfig+".items.exemple.buy.max-price", 34);
            //sale
            folderStuffConfig.set("gui-shop-"+nameInConfig+".items.exemple.sale.price", 34);
            folderStuffConfig.set("gui-shop-"+nameInConfig+".items.exemple.sale.mini-price", 34);
            folderStuffConfig.set("gui-shop-"+nameInConfig+".items.exemple.sale.max-price", 34);
            //save
            folderStuffConfig.load(folderStuff);
            folderStuffConfig.save(folderStuff);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
}
