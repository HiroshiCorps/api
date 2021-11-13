/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.server;

import fr.redline.pms.utils.IpInfo;
import fr.redxil.api.common.server.type.ServerType;

import java.util.List;

public interface ServerManager {

    List<String> getListServerName();

    List<Long> getListServerID();

    List<Server> getListServer();

    List<Server> getListServer(ServerType serverType);

    boolean isServerExist(String name);

    boolean isServerExist(long serverID);

    Server getServer(String name);

    Server getServer(long serverID);

    Server initServer(String name, IpInfo ipInfo);

}
