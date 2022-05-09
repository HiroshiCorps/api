/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.server.type;

public enum ServerType {

    HUB("HUB", ServerAccess.OPEN),
    HOST("HOST", ServerAccess.LIMITED),
    PRIVATE("PRIVATE", ServerAccess.RANK_SPECIFIC),
    GAME("GAME", ServerAccess.LIMITED),
    VELOCITY("VELOCITY", ServerAccess.OPEN);

    final String name;
    final ServerAccess serverAccess;

    ServerType(String name, ServerAccess serverAccess) {
        this.name = name;
        this.serverAccess = serverAccess;
    }

    public static ServerType getServerType(String string) {
        for (ServerType server : values()) {
            if (string.equals(server.toString()))
                return server;
        }
        return null;
    }

    public String toString() {
        return name;
    }

    public ServerAccess getRelatedServerAccess() {
        return serverAccess;
    }

}
