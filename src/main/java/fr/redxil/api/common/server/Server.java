/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.server;

import fr.redline.pms.utils.IpInfo;
import fr.redxil.api.common.player.rank.Rank;
import fr.redxil.api.common.server.type.ServerAccess;
import fr.redxil.api.common.server.type.ServerStatus;
import fr.redxil.api.common.server.type.ServerType;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface Server {

    Optional<String> getServerName();

    void setServerName(String serverName);

    ServerType getServerType();

    void setServerType(ServerType serverType);

    long getServerID();


    Optional<Integer> getMaxPlayers();

    void setMaxPlayers(int players);

    IpInfo getServerIP();

    boolean isOnline();

    void shutdown();


    void setPlayerConnected(UUID uuid, boolean connected);


    Collection<UUID> getPlayerList();

    int getConnectedPlayer();


    ServerStatus getServerStatus();

    void setServerStatus(ServerStatus serverStatus);


    ServerAccess getServerAccess();

    void setServerAccess(ServerAccess serverAccess);

    /// RANK_SPECIFIC / RANK_SPECIFIC_MIN

    Rank getReservedRank();

    void setReservedRank(Rank rank);

    /// LIMITED

    void setAllowedConnect(UUID uuid, boolean value);

    boolean getAllowedConnect(UUID uuid);

    void setServerIP(IpInfo ipInfo);

}
