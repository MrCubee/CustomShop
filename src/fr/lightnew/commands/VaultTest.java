package fr.lightnew.commands;

import fr.lightnew.CustomShop;
import fr.lightnew.economy.VerifyBalance;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VaultTest implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Economy eco = CustomShop.getEconomy();
            player.sendMessage(ChatColor.GREEN + "Votre money -> " + ChatColor.RESET + eco.getBalance(player));
            //add balance
            VerifyBalance.setPlayerBalance(player, 15.0);
            player.sendMessage(ChatColor.YELLOW + "UPDATE ! -> votre money -> " + ChatColor.RESET + eco.getBalance(player));
        }
        return false;
    }
}