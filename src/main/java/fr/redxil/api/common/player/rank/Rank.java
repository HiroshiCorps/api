/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.player.rank;

import java.util.Optional;

public enum Rank {

    SERVER(8, 999L, true,
            "",
            "",
            "",
            ""
    ),

    ADMINISTRATEUR(7, 777L, true,
            "§c[Administrateur] ",
            "§8§l » §f",
            "§c[Admin] ",
            "§c§lAdmin "
    ),

    STAFF(5, 40L, true,
            "§c[Staff] ",
            "§8§l » §f",
            "§c[Staff] ",
            "§c§lStaff "
    ),

    SILENT_MOD(4, 30L, true,
            "§7",
            "§8§l » §7",
            "§7",
            "§dMembre "
    ),

    MODERATEUR(3, 30L, true,
            "§9[Modérateur] ",
            "§8§l » §f",
            "§9[Modérateur] ",
            "§9§lMod "
    ),

    JOUEUR(0, 0L, false,
            "§7",
            "§8§l » §7",
            "§7",
            "§dMembre "
    );

    private final Long power;
    private final Integer id;

    /*
     *
     * Non static part
     *
     */
    private final String chatRankString, tabString, chatSeparator, scoreboardString;
    private final Boolean mod;

    Rank(final Integer id, final Long power, Boolean mod, final String chatRankString, final String chatSeparator, final String tabString, final String scoreboardString) {
        this.power = power;
        this.chatRankString = chatRankString;
        this.tabString = tabString;
        this.id = id;
        this.chatSeparator = chatSeparator;
        this.mod = mod;
        this.scoreboardString = scoreboardString;
    }

    public static Optional<Rank> getRank(long power) {
        for (Rank rank : Rank.values())
            if (rank.getRankPower() == power)
                return Optional.of(rank);
        return Optional.empty();
    }

    public static Optional<Rank> getRank(String name) {
        for (Rank rank : Rank.values())
            if (rank.getRankName().equals(name))
                return Optional.of(rank);
        return Optional.empty();
    }

    public String getScoreboardString() {
        return scoreboardString;
    }

    public final Long getRankPower() {
        return this.power;
    }

    public final String getChatRankString() {
        return this.chatRankString;
    }

    public final String getRankName() {
        return this.name();
    }

    public final Integer getID() {
        return this.id;
    }

    public final String getChatSeparator() {
        return this.chatSeparator;
    }

    public final String getTabString() {
        return tabString;
    }

    public final Boolean isModeratorRank() {
        return mod;
    }

}