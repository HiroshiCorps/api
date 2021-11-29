/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.group.party;

import fr.redxil.api.common.player.APIPlayer;

public interface PartyManager {

    Party createParty(APIPlayer author);

    Party getPlayerParty(APIPlayer apiPlayer);

    Party getParty(long partyID);

    boolean hasParty(APIPlayer apiPlayer);

    boolean isPartyExist(long partyID);

}