package fr.lightnew.files;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FolderUnby {
    private static String nameConfig = "Unby";
    private static String nameInConfig = "unby";
    public static File folderUnby = new File(CreateFiles.dataFolder, nameConfig+"Categories.yml");
    public static YamlConfiguration folderUnbyConfig = YamlConfiguration.loadConfiguration(folderUnby);

    public static void send() {
        try {
            int[] ints = {0,1,2,3};
            List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());
            //
            folderUnbyConfig.set("gui-shop-"+nameInConfig+".name", "Unby");
            folderUnbyConfig.set("gui-shop-"+nameInConfig+".size", 3); //3 = 3*9
            //Item example
            folderUnbyConfig.set("gui-shop-"+nameInConfig+".items.exemple.material", "BARRIER");
            folderUnbyConfig.set("gui-shop-"+nameInConfig+".items.exemple.slot", list);
            folderUnbyConfig.set("gui-shop-"+nameInConfig+".items.exemple.amount", 1);
            folderUnbyConfig.set("gui-shop-"+nameInConfig+".items.exemple.data", 0);
            folderUnbyConfig.set("gui-shop-"+nameInConfig+".items.exemple.name", "exemple");
            folderUnbyConfig.set("gui-shop-"+nameInConfig+".items.exemple.lores", Arrays.asList("&cLores", "&eexemple ITEM"));
            folderUnbyConfig.set("gui-shop-"+nameInConfig+".items.exemple.glowing", false);
            folderUnbyConfig.set("gui-shop-"+nameInConfig+".items.exemple.price", 34);
            folderUnbyConfig.set("gui-shop-"+nameInConfig+".items.exemple.mini-price", 34);
            folderUnbyConfig.set("gui-shop-"+nameInConfig+".items.exemple.max-price", 34);
            //save
            folderUnbyConfig.load(folderUnby);
            folderUnbyConfig.save(folderUnby);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
}
