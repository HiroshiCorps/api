/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.server.type;

import fr.redxil.api.common.API;
import fr.redxil.api.common.game.Games;
import fr.redxil.api.common.player.APIPlayer;
import fr.redxil.api.common.rank.RankList;
import fr.redxil.api.common.server.Server;

public enum ServerAccess {

    OPEN,
    GAME,
    MAINTENANCE,
    RANK_SPECIFIC,
    RANK_SPECIFIC_MIN,
    ADMIN;

    public boolean canAccess(Server server, APIPlayer apiOfflinePlayer) {
        return canAccess(server, this, apiOfflinePlayer.getName(), apiOfflinePlayer.getRank());
    }

    public boolean canAccess(Server server, String name, RankList rankList) {
        return canAccess(server, this, name, rankList);
    }

    private boolean canAccess(Server server, ServerAccess serverAccess, String name, RankList rankList) {

        switch (serverAccess) {

            case OPEN: {

                return true;

            }

            case GAME: {

                Games game = API.getInstance().getGame();
                if (game == null)
                    return false;

                return game.isAllowConnectServer(name);

            }

            case MAINTENANCE: {

                return rankList.isModeratorRank();

            }

            case RANK_SPECIFIC: {

                return rankList == server.getReservedRank();

            }

            case RANK_SPECIFIC_MIN: {

                return rankList.getRankPower() >= server.getReservedRank().getRankPower();

            }

            case ADMIN: {

                return rankList == RankList.ADMINISTRATEUR;

            }

        }

        return false;

    }

}
