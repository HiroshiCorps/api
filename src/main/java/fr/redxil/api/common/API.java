/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  * Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *  * Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common;

import fr.redxil.api.common.game.GamesManager;
import fr.redxil.api.common.game.Hosts;
import fr.redxil.api.common.moderators.ModeratorManager;
import fr.redxil.api.common.party.PartyManager;
import fr.redxil.api.common.player.APIOfflinePlayer;
import fr.redxil.api.common.player.APIPlayerManager;
import fr.redxil.api.common.redis.RedisManager;
import fr.redxil.api.common.server.Server;
import fr.redxil.api.common.server.ServerManager;
import fr.redxil.api.common.server.type.ServerType;
import fr.redxil.api.common.sql.SQLConnection;
import fr.redxil.api.common.team.TeamManager;
import fr.redxil.api.common.utils.ServerAccessEnum;
import fr.redxil.api.common.game.Games;
import fr.redxil.api.common.player.nick.NickGestion;

import java.util.UUID;

public abstract class API {

    private static API instance;
    private static boolean enabled = false;
    private final PluginEnabler plugin;
    private final ServerAccessEnum sae;

    /**
     * Constructor
     *
     * @param plugin Root plugin
     */
    public API(PluginEnabler plugin, ServerAccessEnum serverAccessEnum) {
        instance = this;
        this.plugin = plugin;
        this.sae = serverAccessEnum;
    }

    /**
     * Get the instance of the API
     *
     * @return Instance
     */
    public static API get() {
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

    public abstract GamesManager getGamesManager();

    /**
     * Get the root plugin of the API
     *
     * @return Root plugin instance
     */
    public PluginEnabler getPluginEnabler() {
        return this.plugin;
    }

    /**
     * Get the nick manager
     *
     * @return NickManager
     */
    public abstract NickGestion getNickGestion();

    public abstract ServerType getServerType();

    public abstract SQLConnection getSQLConnection();

    public abstract Hosts getHost();

    public abstract boolean isHostServer();

    public abstract Games getGame();

    public abstract boolean isGameServer();

    public abstract void shutdown();

    public abstract TeamManager getTeamManager();

    public boolean isBungee() {
        return plugin.isBungee();
    }

    public boolean isSpigot() {
        return !isBungee();
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

    public ServerAccessEnum getServerAccessEnum(){
        return this.sae;
    }

    public String getDataForGetAndSet(APIOfflinePlayer aop){
        return getServerAccessEnum() == ServerAccessEnum.CRACK ? aop.getName() : aop.getUUID().toString();
    }

    public String getDataForGetAndSet(String name, UUID uuid){
        return getServerAccessEnum() == ServerAccessEnum.CRACK ? name : uuid.toString();
    }

}
