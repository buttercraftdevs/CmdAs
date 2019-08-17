package me.xxsirgamesxx.cmdas;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.entity.Entity;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerTeleportEvent;
import cn.nukkit.level.Level;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;
import cn.nukkit.level.Location;
import cn.nukkit.command.PluginIdentifiableCommand;
import cn.nukkit.plugin.Plugin;

import cn.nukkit.command.Command;


import java.util.Map;


public class Main extends PluginBase implements Listener {

    //private static final int configVersion = 3;
    //private Config config;
    private static Main instance;

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {

        //this.getServer().getPluginManager().registerEvents(this, this);		
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("cmdas")) {
			if(sender.hasPermission("cmdas.run")){
				if(!(args.length < 1)) {
					if(this.getServer().getInstance().getPlayer(args[0]) == null) {
						sender.sendMessage("§c[CmdAs] Player not found!");
						return true;
					}
					if(sender instanceof Player){
						Player sdr = (Player) sender;
						if(sdr == this.getServer().getInstance().getPlayer(args[0])){
							sender.sendMessage("§c[CmdAs] Player cannot be yourself");
						}
						String sendcmd = "";
						for (int i = 1; i < args.length; i++) {
							sendcmd += args[i] + " ";
						}
						if (sendcmd.length() > 0) {
						sendcmd = sendcmd.substring(0, sendcmd.length() - 1);
						}
						Player x = (Player) this.getServer().getInstance().getPlayer(args[0]);
						this.getServer().dispatchCommand(x, sendcmd);
					} else {
						String sendcmd = "";
						for (int i = 1; i < args.length; i++) {
							sendcmd += args[i] + " ";
						}
						if (sendcmd.length() > 0) {
						sendcmd = sendcmd.substring(0, sendcmd.length() - 1);
						}
						Player x = (Player) this.getServer().getInstance().getPlayer(args[0]);
						this.getServer().dispatchCommand(x, sendcmd);
						sender.sendMessage("§7[CmdAs] Successfully ran command '§a" + sendcmd + "§7' for player §6" + x.getName());
					
					}
				} else {
					sender.sendMessage("[CmdAs] Usage: /cmdas <player> <cmd without slash>");
					return true;
				}
					
			} else {
				sender.sendMessage("[CmdAs] Usage: /cmdas <player> <cmd without slash>");
			}
			return true;		
		}
		return true;
	}
}
