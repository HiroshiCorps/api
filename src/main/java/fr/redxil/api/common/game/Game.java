/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.game;

import fr.redxil.api.common.game.utils.GameState;
import fr.redxil.api.common.game.utils.PlayerState;
import fr.redxil.api.common.group.team.Team;
import fr.xilitra.hiroshisav.enums.TypeGame;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface Game {

    /**
     * Aim to get the game id
     *
     * @return the game id
     */
    long getGameID();

    /**
     * Aim to get the server id
     *
     * @return the server id
     */
    long getServerID();

    /**
     * Get the minimum player needed
     *
     * @return Minimum player needed to start
     */
    int getMinPlayer();

    /**
     * Change the minimum player needed
     *
     * @param n the number of player
     */
    void setMinPlayer(int n);

    /**
     * Get the maximum player needed
     *
     * @return Maximum player needed to start
     */
    int getMaxPlayer();

    /**
     * Change the minimum player needed
     *
     * @param n the number of player
     */
    void setMaxPlayer(int n);

    /**
     * Get maximum normal player authorize to spectate a game without participating to it
     *
     * @return the max number of player
     */
    int getMaxPlayerSpec();

    /**
     * Set maximum normal player authorize to spectate a game without participating to it
     *
     * @param n the number of player
     */
    void setMaxPlayerSpec(int n);

    /// <!-------------------- Game part --------------------!>

    /**
     * Check if game is running or not
     *
     * @return the actual game state
     */
    GameState getGameState();

    /**
     * Change the GameState
     *
     * @param gameState the new GameState
     */
    void setGameState(GameState gameState);

    /**
     * Check if current gameState is on specific list
     *
     * @param gameState The list of gameState to check
     * @return true if current gameState is in list
     */
    boolean isGameState(GameState... gameState);

    /**
     * The loaded game
     *
     * @return The game enum that contains game default settings
     */
    TypeGame getGame();

    /**
     * Check if uuid is in player list
     *
     * @param playerUUID the player uuid
     */
    boolean isRegistered(UUID playerUUID);

    /**
     * Check if uuid is in player list
     *
     * @param playerUUID the player uuid
     */
    boolean isPlayer(UUID playerUUID);

    /**
     * Check if uuid is in spectator list
     *
     * @param playerUUID the player uuid
     */
    boolean isSpectator(UUID playerUUID);

    /**
     * The current server map name
     *
     * @return Map name
     */
    String getWorldName();

    /**
     * Change the server map name
     *
     * @param map The new map name
     */
    void setWorldName(String map);

    /**
     * Force game to start
     *
     * @param playerModerator player who forced
     */
    void forceStart(UUID playerModerator);

    /**
     * Force game to end
     *
     * @param playerModerator player who forced
     * @param reason          Reason why game was stopped
     */
    boolean forceEnd(UUID playerModerator, String reason);

    /**
     * Force game to end with winner
     *
     * @param playerModerator player who forced
     * @param team            The winner team
     * @param reason          Reason why game was stopped
     */
    boolean forceWin(UUID playerModerator, Team team, String reason);

    /// <!-------------------- Player Part --------------------!>

    /**
     * Get all player
     *
     * @return list of player
     */
    List<UUID> getPlayerList(PlayerState... playerState);

    void setPlayerState(UUID player, @Nullable PlayerState playerState);

    PlayerState getPlayerState(UUID player);

    /**
     * Check if not registered player can access
     *
     * @param uuid      player who want to register for the game
     * @param spectator register has spectator or not
     * @return true if player can access server
     */
    boolean canAccess(UUID uuid, boolean spectator);

    /**
     * Player want to register to game
     *
     * @param uuid      player who want to register for the game
     * @param spectator register has spectator or not
     * @return true if player can access server
     */
    boolean joinGame(UUID uuid, boolean spectator);

    boolean quitGame(UUID uuid);


    /// <!-------------------- Settings part --------------------!>

    void setSettings(String key, Object objet);

    void removeSettings(String key);

    Map<String, Object> getSettingsMap();

    Object getSettings(String key);

    boolean hasSettings(String key);

    void clearData();

}
