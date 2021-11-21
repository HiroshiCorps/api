/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.server.type;

public enum ServerStatus {

    ONLINE,
    OFFLINE;

    public static ServerStatus getServerStatus(String string) {
        for (ServerStatus serverAccess : values())
            if (serverAccess.toString().equals(string))
                return serverAccess;
        return null;
    }

}
