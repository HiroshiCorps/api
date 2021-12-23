/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common;

import fr.redxil.api.common.game.Game;
import fr.redxil.api.common.game.GameManager;
import fr.redxil.api.common.game.Host;
import fr.redxil.api.common.group.party.PartyManager;
import fr.redxil.api.common.group.team.TeamManager;
import fr.redxil.api.common.player.APIPlayerManager;
import fr.redxil.api.common.player.moderators.ModeratorManager;
import fr.redxil.api.common.redis.RedisManager;
import fr.redxil.api.common.server.Server;
import fr.redxil.api.common.server.ServerManager;
import fr.redxil.api.common.server.type.ServerType;
import fr.redxil.api.common.sql.SQLConnection;

public abstract class API {

    private static API instance;
    private static boolean enabled = false;
    private final PluginEnabler plugin;

    /**
     * Constructor
     *
     * @param plugin Root plugin
     */
    public API(PluginEnabler plugin) {
        instance = this;
        this.plugin = plugin;
    }

    /**
     * Get the instance of the API
     *
     * @return Instance
     */
    public static API getInstance() {
        return instance;
    }

    public abstract PartyManager getPartyManager();

    public abstract RedisManager getRedisManager();

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

    public abstract GameManager getGameManager();

    /**
     * Get the root plugin of the API
     *
     * @return Root plugin instance
     */
    public PluginEnabler getPluginEnabler() {
        return this.plugin;
    }

    public abstract ServerType getServerType();

    public abstract SQLConnection getSQLConnection();

    public abstract Host getHost();

    public abstract boolean isHostServer();

    public abstract Game getGame();

    public abstract boolean isGameServer();

    public abstract void shutdown();

    public abstract TeamManager getTeamManager();

    public abstract String getServerName();

    public boolean isVelocity() {
        return plugin.isVelocity();
    }

    public boolean isSpigot() {
        return !isVelocity();
    }

    public long getResponse() {
        return System.currentTimeMillis();
    }

    public boolean isEnabled() {
        return enabled;
    }

    public static void setEnabled(boolean enabled) {
        API.enabled = enabled;
    }

}
