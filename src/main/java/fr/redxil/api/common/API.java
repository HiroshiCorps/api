/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common;

import fr.redline.pms.utils.IpInfo;
import fr.redxil.api.common.game.GameManager;
import fr.redxil.api.common.group.party.PartyManager;
import fr.redxil.api.common.group.team.TeamManager;
import fr.redxil.api.common.player.APIPlayerManager;
import fr.redxil.api.common.player.moderators.ModeratorManager;
import fr.redxil.api.common.server.Server;
import fr.redxil.api.common.server.ServerManager;

public abstract class API {

    protected static API instance = null;
    protected static boolean enabled = false;

    /**
     * Get the instance of the API
     *
     * @return Instance
     */
    public static API getInstance() {
        return instance;
    }

    public static boolean isAPIEnabled() {
        return enabled && instance != null;
    }

    /**
     * Get the instance of the player manager
     *
     * @return Instanceof player
     * @apiNote Can only be use after Phase 2 of init
     */
    public abstract APIPlayerManager getPlayerManager();

    /**
     * Get the instance of the server manager
     * @apiNote Can only be use after Phase 2 of init
     * @return Instance
     */
    public abstract ServerManager getServerManager();

    /**
     * Get the instance of the moderator manager
     *
     * @return Instance
     * @apiNote Can only be use after Phase 2 of init
     */
    public abstract ModeratorManager getModeratorManager();

    /**
     * Get the server option class
     *
     * @return Server's instance
     * @apiNote Can only be use after Phase 2 of init
     */
    public abstract Server getServer();

    /**
     * Get the name of the server
     *
     * @return The server name on the API
     * @apiNote Can only be use after Phase 1 of init
     */
    public abstract String getServerName();

    /**
     * Get the root plugin of the API
     *
     * @return Root plugin instance
     * @apiNote Can only be use after Phase 1 of init
     */
    public abstract APIEnabler getAPIEnabler();

    public abstract void shutdown();

    public abstract long getServerID();

    public abstract boolean isOnlineMod();

    /**
     * Get the Party Manager
     *
     * @return PartyManager
     * @apiNote Can only be use after Phase 2 of init
     */
    public abstract PartyManager getPartyManager();

    /**
     * Get the Game Manager
     *
     * @return GameManager
     * @apiNote Can only be use after Phase 2 of init
     */
    public abstract GameManager getGameManager();

    /**
     * @param serverID Team are linked to server, so this has to be the server id
     * @return TeamManager for the server
     * @apiNote Can only be use after Phase 2 of init
     */
    public abstract TeamManager getTeamManager(Long serverID);

    /**
     * @param apiPhaseInit Use PHASE_1 first, check for error, and after use PHASE_2
     * @param apiEnabler   APIEnabler class of your plugin
     * @apiNote Respect Phase order
     */
    public abstract void initPhase(APIPhaseInit apiPhaseInit, APIEnabler apiEnabler);

    /**
     * @return the necessary ip for player to connect to the server
     * @apiNote Can only be use after Phase 1 of init
     */
    public abstract IpInfo getConnectIpInfo();

    public long getResponse() {
        return System.currentTimeMillis();
    }

}
