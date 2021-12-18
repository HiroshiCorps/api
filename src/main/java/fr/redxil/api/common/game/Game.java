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

    String getServerName();

    int getMinPlayer();

    void setMinPlayer(int n);

    int getMaxPlayer();

    void setMaxPlayer(int n);

    int getMaxPlayerSpec();

    void setMaxPlayerSpec(int n);

    long getGameID();

    /// <!-------------------- Game part --------------------!>

    GameState getGameState();

    void setGameState(GameState gameState);

    boolean isGameState(GameState... gameState);

    GameEnum getGame();

    String getSubGames();

    void setSubGames(String subGames);


    boolean isPlayer(UUID playerName);

    boolean isSpectator(UUID playerName);


    String getMap();

    void setMap(String map);


    void forceStart(APIPlayerModerator APIPlayer);

    void forceStopStart(APIPlayerModerator APIPlayer);

    boolean forceEnd(APIPlayerModerator APIPlayer, String reason);

    boolean forceWin(APIPlayerModerator APIPlayer, Team team, String reason);

    void stop();

    /// <!-------------------- Player Part --------------------!>

    List<UUID> getPlayers();

    List<UUID> getPlayerSpectators();

    List<UUID> getModeratorSpectators();

    List<UUID> getInConnectPlayer();

    boolean setSpectator(UUID player, boolean bool);

    boolean canAccess(APIPlayer apiPlayer, boolean spectator);

    boolean joinGame(APIPlayer apiPlayer, boolean spectator);

    boolean isInConnectPlayer(UUID player);

    boolean isAllowConnectServer(UUID playerName);


    /// <!-------------------- Settings part --------------------!>

    void setSettings(String key, Object objet);

    void removeSettings(String key);

    Map<String, Object> getSettingsMap();

    Object getSettings(String key);

    boolean hasSettings(String key);


    Host getHost();

    boolean hasTeam();

    void setHasTeam(boolean b);

    boolean isHostLinked();

}
