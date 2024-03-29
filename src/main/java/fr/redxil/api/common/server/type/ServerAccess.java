/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.server.type;

import fr.redxil.api.common.player.APIPlayer;
import fr.redxil.api.common.player.rank.Rank;
import fr.redxil.api.common.server.Server;
import fr.xilitra.hiroshisav.enums.ServerType;

import java.util.UUID;

public enum ServerAccess {

    OPEN,
    LIMITED,
    MAINTENANCE,
    RANK_SPECIFIC,
    RANK_SPECIFIC_MIN,
    ADMIN;

    public static ServerAccess getAccessRelated(ServerType serverType) {
        return switch (serverType) {
            case HUB, VELOCITY -> ServerAccess.OPEN;
            case HOST, GAME -> ServerAccess.LIMITED;
        };
    }

    public boolean canAccess(Server server, APIPlayer apiOfflinePlayer) {
        return canAccess(server, apiOfflinePlayer.getUUID(), apiOfflinePlayer.getRank());
    }

    public boolean canAccess(Server server, UUID name, Rank rank) {

        switch (this) {
            case LIMITED -> {
                return rank.isModeratorRank() || server.getAllowedConnect(name);
            }
            case OPEN -> {
                return true;
            }
            case MAINTENANCE -> {
                return rank.isModeratorRank();
            }
            case RANK_SPECIFIC -> {
                return rank.isModeratorRank() || rank == server.getReservedRank().orElse(Rank.JOUEUR);
            }
            case RANK_SPECIFIC_MIN -> {
                return rank.getRankPower() >= server.getReservedRank().orElse(Rank.JOUEUR).getRankPower();
            }
            case ADMIN -> {
                return rank == Rank.ADMINISTRATEUR;
            }
        }

        return false;

    }

}
