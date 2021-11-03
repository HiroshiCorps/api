/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.spigot.minigame;

import fr.redxil.api.common.API;
import fr.redxil.api.common.game.GameEnum;
import fr.redxil.api.common.game.Games;
import fr.redxil.api.common.game.team.Team;
import fr.redxil.api.common.game.team.TeamManager;
import fr.redxil.api.common.player.APIPlayer;
import fr.redxil.api.common.server.Server;
import fr.redxil.api.common.time.TimerGest;
import fr.redxil.api.spigot.minigame.chest.ChestSystem;
import fr.redxil.api.spigot.minigame.managers.FilesAPI;
import fr.redxil.api.spigot.minigame.pmmanager.PMListen;
import fr.redxil.api.spigot.utils.ActionBar;
import fr.redxil.api.spigot.utils.Title;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;
import java.util.List;

public abstract class GameBuilder {

    private static GameBuilder gameBuilder = null;
    private final JavaPlugin plugin;
    private final ChestSystem chestsManager;
    private final GameEnum gameEnum;
    private final TimerGest timerGest;
    private String prefix = "Server";

    public GameBuilder(JavaPlugin plugin, GameEnum gameEnum) {
        gameBuilder = this;
        this.plugin = plugin;
        this.gameEnum = gameEnum;
        this.chestsManager = new ChestSystem();
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
        Title.sendTitleToAllPlayers(title, subtitle, 10, 20,10);
    }

    public void broadcastMessage(String message) {
        plugin.getServer().getOnlinePlayers().forEach(player -> player.sendMessage(message));
    }

    public void broadcastActionBar(String message) {
        plugin.getServer().getOnlinePlayers().forEach(player -> ActionBar.sendActionBar(player, message));
    }

    public void broadcastSound(Sound sound) {
        plugin.getServer().getOnlinePlayers().forEach(player -> player.playSound(player.getLocation(), sound, 0f, 0f));
    }

    public void broadcastTitle(List<Player> players, String title, String subtitle) {
        players.forEach(player -> Title.sendTitle(player, title, subtitle, 10, 20, 10));
    }

    public void broadcastMessage(List<Player> players, String message) {
        players.forEach(player -> player.sendMessage(message));
    }

    public void broadcastActionBar(List<Player> players, String message) {
        players.forEach(player -> ActionBar.sendActionBar(player, message));
    }

    public void broadcastSound(List<Player> players, Sound sound) {
        players.forEach(player -> player.playSound(player.getLocation(), sound, 0f, 0f));
    }

    public JavaPlugin getPlugin() {
        return plugin;
    }

    public TeamManager getTeamManager() {
        return API.get().getTeamManager();
    }

    public ChestSystem getChestSystem() {
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

}
