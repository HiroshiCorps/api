/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.spigot.holograms.utils;

import org.bukkit.Bukkit;

public class ServerVersion {

    private static final String version;

    static {
        String[] versionArray = Bukkit.getServer().getClass().getName().replace('.', ',').split(",");
        if (versionArray.length >= 4) {
            version = versionArray[3];
        } else {
            version = "";
        }
    }

    private ServerVersion() {
    }

    public static String getVersion() {
        return version;
    }

}
