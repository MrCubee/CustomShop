package fr.lightnew.files;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FolderBlocks {
    private static String nameConfig = "Blocks";
    private static String nameInConfig = "block";
    public static File folderBlock = new File(CreateFiles.dataFolder, nameConfig+"Categories.yml");
    public static YamlConfiguration folderBlockConfig = YamlConfiguration.loadConfiguration(folderBlock);

    public static void send() {
        try {
            int[] ints = {0,1,2,3};
            List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());
            //
            folderBlockConfig.set("gui-shop-block.name", "Blocks");
            folderBlockConfig.set("gui-shop-"+nameInConfig+".size", 3); //3 = 3*9
            //Item example
            folderBlockConfig.set("gui-shop-"+nameInConfig+".items.exemple.material", "STONE");
            folderBlockConfig.set("gui-shop-"+nameInConfig+".items.exemple.slot", list);
            folderBlockConfig.set("gui-shop-"+nameInConfig+".items.exemple.amount", 1);
            folderBlockConfig.set("gui-shop-"+nameInConfig+".items.exemple.data", 0);
            folderBlockConfig.set("gui-shop-"+nameInConfig+".items.exemple.name", "exemple");
            folderBlockConfig.set("gui-shop-"+nameInConfig+".items.exemple.lores", Arrays.asList("&cLores", "&eexemple ITEM"));
            folderBlockConfig.set("gui-shop-"+nameInConfig+".items.exemple.glowing", false);
            //buy
            folderBlockConfig.set("gui-shop-"+nameInConfig+".items.exemple.buy.price", 34);
            folderBlockConfig.set("gui-shop-"+nameInConfig+".items.exemple.buy.mini-price", 34);
            folderBlockConfig.set("gui-shop-"+nameInConfig+".items.exemple.buy.max-price", 34);
            //sale
            folderBlockConfig.set("gui-shop-"+nameInConfig+".items.exemple.sale.price", 34);
            folderBlockConfig.set("gui-shop-"+nameInConfig+".items.exemple.sale.mini-price", 34);
            folderBlockConfig.set("gui-shop-"+nameInConfig+".items.exemple.sale.max-price", 34);
            //save
            folderBlockConfig.load(folderBlock);
            folderBlockConfig.save(folderBlock);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
}
