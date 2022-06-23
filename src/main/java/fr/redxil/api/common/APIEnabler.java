/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common;

import fr.redxil.api.common.server.creator.ServerInfo;
import fr.redxil.api.paper.PaperAPI;

import java.io.File;
import java.util.UUID;
import java.util.logging.Logger;

public interface APIEnabler {


    /**
     * Event called when API is online and ready
     */
    void onAPIEnabled();

    /**
     * Event called when API turns to offline
     */
    void onAPIDisabled();

    void onAPIInitPhaseEnded(APIPhaseInit apiPhaseInit);

    void onAPILoadFail(APIPhaseInit apiPhaseInit, APILoadError apiLoadError);

    boolean isPluginEnabled();

    void setPluginEnable(boolean value);

    /**
     * Get the data folder for the plugin
     *
     * @return the specific plugin folder
     */
    File getPluginDataFolder();

    /**
     * Get the data folder for the Core plugin
     *
     * @return the specific plugin folder
     */
    default File getCoreDataFolder() {
        if (isVelocity())
            return getPluginDataFolder();
        else return PaperAPI.getInstance().getCoreFile();
    }

    /**
     * Get the current CORE version
     *
     * @return CORE version
     */
    String getPluginVersion();

    /**
     * Get the server version
     *
     * @return server version
     */
    String getServerVersion();

    Logger getLogger();

    boolean sendMessage(String pseudo, String message);

    boolean sendMessage(UUID uuid, String message);

    ServerInfo getServerInfo();

    default boolean isVelocity() {
        return false;
    }

}
