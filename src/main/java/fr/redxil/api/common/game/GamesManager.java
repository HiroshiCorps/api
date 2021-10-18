/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  * Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *  * Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.game;

import fr.redxil.api.common.player.APIPlayer;

import java.util.List;

public interface GamesManager {

    List<Games> getListGames();

    boolean isGameExist(String server);

    boolean isGameExist(long gameID);

    Games getGame(String server);

    Games getGame(long gameID);

    Games initGameServer(String server, GameEnum gameEnum);

    List<Hosts> getListHosts();

    boolean isHostExist(String server);

    boolean isHostExist(long gameID);

    Hosts getHost(String server);

    Games getHost(long gameID);

    Hosts initHostServer(String server, APIPlayer author, GameEnum hostsGame);

}
