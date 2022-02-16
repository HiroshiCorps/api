/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.game.utils;

public enum GameEnum {
    TAG("tag", true, 5, false, false, 2, 10),
    TEST("test", true, 5, false, false, 2, 10),
    FATALITY("fatality", true, 5, false, false, 15, 15);

    final String name;
    final boolean modSpecOnly;
    final boolean canHost;
    final boolean hostOnly;
    final int minP;
    final int maxP;
    final int maxNPSpec;

    GameEnum(String name, boolean modSpecOnlyv, int maxNPSpec, boolean canHost, boolean hostOnly, int minP, int maxP) {
        this.name = name;
        this.modSpecOnly = modSpecOnlyv;
        this.canHost = canHost;
        this.hostOnly = hostOnly;
        this.minP = minP;
        this.maxP = maxP;
        this.maxNPSpec = maxNPSpec;
    }

    public static GameEnum getStatus(String name) {
        for (GameEnum hs : values())
            if (hs.toString().equals(name))
                return hs;
        return null;
    }

    public String toString() {
        return name;
    }

    public boolean isCanHost() {
        return canHost;
    }

    public boolean isAllowPlSpec() {
        return !modSpecOnly;
    }

    public boolean isHostOnly() {
        return hostOnly;
    }

    public int getDefaultMinP() {
        return minP;
    }

    public int getDefaultMaxP() {
        return maxP;
    }

    public int getDefaultMaxNPSpec() {
        return maxNPSpec;
    }

}
