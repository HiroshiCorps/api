/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.party;

public enum PartyAccess {
    CLOSE("close"),
    FRIEND("friend"),
    OPEN("open");

    final String rankName;

    PartyAccess(String name) {
        this.rankName = name;
    }

    public static PartyAccess getPartyAccess(String rankName) {
        for (PartyAccess pr : values())
            if (pr.getAccessName().equals(rankName))
                return pr;
        return null;
    }

    public String getAccessName() {
        return this.rankName;
    }

    public boolean equals(PartyAccess partyAccess) {
        return this.getAccessName().equals(partyAccess.getAccessName());
    }

}
