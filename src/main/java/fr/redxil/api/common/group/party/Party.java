/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.group.party;

import fr.redxil.api.common.player.APIPlayer;

import java.util.List;
import java.util.Map;

public interface Party {

    boolean joinParty(APIPlayer apiPlayer);

    boolean quitParty(APIPlayer apiPlayer);

    boolean kickParty(APIPlayer kicker, APIPlayer apiPlayer);

    boolean setPartyRank(APIPlayer ranker, APIPlayer target, PartyRank partyRank);

    PartyRank getPartyRank(APIPlayer apiPlayer);

    PartyAccess getPartyAccess();

    void setPartyAccess(PartyAccess partyAccess);

    boolean isPartyOwner(APIPlayer apiPlayer);

    boolean hisInParty(APIPlayer apiPlayer);

    List<APIPlayer> getAPIPlayerList();

    List<Long> getPlayerList();

    boolean deleteParty(APIPlayer author);

    long getPartyID();

    boolean invitePlayer(APIPlayer apiPlayer);

    boolean revokeInvite(APIPlayer apiPlayer);

    boolean hisInvitePlayer(APIPlayer apiPlayer);

    APIPlayer getPartyOwner();

    Map<String, PartyRank> getRank();

}
