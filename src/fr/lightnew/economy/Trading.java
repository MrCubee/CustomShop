package fr.lightnew.economy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Trading {

    public static void addPercentageToPrice(double percent, File file, YamlConfiguration configuration, String line_config/*Line price item*/) {
        if (file.exists()) {
            //file & config
            double itemPrice = configuration.getDouble(line_config);
            //calculate
            double percentage = new Double(percent / 100);
            double result = itemPrice * new Double(1 + percentage);
            //result
            try {
                configuration.set(line_config, result);
                configuration.save(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Une erreur avec le fichier au moment de changer le prix !");
    }

    public static void removePercentageToPrice(double percent, File file, YamlConfiguration configuration, String line_config) {
        if (file.exists()) {
            double itemPrice = configuration.getDouble(line_config);
            //calculate
            double percentage = new Double(percent / 100);
            double pre_result = new Double(itemPrice * percentage);
            double result = new Double(itemPrice - pre_result);
            //result
            try {
                configuration.set(line_config, result);
                configuration.save(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Une erreur avec le fichier au moment de changer le prix !");
    }

    /**
     *
     * dans pre_line_price mettre la ligne avant le price pour rajouter des données
     *
     **/

    public static void getMiniPrice(File file, YamlConfiguration configuration, String pre_line_price) {
        if (file.exists()) {
            double itemPrice = new Double(pre_line_price + ".price");
            double miniPrice = new Double(pre_line_price + ".mini-price");
            if (miniPrice != Double.parseDouble(null)) {
                if (miniPrice >= itemPrice) {
                    configuration.set(pre_line_price + ".mini-price", itemPrice);
                } else return;
            } else configuration.set(pre_line_price+".mini-price", 0);
        } else Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Une erreur avec le fichier au moment de changer le prix minimum !");
    }

    public static void getMaxPrice(File file, YamlConfiguration configuration, String pre_line_price) {
        if (file.exists()) {
            double itemPrice = new Double(pre_line_price + ".price");
            double maxPrice = new Double(pre_line_price + ".max-price");
            if (maxPrice != Double.parseDouble(null)) {
                if (maxPrice <= itemPrice) {
                    configuration.set(pre_line_price + ".max-price", itemPrice);
                } else return;
            } else configuration.set(pre_line_price+".max-price", 0);
        } else Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Une erreur avec le fichier au moment de changer le prix minimum !");
    }
}
