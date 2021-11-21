/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.paper.minigame;

import fr.redxil.api.common.API;
import fr.redxil.api.common.game.Game;
import fr.redxil.api.common.game.Host;
import fr.redxil.api.common.game.error.GameInitError;
import fr.redxil.api.common.game.team.Team;
import fr.redxil.api.common.game.team.TeamManager;
import fr.redxil.api.common.player.APIPlayer;
import fr.redxil.api.common.server.Server;
import fr.redxil.api.common.time.TimerSystem;
import fr.redxil.api.paper.minigame.chest.ChestSystem;
import fr.redxil.api.paper.minigame.managers.FilesAPI;
import fr.redxil.api.paper.minigame.pmmanager.PMListen;
import fr.redxil.api.paper.utils.ActionBar;
import fr.redxil.api.paper.utils.Title;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;
import java.util.List;

public abstract class GameBuilder {

    private static GameBuilder gameBuilder;
    private final JavaPlugin plugin;
    private final ChestSystem chestsManager;
    private final TimerSystem timerSystem;
    private String prefix = "Server";

    public GameBuilder(JavaPlugin plugin) throws GameInitError {
        gameBuilder = this;

        initGame();
        new PMListen();

        this.plugin = plugin;
        this.chestsManager = new ChestSystem();
        this.timerSystem = new TimerSystem();

        String config = FilesAPI.CONFIG.getFileName();
        saveResourceAs(config, config);
    }

    public static GameBuilder getGameBuilder() {
        return gameBuilder;
    }

    public void initGame() throws GameInitError {

        Game game = API.getInstance().getGame();
        if (game == null)
            throw new GameInitError("Game not init on Redis");

        Server server = API.getInstance().getServer();
        if (!(game instanceof Host))
            return;

        APIPlayer apiPlayer = API.getInstance().getPlayerManager().getPlayer(((Host) game).getAuthor());
        if (apiPlayer != null)
            apiPlayer.switchServer(server.getServerName());
        else
            throw new GameInitError("Missing host");
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
        return API.getInstance().getTeamManager();
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

    public TimerSystem getTimerGest() {
        return timerSystem;
    }

}
