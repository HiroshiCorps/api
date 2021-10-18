/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  * Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *  * Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.player.nick;

import fr.redxil.api.common.player.APIOfflinePlayer;
import fr.redxil.api.common.player.APIPlayer;

public interface NickGestion {

    boolean setNick(APIOfflinePlayer apiPlayer, NickData nickData);

    boolean removeNick(APIOfflinePlayer APIPlayerOffline);

    boolean isNickName(String nick);

    /// Part: nick -> APIPlayer

    APIPlayer getAPIPlayer(String nick);

    APIOfflinePlayer getAPIOfflinePlayer(String nick);

    Long getRealID(String nick);

    /// Part: APIPlayer -> nick

    NickData getNickData(APIOfflinePlayer osp);

    boolean hasNick(APIOfflinePlayer APIPlayerOffline);

    boolean isIllegalName(String name);

}
