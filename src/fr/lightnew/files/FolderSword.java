package fr.lightnew.files;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FolderSword {
    private static String nameConfig = "Sword";
    private static String nameInConfig = "sword";
    public static File folderSword = new File(CreateFiles.dataFolder, nameConfig+"Categories.yml");
    public static YamlConfiguration folderSwordConfig = YamlConfiguration.loadConfiguration(folderSword);

    public static void send() {
        try {
            int[] ints = {0,1,2,3};
            List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());
            //
            folderSwordConfig.set("gui-shop-"+nameInConfig+".name", "Sword");
            folderSwordConfig.set("gui-shop-"+nameInConfig+".size", 3); //3 = 3*9
            //Item example
            folderSwordConfig.set("gui-shop-"+nameInConfig+".items.exemple.material", "IRON_SWORD");
            folderSwordConfig.set("gui-shop-"+nameInConfig+".items.exemple.slot", list);
            folderSwordConfig.set("gui-shop-"+nameInConfig+".items.exemple.amount", 1);
            folderSwordConfig.set("gui-shop-"+nameInConfig+".items.exemple.data", 0);
            folderSwordConfig.set("gui-shop-"+nameInConfig+".items.exemple.name", "exemple");
            folderSwordConfig.set("gui-shop-"+nameInConfig+".items.exemple.lores", Arrays.asList("&cLores", "&eexemple ITEM"));
            folderSwordConfig.set("gui-shop-"+nameInConfig+".items.exemple.glowing", false);
            //buy
            folderSwordConfig.set("gui-shop-"+nameInConfig+".items.exemple.buy.price", 34);
            folderSwordConfig.set("gui-shop-"+nameInConfig+".items.exemple.buy.mini-price", 34);
            folderSwordConfig.set("gui-shop-"+nameInConfig+".items.exemple.buy.max-price", 34);
            //sale
            folderSwordConfig.set("gui-shop-"+nameInConfig+".items.exemple.sale.price", 34);
            folderSwordConfig.set("gui-shop-"+nameInConfig+".items.exemple.sale.mini-price", 34);
            folderSwordConfig.set("gui-shop-"+nameInConfig+".items.exemple.sale.max-price", 34);
            //save
            folderSwordConfig.load(folderSword);
            folderSwordConfig.save(folderSword);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
}
