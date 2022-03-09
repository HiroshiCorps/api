/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.paper.game;

import fr.redxil.api.common.API;
import fr.redxil.api.common.game.Game;
import fr.redxil.api.common.game.Host;
import fr.redxil.api.common.game.error.GameInitError;
import fr.redxil.api.common.game.utils.GameEnum;
import fr.redxil.api.common.game.utils.GameState;
import fr.redxil.api.common.group.team.Team;
import fr.redxil.api.common.player.APIPlayer;
import fr.redxil.api.common.server.Server;
import fr.redxil.api.paper.game.chest.ChestSystem;
import fr.redxil.api.paper.game.pmmanager.PMListen;
import fr.redxil.api.paper.utils.ActionBar;
import fr.redxil.api.paper.utils.Title;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public abstract class GameBuilder {

    private static GameBuilder gameBuilder;
    private final JavaPlugin plugin;
    private final ChestSystem chestsManager;

    public GameBuilder(JavaPlugin plugin, GameEnum gameEnum) throws GameInitError {
        gameBuilder = this;

        initGame(gameEnum);
        new PMListen();

        this.plugin = plugin;
        this.chestsManager = new ChestSystem();
    }

    public static GameBuilder getGameBuilder() {
        return gameBuilder;
    }

    public void initGame(GameEnum gameEnum) throws GameInitError {

        Game game = API.getInstance().getGame();
        if (game == null)
            throw new GameInitError("Game not init on Redis");

        if (game.getGame() != gameEnum) {
            game.setGameState(GameState.CRASHED);
            throw new GameInitError("Wrong game Started");
        }

        if (game instanceof Host) {
            Server server = API.getInstance().getServer();
            APIPlayer apiPlayer = API.getInstance().getPlayerManager().getPlayer(((Host) game).getAuthor());
            if (apiPlayer != null)
                apiPlayer.switchServer(server.getServerID());
            else {
                game.setGameState(GameState.CRASHED);
                throw new GameInitError("Missing host");
            }
        }
    }

    public boolean hasTeams() {
        return !API.getInstance().getTeamManager().getTeamList(API.getInstance().getGame()).isEmpty();
    }

    public abstract void onPlayerJoin(Player player);

    public abstract void onPlayerLeave(Player player);

    public abstract void onSpectatorJoin(Player player);

    public abstract void onSpectatorLeave(Player player);

    public abstract boolean start();

    public abstract boolean forceStart();

    public abstract boolean stopStart();

    public abstract void onWin(Team team);

    public abstract void onWin(Player player);

    public abstract void forceEnd(String reason);

    public abstract void forceWin(Team team, String reason);

    public abstract void forceWin(Player player, String reason);

    public void broadcastTitle(String title, String subtitle) {
        Title.sendTitleToAllPlayers(title, subtitle, 10, 20, 10);
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

    public ChestSystem getChestSystem() {
        return chestsManager;
    }

}
