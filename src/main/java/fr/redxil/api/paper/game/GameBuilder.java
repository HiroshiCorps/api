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
import fr.redxil.api.common.game.error.GameCreateError;
import fr.redxil.api.common.game.error.GameInitError;
import fr.redxil.api.common.game.utils.GameState;
import fr.redxil.api.common.group.team.Team;
import fr.redxil.api.common.player.APIPlayer;
import fr.redxil.api.common.server.Server;
import fr.redxil.api.paper.game.chest.ChestSystem;
import fr.xilitra.hiroshisav.enums.TypeGame;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public abstract class GameBuilder {

    private static GameBuilder gameBuilder;
    private final JavaPlugin plugin;
    private final ChestSystem chestsManager;

    public GameBuilder(JavaPlugin plugin, TypeGame gameEnum) throws GameInitError, GameCreateError {
        gameBuilder = this;

        initGame(gameEnum);

        this.plugin = plugin;
        this.chestsManager = new ChestSystem();
    }

    public static Optional<GameBuilder> getGameBuilder() {
        return Optional.ofNullable(gameBuilder);
    }

    public void initGame(TypeGame gameEnum) throws GameInitError, GameCreateError {

        Optional<Game> gameOptional = API.getInstance().getGameManager().getGameByServerID(API.getInstance().getServerID());
        if (gameOptional.isEmpty()) {
            if (API.getInstance().isOnlineMod())
                throw new GameInitError("Game not init, consider creating game with GameManager.createGame / GameManager.createHost");
            else if (defaultOfflineHost()) {
                Optional<Host> optionalHost = API.getInstance().getGameManager().createHost(API.getInstance().getServerID(), 1L, gameEnum);
                if (optionalHost.isPresent()) {
                    gameOptional = Optional.of(optionalHost.get());
                }
            } else
                gameOptional = API.getInstance().getGameManager().createGame(API.getInstance().getServerID(), gameEnum);
        }

        if (gameOptional.isEmpty())
            return;

        Game game = gameOptional.get();

        if (game.getGame() != gameEnum) {
            game.setGameState(GameState.CRASHED);
            throw new GameInitError("Wrong game Started");
        }

        if (game instanceof Host) {
            Server server = API.getInstance().getServer();
            Optional<APIPlayer> apiPlayer = API.getInstance().getPlayerManager().getPlayer(((Host) game).getAuthor());
            if (apiPlayer.isPresent())
                apiPlayer.get().switchServer(server.getServerID());
            else {
                if (API.getInstance().isOnlineMod()) {
                    game.setGameState(GameState.CRASHED);
                    throw new GameInitError("Missing host");
                }
            }
        }

    }

    public boolean hasTeams() {
        Optional<Game> gameOptional = API.getInstance().getGameManager().getGameByServerID(API.getInstance().getServerID());
        return gameOptional.filter(game -> !API.getInstance().getTeamManager(game.getGameID()).getTeamList().isEmpty()).isPresent();
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

    /**
     * Used for Offline test purpose
     *
     * @return True if for host
     */
    public abstract boolean defaultOfflineHost();

    public void broadcastTitle(String title, String subtitle) {
        Bukkit.getOnlinePlayers().forEach(player -> player.spigot().sendMessage(ChatMessageType.SYSTEM, TextComponent.fromLegacyText(title + "\n" + subtitle)));
    }

    public void broadcastMessage(String message) {
        plugin.getServer().getOnlinePlayers().forEach(player -> player.sendMessage(message));
    }

    public void broadcastActionBar(String message) {
        TextComponent textComponent = new TextComponent(message);
        plugin.getServer().getOnlinePlayers().forEach(player -> player.spigot().sendMessage(ChatMessageType.ACTION_BAR, textComponent));
    }

    public void broadcastSound(Sound sound) {
        plugin.getServer().getOnlinePlayers().forEach(player -> player.playSound(player.getLocation(), sound, 0f, 0f));
    }

    public void broadcastTitle(Collection<Player> players, String title, String subtitle) {
        players.forEach(player -> player.spigot().sendMessage(ChatMessageType.SYSTEM, TextComponent.fromLegacyText(title + "\n" + subtitle)));
    }

    public void broadcastMessage(Collection<Player> players, String message) {
        players.forEach(player -> player.sendMessage(message));
    }

    public void broadcastActionBar(List<Player> players, String message) {
        TextComponent textComponent = new TextComponent(message);
        players.forEach(player -> player.spigot().sendMessage(ChatMessageType.ACTION_BAR, textComponent));
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
