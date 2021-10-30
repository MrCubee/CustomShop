package fr.lightnew.files;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FolderLog {
    private static String nameConfig = "Log";
    private static String nameInConfig = "log";
    public static File folderLog = new File(CreateFiles.dataFolder, nameConfig+"Categories.yml");
    public static YamlConfiguration folderLogConfig = YamlConfiguration.loadConfiguration(folderLog);

    public static void send() {
        try {
            int[] ints = {0,1,2,3};
            List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());
            //
            folderLogConfig.set("gui-shop-"+nameInConfig+".name", "Log");
            folderLogConfig.set("gui-shop-"+nameInConfig+".size", 3); //3 = 3*9
            //Item example
            folderLogConfig.set("gui-shop-"+nameInConfig+".items.exemple.material", "LOG");
            folderLogConfig.set("gui-shop-"+nameInConfig+".items.exemple.slot", list);
            folderLogConfig.set("gui-shop-"+nameInConfig+".items.exemple.amount", 1);
            folderLogConfig.set("gui-shop-"+nameInConfig+".items.exemple.data", 0);
            folderLogConfig.set("gui-shop-"+nameInConfig+".items.exemple.name", "exemple");
            folderLogConfig.set("gui-shop-"+nameInConfig+".items.exemple.lores", Arrays.asList("&cLores", "&eexemple ITEM"));
            folderLogConfig.set("gui-shop-"+nameInConfig+".items.exemple.glowing", false);
            //buy
            folderLogConfig.set("gui-shop-"+nameInConfig+".items.exemple.buy.price", 34);
            folderLogConfig.set("gui-shop-"+nameInConfig+".items.exemple.buy.mini-price", 34);
            folderLogConfig.set("gui-shop-"+nameInConfig+".items.exemple.buy.max-price", 34);
            //sale
            folderLogConfig.set("gui-shop-"+nameInConfig+".items.exemple.sale.price", 34);
            folderLogConfig.set("gui-shop-"+nameInConfig+".items.exemple.sale.mini-price", 34);
            folderLogConfig.set("gui-shop-"+nameInConfig+".items.exemple.sale.max-price", 34);
            //save
            folderLogConfig.load(folderLog);
            folderLogConfig.save(folderLog);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
}
