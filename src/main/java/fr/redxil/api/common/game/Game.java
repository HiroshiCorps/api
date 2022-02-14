/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.game;

import fr.redxil.api.common.game.utils.GameEnum;
import fr.redxil.api.common.game.utils.GameState;
import fr.redxil.api.common.group.team.Team;
import fr.redxil.api.common.player.APIPlayer;
import fr.redxil.api.common.player.moderators.APIPlayerModerator;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface Game {

    /**
     * Aim to get the game id
     * @return the game id
     */
    long getGameID();

    /**
     * Aim to get the server name
     * @return the server name
     */
    String getServerName();

    /**
     * Get the minimum player needed
     * @return Minimum player needed to start
     */
    int getMinPlayer();

    /**
     * Change the minimum player needed
     * @param n the number of player
     */
    void setMinPlayer(int n);

    /**
     * Get the maximum player needed
     * @return Maximum player needed to start
     */
    int getMaxPlayer();

    /**
     * Change the minimum player needed
     * @param n the number of player
     */
    void setMaxPlayer(int n);

    /**
     * Get maximum normal player authorize to spectate a game without participating to it
     * @return the max number of player
     */
    int getMaxPlayerSpec();

    /**
     * Set maximum normal player authorize to spectate a game without participating to it
     * @param n the number of player
     */
    void setMaxPlayerSpec(int n);

    /// <!-------------------- Game part --------------------!>

    /**
     * Check if game is running or not
     * @return the actual game state
     */
    GameState getGameState();

    /**
     * Change the GameState
     * @param gameState the new GameState
     */
    void setGameState(GameState gameState);

    /**
     * Check if current gameState is on specific list
     * @param gameState The list of gameState to check
     * @return true if current gameState is in list
     */
    boolean isGameState(GameState... gameState);

    /**
     * The loaded game
     * @return The game enum that contains game default settings
     */
    GameEnum getGame();

    /**
     *
     * @return the sub game name
     */
    String getSubGames();

    void setSubGames(String subGames);

    /**
     * Check if uuid is in player list
     * @param playerUUID the player uuid
     */
    boolean isPlayer(UUID playerUUID);

    /**
     * Check if uuid is in spectator list
     * @param playerUUID the player uuid
     */
    boolean isSpectator(UUID playerUUID);

    /**
     * The current server map name
     * @return Map name
     */
    String getMap();

    /**
     * Change the server map name
     * @param map The new map name
     */
    void setMap(String map);

    /**
     * Force game to start
     * @param apiPlayerModerator player who forced
     */
    void forceStart(APIPlayerModerator apiPlayerModerator);

    /**
     * Force game to stop the start procedure
     * @param apiPlayerModerator player who forced
     */
    void forceStopStart(APIPlayerModerator apiPlayerModerator);

    /**
     * Force game to end
     * @param apiPlayerModerator player who forced
     * @param reason Reason why game was stopped
     */
    boolean forceEnd(APIPlayerModerator apiPlayerModerator, String reason);

    /**
     * Force game to end with winner
     * @param apiPlayerModerator player who forced
     * @param team The winner team
     * @param reason Reason why game was stopped
     */
    boolean forceWin(APIPlayerModerator apiPlayerModerator, Team team, String reason);

    /// <!-------------------- Player Part --------------------!>

    /**
     * Get list of ingame player
     * @return ingame player list
     */
    List<UUID> getPlayers();

    /**
     * Get list of ingame player spectator
     * @return ingame player spectator list
     */
    List<UUID> getPlayerSpectators();

    /**
     * Get list of moderator player spectator
     * @return moderator player spectator list
     */
    List<UUID> getModeratorSpectators();

    /**
     * Get player registered for the game but not connected to the server
     * @return list of not connected player
     */
    List<UUID> getInConnectPlayer();

    /**
     * Change player between player and spectator
     * @param player Player to switch
     * @param bool Spectator or not
     * @return true if player had been changed
     */
    boolean setSpectator(UUID player, boolean bool);

    /**
     * Check if not registered player can access
     * @param apiPlayer player who want to register for the game
     * @param spectator register has spectator or not
     * @return true if player can access server
     */
    boolean canAccess(APIPlayer apiPlayer, boolean spectator);

    /**
     * Player want to register to game
     * @param apiPlayer player who want to register for the game
     * @param spectator register has spectator or not
     * @return true if player can access server
     */
    boolean joinGame(APIPlayer apiPlayer, boolean spectator);

    /**
     * Check if server is waiting for the player to connect
     * @param player player to check
     * @return true if player is waited
     */
    boolean isInConnectPlayer(UUID player);

    /**
     * Check if player is allow to connect to server
     * @param playerUUID player to check
     * @return true is authorize
     */
    boolean isAllowConnectServer(UUID playerUUID);


    /// <!-------------------- Settings part --------------------!>

    void setSettings(String key, Object objet);

    void removeSettings(String key);

    Map<String, Object> getSettingsMap();

    Object getSettings(String key);

    boolean hasSettings(String key);


    void clearData();

    Host getHost();

    boolean isHostLinked();

}
