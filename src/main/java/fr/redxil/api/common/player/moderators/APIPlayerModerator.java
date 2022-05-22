/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.player.moderators;

import fr.redxil.api.common.player.APIOfflinePlayer;
import fr.redxil.api.common.utils.SanctionType;

import java.util.UUID;

public interface APIPlayerModerator {

    /**
     * @return This function return the MemberId of the moderator
     */
    long getMemberID();

    void disconnectModerator();

    UUID getUUID();

    String getName();

    boolean isModeratorMod();

    boolean hasCible();

    String getCible();

    void setCible(String value);


    boolean isVanish();

    void printSanction(APIOfflinePlayer aop, SanctionType sanctionType);

    void printInfo(APIOfflinePlayer aop);

}
