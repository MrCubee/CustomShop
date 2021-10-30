package fr.lightnew.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.util.List;

public class ColorList {
    private static List<String> send2(List<String> m) {
        List<String> result = m;
        Bukkit.getOnlinePlayers().forEach(p -> {
            for (int i = 0; i< m.size(); i++)
                result.set(i, ChatColor.translateAlternateColorCodes('&', m.get(i)));
        });
        return result;
    }

    public static List<String> send(List<String> m) {
        List<String> test = send2(m);
        List<String> result = test;
        Bukkit.getOnlinePlayers().forEach(p -> {
            for (int i = 0; i< test.size(); i++)
                result.set(i, test.get(i).replace("%test%", "Message de test remplacer"));
        });
        return result;
    }
}
