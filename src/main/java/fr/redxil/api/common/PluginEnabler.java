/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common;

import fr.redline.pms.utils.IpInfo;

import java.io.File;
import java.util.logging.Level;

public interface PluginEnabler {

    IpInfo getServerIp();

    boolean isVelocity();

    File getPluginDataFolder();

    String getServerName();

    String getPluginVersion();

    int getMaxPlayer();

    void shutdownServer(String msg);

    void shutdownPlugin(String msg);

    String getServerVersion();

    /**
     * Log a given message at the current level into
     * the console
     *
     * @param level Log level
     * @param text  Log test
     */
    void printLog(Level level, String text);

}
