/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  * Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *  * Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.server.type;

public enum ServerType {

    HUB("HUB"),
    LOBBY("LOBBY"),
    HOST("HOST"),
    PRIVATE("PRIVATE"),
    GAME("GAME"),
    UNKNOWN("UNKNOWN"),
    BUNGEE("BUNGEE");

    String name;

    ServerType(String name) {
        this.name = name;
    }

    public static ServerType fromString(String string) {
        for (ServerType Server : values()) {
            if (string.equals(Server.toString()))
                return Server;
        }
        return null;
    }

    public String toString() {
        return name;
    }

}
