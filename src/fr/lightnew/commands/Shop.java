package fr.lightnew.commands;

import fr.lightnew.gui.GuiInterface;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Shop implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof Player) {
            if (args.length == 0) {
                GuiInterface.send((Player) sender);
            }
        }
        return false;
    }
}
