/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.game.utils;

import java.util.Optional;

public enum HostAccess {
    OPEN("open"),
    FRIEND("friend"),
    CLOSE("close");

    final String name;

    HostAccess(String name) {
        this.name = name;
    }

    public static Optional<HostAccess> getStatus(String name) {
        for (HostAccess hs : values())
            if (hs.toString().equals(name))
                return Optional.of(hs);
        return Optional.empty();
    }

    public String toString() {
        return name;
    }

}
