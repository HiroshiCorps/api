/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.game;

import fr.redxil.api.common.game.error.GameCreateError;
import fr.redxil.api.common.game.utils.GameEnum;
import fr.redxil.api.common.player.APIPlayer;

import java.util.List;

public interface GameManager {

    List<Game> getListGames();

    boolean isGameExist(String server);

    boolean isGameExist(long gameID);

    Game getGame(String server);

    Game getGame(long gameID);

    Game initGameServer(String server, GameEnum gameEnum) throws GameCreateError;

    List<Host> getListHost();

    boolean isHostExist(String server);

    boolean isHostExist(long gameID);

    Host getHost(String server);

    Game getHost(long gameID);

    Host initHostServer(String server, APIPlayer author, GameEnum hostsGame) throws GameCreateError;

}
