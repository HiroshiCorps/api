/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  * Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *  * Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.spigot.command;

import fr.redxil.api.common.API;
import fr.redxil.api.common.player.APIPlayer;
import fr.redxil.api.common.utils.TimerUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public abstract class CommandBuilder implements CommandExecutor {

    private final HashMap<String, Long> coolDowm = new HashMap<>();
    protected JavaPlugin plugin;
    protected CommandInfo info;

    public CommandBuilder(JavaPlugin plugin) {
        this.plugin = plugin;

        this.info = this.getClass().getAnnotation(CommandInfo.class);

        plugin.getCommand(info.name()).setExecutor(this);
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }

    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        int sz = str.length();
        for (int i = 0; i < sz; i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public abstract void execute(CommandSender sender, Command cmd, String label, String[] args);

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        CommandInfo info = this.getClass().getAnnotation(CommandInfo.class);

        if (info.permission() != 0 && sender instanceof org.bukkit.entity.Player) {
            APIPlayer apiPlayer = API.get().getPlayerManager().getPlayer(((org.bukkit.entity.Player) sender).getUniqueId());

            if (apiPlayer.getRankPower() < info.permission()) {
                sender.sendMessage(info.noPermissionMessage());
                return false;
            }
        }

        if (info.args().length == 0
                || args.length >= info.args().length) {

            if (info.cooldown() != 0) {
                if (coolDowm.containsKey(sender.getName())) {

                    if (coolDowm.get(sender.getName()) <= System.currentTimeMillis()) {
                        execute(sender, cmd, label, args);
                        coolDowm.put(sender.getName(), System.currentTimeMillis() + (info.cooldown() * 1000L));
                    } else {
                        long seconds = coolDowm.get(sender.getName());

                        seconds -= System.currentTimeMillis();

                        seconds = seconds / 1000;

                        sender.sendMessage("§cVeuillez attendre encore " + TimerUtils.getTimeCooldown(Math.toIntExact(seconds)) + " avant d'éxécuter la commande");
                    }
                } else {
                    execute(sender, cmd, label, args);

                    coolDowm.put(sender.getName(), System.currentTimeMillis() + (info.cooldown() * 1000L));
                }
            } else {
                execute(sender, cmd, label, args);
            }

            return true;
        } else {
            StringBuilder args_string = new StringBuilder();

            for (String s : info.args()) {
                args_string.append(s).append(" ");
            }

            sender.sendMessage("§cErreur de syntaxe : /" + info.name() + " " + args_string);
            return false;
        }

    }

    public String getName() {
        return info.name();
    }

    public String getDescription() {
        return info.description();
    }

    public int getPower() {
        return info.permission();
    }

    public String[] getAliases() {
        return info.aliases();
    }

}
