/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common;

import fr.redxil.api.common.player.APIPlayerManager;
import fr.redxil.api.common.player.moderators.ModeratorManager;
import fr.redxil.api.common.redis.RedisManager;
import fr.redxil.api.common.server.Server;
import fr.redxil.api.common.server.ServerManager;
import fr.redxil.api.common.sql.SQLConnection;
import fr.xilitra.hiroshisav.enums.ServerType;

import java.util.Optional;

public abstract class API {

    protected static API instance = null;

    /**
     * Get the instance of the API
     *
     * @return Instance
     */
    public static API getInstance() {
        return instance;
    }

    public static boolean isAPIEnabled(){
        return getInstance() != null;
    }



    public abstract Optional<RedisManager> getRedisManager();

    /**
     * Get the instance of the player manager
     *
     * @return Instance
     */
    public abstract APIPlayerManager getPlayerManager();

    /**
     * Get the instance of the server manager
     *
     * @return Instance
     */
    public abstract ServerManager getServerManager();

    /**
     * Get the instance of the moderator manager
     *
     * @return Instance
     */
    public abstract ModeratorManager getModeratorManager();

    /**
     * Get the server option class
     *
     * @return Server's instance
     */
    public abstract Server getServer();

    public abstract String getServerName();

    /**
     * Get the root plugin of the API
     *
     * @return Root plugin instance
     */
    public abstract APIEnabler getAPIEnabler();

    public abstract Optional<SQLConnection> getSQLConnection();

    public abstract void shutdown();

    public abstract long getServerID();

    public abstract boolean dataConnected();

    public abstract boolean isOnlineMod();

    public abstract boolean isVelocity();

    public long getResponse() {
        return System.currentTimeMillis();
    }

}
