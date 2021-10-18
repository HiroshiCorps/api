/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  * Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *  * Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.moderators;

import fr.redxil.api.common.player.APIPlayer;

import java.util.UUID;

public interface APIPlayerModerator {

    /// <!-------------------- APIPlayer part --------------------!>

    APIPlayer getAPIPlayer();

    /**
     * @return This function return the MemberId of the moderator
     */
    long getMemberId();

    /**
     * @return This function return the current UUID of the moderator
     */
    UUID getUUID();

    String getName();

    void disconnectModerator();


    boolean isModeratorMod();

    boolean isConnected();

    boolean hasCible();

    String getCible();

    void setCible(String value);


    boolean isVanish();

}
