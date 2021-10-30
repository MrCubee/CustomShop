package fr.lightnew;

import fr.lightnew.commands.Shop;
import fr.lightnew.commands.VaultTest;
import fr.lightnew.events.InventoryEvent;
import fr.lightnew.events.InventoryEventBuy;
import fr.lightnew.files.CreateFiles;
import fr.lightnew.gui.GuiReturn;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class CustomShop extends JavaPlugin {
    private File folder = new File(getDataFolder()+"/FilesShop");

    Plugin Vault = getServer().getPluginManager().getPlugin("Vault");
    private static Economy economy = null;
    public static CustomShop instance;
    //if (Vault == null) {
    //            getServer().getPluginManager().disablePlugin(this);
    //            log(ChatColor.RED + "Il vous manque un des plugins ! -> Vault");
    //        }else{

    @Override
    public void onEnable() {
        saveDefaultConfig();
        this.instance = this;
        //commands
        getCommand("shop").setExecutor(new Shop());
        getCommand("eco").setExecutor(new VaultTest());
        //listeners
        Bukkit.getPluginManager().registerEvents(new InventoryEvent(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryEventBuy(), this);
        Bukkit.getPluginManager().registerEvents(new GuiReturn(), this);
        //others
        log("[" + ChatColor.GREEN + "CustomShop" + ChatColor.RESET + "] " + ChatColor.YELLOW + "est ON");
        createFiles();
        //Vault
        if (!setupEconomy()) {
            log(String.format("[%s]" + ChatColor.RED + "\n--------ERROR--------" +
                            ChatColor.RED + "\n\n      Il Vous manque une dependance \n" +
                            ChatColor.GREEN + "      Voici le site pour vous diriger -> " + ChatColor.RESET + "https://github.com/milkbowl/Vault#supported-plugins\n\n" +
                            ChatColor.RED + "--------ERROR--------"
                    , getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        //
    }

    @Override
    public void onDisable() {
        log("[" + ChatColor.RED + "CustomShop" + ChatColor.RESET +"] " + ChatColor.YELLOW + "est OFF");
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        economy = rsp.getProvider();
        return economy != null;
    }

    public static Economy getEconomy() {
        return economy;
    }
    public void createFiles() {
        //Folder FilesShop
        if (!folder.exists()) {
            if (folder.mkdir()) {
                log(ChatColor.GREEN + "Dossier -> FilesShop est installe");
            } else log(ChatColor.RED + "Dossier -> FilesShop à un probleme");
        }
        //
        CreateFiles.createFiles();
    }
    public void log(String s) {Bukkit.getConsoleSender().sendMessage(s);}
}
