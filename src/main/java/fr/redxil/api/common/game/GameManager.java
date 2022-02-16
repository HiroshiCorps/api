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

    boolean isGameExistByServerID(long server);

    boolean isGameExist(long gameID);

    Game getGameByServerID(long server);

    Game getGame(long gameID);

    /**
     * @param gameEnum
     * @return
     * @throws GameCreateError
     */
    Game initGameServer(GameEnum gameEnum) throws GameCreateError;

    List<Host> getListHost();

    boolean isHostExistByServerID(long server);

    boolean isHostExist(long gameID);

    Host getHostByServerID(long server);

    Host getHost(long gameID);

    Host initHostServer(APIPlayer author, GameEnum hostsGame);

}
