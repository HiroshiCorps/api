/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  * Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *  * Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.spigot.minigame.chests;

public enum ChestsType {

    LOW(1),
    MEDIUM(2),
    HIGH(3),
    LEGENDARY(4);

    final int luck;

    ChestsType(int luck) {
        this.luck = luck;
    }

    public int getLuck() {
        return luck;
    }
}
