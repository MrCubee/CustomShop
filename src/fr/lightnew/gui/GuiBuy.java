package fr.lightnew.gui;

import fr.lightnew.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GuiBuy {
    public static ItemStack itemToBy;
    public static Inventory inventory;
    public static int slot;

    public static ItemStack RED_ADD_ONE = ItemBuilder.create(Material.REDSTONE_BLOCK, 1, ChatColor.RED + "-1",
            ChatColor.YELLOW + "-> " +ChatColor.GOLD + "cliquer sur ce bloc pour enlever 1");
    public static ItemStack RED_ADD_TEEN = ItemBuilder.create(Material.REDSTONE_BLOCK, 10, ChatColor.RED + "-10",
            ChatColor.YELLOW + "-> " +ChatColor.GOLD + "cliquer sur ce bloc pour enlever 10");
    public static ItemStack RED_ADD_STACK = ItemBuilder.create(Material.REDSTONE_BLOCK, 64, ChatColor.RED + "-64",
            ChatColor.YELLOW + "-> " +ChatColor.GOLD + "cliquer sur ce bloc pour enlever 64");
    public static ItemStack GREEN_ADD_ONE = ItemBuilder.create(Material.EMERALD_BLOCK, 1, ChatColor.GREEN + "+1",
            ChatColor.YELLOW + "-> " +ChatColor.GOLD + "cliquer sur ce bloc pour ajouter 1");
    public static ItemStack GREEN_ADD_TEEN = ItemBuilder.create(Material.EMERALD_BLOCK, 10, ChatColor.GREEN + "+10",
            ChatColor.YELLOW + "-> " +ChatColor.GOLD + "cliquer sur ce bloc pour ajouter 10");
    public static ItemStack GREEN_ADD_STACK = ItemBuilder.create(Material.EMERALD_BLOCK, 64, ChatColor.GREEN + "+64",
            ChatColor.YELLOW + "-> " +ChatColor.GOLD + "cliquer sur ce bloc pour ajouter 64");

    private static ItemStack GLASS_PANE_BLUE = ItemBuilder.createWithoutLores(Material.STAINED_GLASS_PANE, 1, (byte) 11);
    private static ItemStack GLASS_PANE_AQUA = ItemBuilder.createWithoutLores(Material.STAINED_GLASS_PANE, 1, (byte) 3);
    private static ItemStack GLASS_PANE_WHITE = ItemBuilder.createWithoutLores(Material.STAINED_GLASS_PANE, 1, (byte) 0);

    public static ItemStack CHECK_VALID_TRANSACT = ItemBuilder.create(Material.GOLD_BLOCK, 1, ChatColor.GOLD + "VALIDER",
            ChatColor.GRAY + "Clic ici pour valider la transaction !");

    public static void send(Player player, ItemStack item) {
        Inventory inv = Bukkit.createInventory(player, 6*9, ChatColor.GREEN + "Choix Achat");
        inventory=inv;
        slot=13;
        inv.clear();
        ItemStack itemToBuy = item;
        itemToBy=itemToBuy;
        int[] aqua = new int[]{0,1,7,8,9,17,36,44,46,52,53};
        int[] blue = new int[]{2,3,5,6,18,26,27,35,47,48,50,51};
        for (int loc : aqua)
            inv.setItem(loc, GLASS_PANE_AQUA);
        for (int loc : blue)
            inv.setItem(loc, GLASS_PANE_BLUE);
        inv.setItem(4, GLASS_PANE_WHITE);
        inv.setItem(49, CHECK_VALID_TRANSACT);
        inv.setItem(13, itemToBuy);
        inv.setItem(28, RED_ADD_ONE);
        inv.setItem(29, RED_ADD_TEEN);
        inv.setItem(30, RED_ADD_STACK);
        inv.setItem(32, GREEN_ADD_ONE);
        inv.setItem(33, GREEN_ADD_TEEN);
        inv.setItem(34, GREEN_ADD_STACK);
        inv.setItem(45, GuiReturn.ITEM_RETURN);
        player.openInventory(inv);
    }

    public static int addToItemToBuy(int addAmount) {
        int oldAmount = itemToBy.getAmount();
        int newAmount = new Integer(oldAmount+addAmount);
        if (newAmount >=64)
            newAmount = 64;
        return newAmount;
    }

    public static int removeToItemToBuy(int removeAmount) {
        int oldAmount = itemToBy.getAmount();
        int newAmount = new Integer(oldAmount-removeAmount);
        if (newAmount <= 0)
            newAmount = 1;
        return newAmount;
    }
}
