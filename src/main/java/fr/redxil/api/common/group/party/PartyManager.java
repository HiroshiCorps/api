/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.group.party;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public interface PartyManager {

    Optional<Party> createParty(UUID author);

    Optional<Party> getPlayerParty(UUID apiPlayer);

    Optional<Party> getParty(long partyID);

    boolean hasParty(UUID apiPlayer);

    boolean isPartyExist(long partyID);

    Map<String, Long> getUUIDToPartyIDMap();

}
