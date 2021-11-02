/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.game;

import fr.redxil.api.common.game.team.Team;
import fr.redxil.api.common.moderators.APIPlayerModerator;
import fr.redxil.api.common.player.APIPlayer;

import java.util.List;
import java.util.Map;

public interface Games {

    String getServerName();

    int getMinPlayer();

    void setMinPlayer(int n);

    int getMaxPlayer();

    void setMaxPlayer(int n);

    int getMaxPlayerSpec();

    void setMaxPlayerSpec(int n);

    long getGameID();

    List<String> getPlayers();

    List<String> getSpectators();

    List<String> getInGameSpectators();

    List<String> getOutGameSpectators();

    List<String> getInConnectPlayer();

    boolean setSpectator(String playerName, boolean bool);

    void setSettings(String key, Object objet);

    void removeSettings(String key);

    Map<String, Object> getSettingsMap();

    Hosts getHost();

    GameState getGameState();

    void setGameState(GameState gameState);

    boolean isGameState(GameState... gameState);

    GameEnum getGame();

    boolean hasTeam();

    void setHasTeam(boolean b);

    void stop();

    boolean canAccess(APIPlayer apiPlayer, boolean spectator);

    boolean joinGame(APIPlayer apiPlayer, boolean spectator);

    void forceStart(APIPlayerModerator APIPlayer);

    void forceStopStart(APIPlayerModerator APIPlayer);

    boolean forceEnd(APIPlayerModerator APIPlayer, String reason);

    boolean forceWin(APIPlayerModerator APIPlayer, Team team, String reason);

    boolean isInConnectPlayer(String playerName);

    Object getSettings(String key);

    boolean hasSettings(String key);

    boolean isPlayer(String playerName);

    boolean isSpectator(String playerName);

    boolean isHostLinked();

}
