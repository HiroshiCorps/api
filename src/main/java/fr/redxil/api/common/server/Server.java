/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.server;

import fr.redline.pms.utils.IpInfo;
import fr.redxil.api.common.game.Games;
import fr.redxil.api.common.player.APIPlayer;
import fr.redxil.api.common.server.type.ServerStatus;
import fr.redxil.api.common.server.type.ServerTasks;
import fr.redxil.api.common.server.type.ServerType;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface Server {

    int getMaxPlayers();

    void setMaxPlayers(int players);

    void changeMaintenance(boolean value);

    String getServerName();

    Collection<APIPlayer> getPlayerList();

    Collection<UUID> getPlayerUUIDList();

    long getLastPing();

    Object getServerResponseMessage(int value);

    boolean isInMaintenance();

    boolean isOnline();

    IpInfo getServerIP();

    int getPowerAcces();

    boolean shutdown();

    boolean canConnectTo(APIPlayer apiPlayer);

    ServerStatus getServerStatus();

    ServerType getServerType();

    long getServerId();

    void setPlayerInServer(APIPlayer apiPlayer);

    void removePlayerInServer(UUID uuid);

    ServerTasks getTasks();

    void changeTask(ServerTasks serverTasks);

    void sendShutdownOrder();

    boolean isHostDedicated();

    String getHostAuthor();

    boolean isGamesServer();

    Games getGames();

    List<Long> getTeamLinked();

}
