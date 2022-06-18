/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.server;

import fr.redxil.api.common.player.APIPlayer;
import fr.redxil.api.common.server.creator.ServerInfo;
import fr.xilitra.hiroshisav.enums.ServerType;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

public interface ServerManager {

    Collection<String> getListServerName();

    Collection<Long> getListServerID();

    Collection<Server> getListServer();

    Collection<Server> getListServer(ServerType serverType);

    boolean isServerExist(String name);

    boolean isServerExist(long serverID);

    Optional<Server> getServer(String name);

    Optional<Server> getServer(long serverID);

    Optional<Server> createServer(ServerInfo serverInfo);

    Optional<Server> loadServer(Long serverID);

    Optional<Server> getConnectableServer(APIPlayer apiPlayer, ServerType serverType);

    Map<String, Long> getNameToLongMap();

}
