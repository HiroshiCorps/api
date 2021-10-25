/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  * Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *  * Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.spigot.minigame;

import fr.redxil.api.common.API;
import fr.redxil.api.common.game.GameEnum;
import fr.redxil.api.common.game.Games;
import fr.redxil.api.common.player.APIPlayer;
import fr.redxil.api.common.server.Server;
import fr.redxil.api.common.team.Team;
import fr.redxil.api.common.team.TeamManager;
import fr.redxil.api.common.time.TimerGest;
import fr.redxil.api.common.utils.TextUtils;
import fr.redxil.api.spigot.minigame.chests.ChestsManager;
import fr.redxil.api.spigot.minigame.kits.KitsManager;
import fr.redxil.api.spigot.minigame.managers.FilesAPI;
import fr.redxil.api.spigot.minigame.pmmanager.PMListen;
import fr.redxil.api.spigot.utils.ActionBar;
import fr.redxil.api.spigot.utils.Title;
import org.bukkit.Sound;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;
import java.util.List;

public abstract class GameBuilder {

    private static GameBuilder gameBuilder = null;
    private final JavaPlugin plugin;
    private final KitsManager kitsManager;
    private final ChestsManager chestsManager;
    private final GameEnum gameEnum;
    private final TimerGest timerGest;
    private String prefix = TextUtils.getPrefix("SERVER");

    public GameBuilder(JavaPlugin plugin, GameEnum gameEnum) {
        gameBuilder = this;
        this.plugin = plugin;
        this.gameEnum = gameEnum;
        this.kitsManager = new KitsManager();
        this.chestsManager = new ChestsManager();
        this.timerGest = new TimerGest();

        String config = FilesAPI.CONFIG.getFileName();
        saveResourceAs(config, config);

        initGame();
        new PMListen();
    }

    public static GameBuilder getGameBuilder() {
        return gameBuilder;
    }

    public void initGame() {
        Server server = API.get().getServer();
        if (gameEnum.isCanHost() && server.isHostDedicated()) {
            APIPlayer apiPlayer = API.get().getPlayerManager().getPlayer(server.getServerName());
            if (apiPlayer != null) {
                API.get().getGamesManager().initHostServer(API.get().getPluginEnabler().getServerName(), API.get().getPlayerManager().getPlayer(server.getHostAuthor()), gameEnum);
                apiPlayer.switchServer(server.getServerName());
                return;
            } else if (gameEnum.isHostOnly()) {
                API.get().getPluginEnabler().shutdownServer("Missing host");
                return;
            }
        }
        API.get().getGamesManager().initGameServer(server.getServerName(), gameEnum);
    }

    public Games getGame() {
        return API.get().getGame();
    }

    public boolean hasTeams() {
        return !getTeamManager().getTeamList().isEmpty();
    }

    private void saveResourceAs(String resourcePath, String outputPath) {
        JavaPlugin plugin = this.getPlugin();

        if (resourcePath == null || resourcePath.isEmpty()) {
            throw new IllegalArgumentException("ResourcePath cannot be null or empty");
        }

        InputStream in = getPlugin().getResource(resourcePath);

        if (in == null) {
            throw new IllegalArgumentException("The resource '" + resourcePath + "' cannot be found in plugin jar");
        }

        if (!plugin.getDataFolder().exists() && !plugin.getDataFolder().mkdir()) {
            plugin.getLogger().severe("Failed to make directory");
        }

        File outFile = new File(plugin.getDataFolder(), outputPath);

        try {
            if (!outFile.exists()) {
                plugin.getLogger().info("The " + resourcePath + " was not found, creation in progress...");

                OutputStream out = new FileOutputStream(outFile);
                byte[] buf = new byte[1024];
                int n;

                while ((n = in.read(buf)) >= 0) {
                    out.write(buf, 0, n);
                }

                out.close();
                in.close();

                if (!outFile.exists()) {
                    plugin.getLogger().severe("Unable to copy file");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract void onPlayerJoin(org.bukkit.entity.Player player);

    public abstract void onPlayerLeave(org.bukkit.entity.Player player);

    public abstract void onSpectatorJoin(org.bukkit.entity.Player player);

    public abstract void onSpectatorLeave(org.bukkit.entity.Player player);

    public abstract boolean start();

    public abstract boolean forceStart();

    public abstract boolean stopStart();

    public abstract void forceEnd(String reason);

    public abstract void forceWin(Team team, String reason);

    public void broadcastTitle(String title, String subtitle) {
        for (org.bukkit.entity.Player player : plugin.getServer().getOnlinePlayers()) {
            Title.sendTitle(player, title, subtitle, 10, 20, 10);
        }
    }

    public void broadcastMessage(String message) {
        for (org.bukkit.entity.Player player : plugin.getServer().getOnlinePlayers()) {
            player.sendMessage(message);
        }
    }

    public void broadcastActionBar(String message) {
        for (org.bukkit.entity.Player player : plugin.getServer().getOnlinePlayers()) {
            ActionBar.sendActionBar(player, message);
        }
    }

    public JavaPlugin getPlugin() {
        return plugin;
    }

    public TeamManager getTeamManager() {
        return API.get().getTeamManager();
    }

    public KitsManager getKitsManager() {
        return kitsManager;
    }

    public ChestsManager getChestsManager() {
        return chestsManager;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public TimerGest getTimerGest() {
        return timerGest;
    }

    public void sendTitle(List<org.bukkit.entity.Player> playerList, String title, String subTitle, int fadeIn, int stay, int fadeOut) {
        for (org.bukkit.entity.Player target : playerList) {
            Title.sendTitle(target, title, subTitle, fadeIn, stay, fadeOut);
        }
    }

    public void sendSound(List<org.bukkit.entity.Player> playerList, Sound sound, int v1, int v2) {
        for (org.bukkit.entity.Player target : playerList) {
            target.playSound(target.getLocation(), sound, v1, v2);
        }
    }

    public void sendTitleAndSound(List<org.bukkit.entity.Player> playerList, String title, String subTitle, int fadeIn, int stay, int fadeOut, Sound sound, int v1, int v2) {
        for (org.bukkit.entity.Player target : playerList) {
            Title.sendTitle(target, title, subTitle, fadeIn, stay, fadeOut);
            target.playSound(target.getLocation(), sound, v1, v2);
        }
    }

}
