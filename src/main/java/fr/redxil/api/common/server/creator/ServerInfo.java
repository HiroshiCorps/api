package fr.redxil.api.common.server.creator;

import fr.redline.pms.utils.IpInfo;
import fr.redxil.api.common.player.rank.Rank;
import fr.redxil.api.common.server.type.ServerAccess;
import fr.redxil.api.common.server.type.ServerStatus;
import fr.xilitra.hiroshisav.enums.ServerType;

public class ServerInfo {

    final ServerType serverType;
    final String serverName;
    final String serverMap;
    final IpInfo port;
    final Integer maxPlayer;
    final ServerStatus serverStatus;
    final Boolean needGenerate;
    ServerAccess serverAccess;
    Rank accessRank;

    ServerInfo(String serverName, IpInfo port, ServerType serverType, ServerStatus serverStatus, ServerAccess serverAccess, Rank accessRank, Boolean needGenerate, String serverMap, Integer maxPlayer) {
        this.serverType = serverType;
        this.serverName = serverName;
        this.serverMap = serverMap;
        this.port = port;
        this.maxPlayer = maxPlayer;
        this.serverStatus = serverStatus;
        this.needGenerate = needGenerate;
        this.serverAccess = serverAccess;
        this.accessRank = accessRank;
    }

    /**
     * Get the type of the server
     *
     * @return The ServerType
     */

    public ServerType getServerType() {
        return serverType;
    }


    /**
     * Get the name of the server
     *
     * @return The server name
     */
    public String getServerName() {
        return serverName;
    }

    /**
     * Get the name of the server
     *
     * @return The server map
     */
    public String getServerMap() {
        return serverMap;
    }

    /**
     * Get the server ip
     *
     * @return The server ip
     */
    public IpInfo getIpInfo() {
        return port;
    }

    /**
     * Get eh max number of player
     *
     * @return Max number of player
     */
    public Integer getMaxPlayer() {
        return maxPlayer;
    }

    public ServerStatus getServerStatus() {
        return serverStatus;
    }

    /**
     * Get if the server need to be generated
     *
     * @return True if the server need to be generated
     */
    public Boolean needGenerate() {
        return needGenerate;
    }

    public ServerAccess getServerAccess() {
        return serverAccess;
    }

    public Rank getRankAccess() {
        return accessRank;
    }

    public void setServerAccess(ServerAccess serverAccess, Rank rank){
        this.serverAccess = serverAccess;
        this.accessRank = rank;
    }

}
