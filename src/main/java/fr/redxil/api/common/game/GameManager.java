/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.game;

import fr.redxil.api.common.game.error.GameCreateError;
import fr.xilitra.hiroshisav.enums.TypeGame;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface GameManager {

    List<Game> getListGames();

    boolean isGameExistByServerID(long server);

    boolean isGameExist(long gameID);

    Optional<Game> getGameByServerID(long server);

    Optional<Game> getGame(long gameID);

    Optional<Game> createGame(long serverID, TypeGame gameEnum) throws GameCreateError;

    List<Host> getListHost();

    boolean isHostExistByServerID(long server);

    boolean isHostExist(long gameID);

    Optional<Host> getHostByServerID(long server);

    Optional<Host> getHost(long gameID);

    Optional<Host> createHost(long serverID, Long author, TypeGame hostsGame);

    Map<Long, Long> getServerToGameIDMap();

    Map<Long, Long> getServerToHostIDMap();

}
