/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.game;

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

    List<UUID> getPlayers();

    List<UUID> getPlayerSpectators();

    List<UUID> getModeratorSpectators();

    List<UUID> getInConnectPlayer();

    boolean setSpectator(UUID player, boolean bool);

    void setSettings(String key, Object objet);

    void removeSettings(String key);

    Map<String, Object> getSettingsMap();

    Host getHost();

    GameState getGameState();

    void setGameState(GameState gameState);

    boolean isGameState(GameState... gameState);

    GameEnum getGame();

    String getSubGames();

    void setSubGames(String subGames);

    String getMap();

    void setMap(String map);

    boolean hasTeam();

    void setHasTeam(boolean b);

    void stop();

    boolean canAccess(APIPlayer apiPlayer, boolean spectator);

    boolean joinGame(APIPlayer apiPlayer, boolean spectator);

    void forceStart(APIPlayerModerator APIPlayer);

    void forceStopStart(APIPlayerModerator APIPlayer);

    boolean forceEnd(APIPlayerModerator APIPlayer, String reason);

    boolean forceWin(APIPlayerModerator APIPlayer, Team team, String reason);

    boolean isInConnectPlayer(UUID player);

    Object getSettings(String key);

    boolean hasSettings(String key);

    boolean isPlayer(UUID playerName);

    boolean isSpectator(UUID playerName);

    boolean isHostLinked();

    boolean isAllowConnectServer(UUID playerName);

}
