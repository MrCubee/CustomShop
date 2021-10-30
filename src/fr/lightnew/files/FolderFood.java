package fr.lightnew.files;

import org.bukkit.Material;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FolderFood {
    private static String nameConfig = "Food";
    private static String nameInConfig = "food";
    public static File folderFood = new File(CreateFiles.dataFolder, nameConfig+"Categories.yml");
    public static YamlConfiguration folderFoodConfig = YamlConfiguration.loadConfiguration(folderFood);

    public static void send() {
        try {
            int[] ints = {0,1,2,3};
            List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());
            //
            folderFoodConfig.set("gui-shop-"+nameInConfig+".name", "Food");
            folderFoodConfig.set("gui-shop-"+nameInConfig+".size", 3); //3 = 3*9
            //Item example
            folderFoodConfig.set("gui-shop-"+nameInConfig+".items.exemple.material", "COOKED_BEEF");
            folderFoodConfig.set("gui-shop-"+nameInConfig+".items.exemple.slot", list);
            folderFoodConfig.set("gui-shop-"+nameInConfig+".items.exemple.amount", 1);
            folderFoodConfig.set("gui-shop-"+nameInConfig+".items.exemple.data", 0);
            folderFoodConfig.set("gui-shop-"+nameInConfig+".items.exemple.name", "exemple");
            folderFoodConfig.set("gui-shop-"+nameInConfig+".items.exemple.lores", Arrays.asList("&cLores", "&eexemple ITEM"));
            folderFoodConfig.set("gui-shop-"+nameInConfig+".items.exemple.glowing", false);
            //buy
            folderFoodConfig.set("gui-shop-"+nameInConfig+".items.exemple.buy.price", 34);
            folderFoodConfig.set("gui-shop-"+nameInConfig+".items.exemple.buy.mini-price", 34);
            folderFoodConfig.set("gui-shop-"+nameInConfig+".items.exemple.buy.max-price", 34);
            //sale
            folderFoodConfig.set("gui-shop-"+nameInConfig+".items.exemple.sale.price", 34);
            folderFoodConfig.set("gui-shop-"+nameInConfig+".items.exemple.sale.mini-price", 34);
            folderFoodConfig.set("gui-shop-"+nameInConfig+".items.exemple.sale.max-price", 34);
            //save
            folderFoodConfig.load(folderFood);
            folderFoodConfig.save(folderFood);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
}
