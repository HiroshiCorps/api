/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.game.utils;

public enum GameState {

    WAITING("WAIT"),
    START("START"),
    GAME("GAME"),
    FINISH("FIN"),
    CRASHED("CRASHED");

    private final String name;

    GameState(String name) {
        this.name = name;
    }

    public static GameState getState(String name) {
        for (GameState gs : values())
            if (gs.getName().equals(name))
                return gs;

        return null;
    }

    public String getName() {
        return name;
    }

}
