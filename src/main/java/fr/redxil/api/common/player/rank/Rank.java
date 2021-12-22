/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.player.rank;

public enum Rank {

    ADMINISTRATEUR(7, 777L, true,
            "§c[Administrateur] ",
            "§8§l » §f",
            "§c[Admin] ",
            "§c§lAdmin "
    ),

    RESPONSABLE(6, 50L, true,
            "§c[Responsable] ",
            "§8§l » §f",
            "§c[Resp] ",
            "§c§lResp "
    ),

    DEVELOPPEUR(5, 40L, true,
            "§c[Développeur] ",
            "§8§l » §f",
            "§c[Dév] ",
            "§c§lDév "
    ),

    SILENT_MOD(4, 30L, true,
            "§7",
            "§8§l » §f",
            "§7",
            "§9Mod "
    ),

    MODERATEUR(3, 30L, true,
            "§9[Modérateur] ",
            "§8§l » §f",
            "§9[Modérateur] ",
            "§9§lMod "
    ),

    BUILDER(2, 20L, false,
            "§2[Builder] ",
            "§8§l » §f",
            "§2[Builder] ",
            "§2§lBuilder "
    ),

    ASSISTANT(1, 10L, false,
            "§b[Assistant] ",
            "§8§l » §7",
            "§b[Assistant] ",
            "§b§lAssistant "
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

    public static Rank getRank(long power) {
        for (Rank rank : Rank.values())
            if (rank.getRankPower() == power)
                return rank;
        return null;
    }

    public static Rank getRank(String name) {
        for (Rank rank : Rank.values())
            if (rank.getRankName().equals(name))
                return rank;
        return null;
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
        return this.toString();
    }

    public final Integer getId() {
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