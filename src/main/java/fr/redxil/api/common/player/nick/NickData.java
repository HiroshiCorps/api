/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.player.nick;

import fr.redxil.api.common.rank.RankList;

public class NickData {

    final String name;
    final RankList rank;

    public NickData(String name, RankList rank) {
        this.name = name;
        this.rank = rank;
    }

    public String getName() {
        return this.name;
    }

    public RankList getRank() {
        return this.rank;
    }
}
