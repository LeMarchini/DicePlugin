package com.coodaax.plugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(this, this);
		Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "The Dice Plugin has been Enabled!");

	}

	public void onDisable() {

	}

//	@EventHandler
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (cmd.getName().equals("dice")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				int max = 6;
				int min = 1;
				String nome = player.getName();

				if (args.length == 0) {
					if (sender instanceof Player) {
						int dado = (int) (Math.random() * (max - min + 1) + min);
						Bukkit.broadcastMessage(ChatColor.GOLD + "The " + ChatColor.RED + nome + ChatColor.GOLD
								+ "'s Dice rolls: " + ChatColor.BLUE + dado);
						return true;
					}
				}
				if (args[0].equalsIgnoreCase("2")) {
					int dado = (int) (Math.random() * (max - min + 1) + min);
					int dado2 = (int) (Math.random() * (max - min + 1) + min);
					Bukkit.broadcastMessage(ChatColor.GOLD + "The " + ChatColor.RED + nome + ChatColor.GOLD
							+ "'s Dice rolls: " + ChatColor.BLUE + dado);
					Bukkit.broadcastMessage(ChatColor.GOLD + "The " + ChatColor.RED + nome + ChatColor.GOLD
							+ "'s Second Dice roll: " + ChatColor.BLUE + dado2);
				} else {
					if (sender instanceof Player) {
						player.sendMessage("The plugin can roll 2 numbers at once!");
						player.sendMessage("Try /dice to roll a number (1~6).");
						player.sendMessage("Try /dice 2 to roll 2 numbers (1~6).");
					}

				}
			}

		}

		return false;
	}
}
