package fr.lightnew.files;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FolderDye {
    private static String nameConfig = "Dye";
    private static String nameInConfig = "dye";
    public static File folderDye = new File(CreateFiles.dataFolder, nameConfig+"Categories.yml");
    public static YamlConfiguration folderDyeConfig = YamlConfiguration.loadConfiguration(folderDye);

    public static void send() {
        try {
            int[] ints = {0,1,2,3};
            List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());
            //
            folderDyeConfig.set("gui-shop-"+nameInConfig+".name", "Dyes");
            folderDyeConfig.set("gui-shop-"+nameInConfig+".size", 3); //3 = 3*9
            //Item example
            folderDyeConfig.set("gui-shop-"+nameInConfig+".items.exemple.material", "INK_SACK");
            folderDyeConfig.set("gui-shop-"+nameInConfig+".items.exemple.slot", list);
            folderDyeConfig.set("gui-shop-"+nameInConfig+".items.exemple.amount", 1);
            folderDyeConfig.set("gui-shop-"+nameInConfig+".items.exemple.data", 0);
            folderDyeConfig.set("gui-shop-"+nameInConfig+".items.exemple.name", "exemple");
            folderDyeConfig.set("gui-shop-"+nameInConfig+".items.exemple.lores", Arrays.asList("&cLores", "&eexemple ITEM"));
            folderDyeConfig.set("gui-shop-"+nameInConfig+".items.exemple.glowing", false);
            //buy
            folderDyeConfig.set("gui-shop-"+nameInConfig+".items.exemple.buy.price", 34);
            folderDyeConfig.set("gui-shop-"+nameInConfig+".items.exemple.buy.mini-price", 34);
            folderDyeConfig.set("gui-shop-"+nameInConfig+".items.exemple.buy.max-price", 34);
            //sale
            folderDyeConfig.set("gui-shop-"+nameInConfig+".items.exemple.sale.price", 34);
            folderDyeConfig.set("gui-shop-"+nameInConfig+".items.exemple.sale.mini-price", 34);
            folderDyeConfig.set("gui-shop-"+nameInConfig+".items.exemple.sale.max-price", 34);
            //save
            folderDyeConfig.load(folderDye);
            folderDyeConfig.save(folderDye);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
}
