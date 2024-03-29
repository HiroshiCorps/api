/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.player.moderators;

import java.util.Optional;

public enum Actions {

    BAN("ban"), MUTE("mute"), KICK("kick"), WARN("warn");

    final String name;

    Actions(String name) {
        this.name = name;
    }

    public static Optional<Actions> getAction(String name) {
        for (Actions action : Actions.values()) {
            if (action.getName().equalsIgnoreCase(name)) {
                return Optional.of(action);
            }
        }
        return Optional.empty();
    }

    public String getName() {
        return name;
    }

}
