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

    /**
     * Event called when API is online and ready
     */
    void onAPIEnabled();

    /**
     * Event called when API turns to offline
     */
    void onAPIDisabled();

    /**
     * Get the serverID
     *
     * @return the ip of the current server
     */
    IpInfo getServerIp();

    /**
     * Get if the server is a proxy server
     *
     * @return true if Server is Proxy server
     */
    boolean isVelocity();

    /**
     * Get the dat folder for the plugin
     *
     * @return the specific plugin folder
     */
    File getPluginDataFolder();

    /**
     * Get the current CORE version
     *
     * @return CORE version
     */
    String getPluginVersion();

    /**
     * Get server max player
     *
     * @return the max player of the server
     */
    int getMaxPlayer();

    /**
     * Get the server version
     *
     * @return server version
     */
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
