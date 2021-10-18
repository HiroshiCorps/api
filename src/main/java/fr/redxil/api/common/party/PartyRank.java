/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  * Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *  * Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.party;

import net.md_5.bungee.api.ChatColor;

public enum PartyRank {
    OWNER("Owner", ChatColor.GOLD, 100),
    ADMIN("Admin", ChatColor.RED, 50),
    PLAYER("Joueur", ChatColor.BLUE, 0);

    final String rankName;
    final int rankPower;
    final ChatColor chatColor;
    PartyRank(String name, ChatColor chatColor, int rankPower) {
        this.rankPower = rankPower;
        this.chatColor = chatColor;
        this.rankName = name;
    }

    public static PartyRank getPartyRank(String rankName) {
        for (PartyRank pr : values())
            if (pr.getRankName().equals(rankName))
                return pr;
        return null;
    }

    public String getRankName() {
        return this.rankName;
    }

    public int getRankPower() {
        return this.rankPower;
    }

    public ChatColor getChatColor() {
        return this.chatColor;
    }

    public boolean isOver(PartyRank partyRank) {
        return this.getRankPower() > partyRank.getRankPower();
    }

    public boolean isOverOrEquals(PartyRank partyRank) {
        return this.getRankPower() >= partyRank.getRankPower();
    }

    public boolean equals(PartyRank pr) {
        return pr.getRankName().equals(getRankName());
    }

}
