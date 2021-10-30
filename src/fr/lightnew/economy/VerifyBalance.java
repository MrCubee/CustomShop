package fr.lightnew.economy;

import fr.lightnew.CustomShop;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.entity.Player;

public class VerifyBalance {
    private static Economy eco = CustomShop.getEconomy();

    public static Double getPlayerBalance(Player player) {
        double result = 0;
        if (!player.isEmpty())
            result = eco.getBalance(player);
        return result;
    }

    public static Boolean transactionIsSuccess(double price, Player player) {
        double balance = getPlayerBalance(player);
        if (balance >= price) {return true;} else return false;
    }

    public static void setPlayerBalance(Player player, double addMoney) {
        if (player.isEmpty())
            eco.depositPlayer(player, addMoney);
    }
}
