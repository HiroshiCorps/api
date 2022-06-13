package fr.redxil.api.common.server;

import fr.redline.pms.utils.IpInfo;
import fr.redxil.api.common.player.rank.Rank;
import fr.redxil.api.common.server.type.ServerAccess;
import fr.redxil.api.common.server.type.ServerStatus;
import fr.xilitra.hiroshisav.enums.ServerType;

public interface ServerCreator {

    /**
     *
     *  Get the type of the server
     * @return The ServerType
     *
     */

    ServerType getServerType();


    /**
     * Get the name of the server
     * @return The server name
     */
    String getServerName();

    /**
     * Get the name of the server
     * @return The server map
     */
    String getServerMap();

    /**
     * Get the server ip
     * @return The server ip
     */
    IpInfo getIpInfo();

    /**
     * Get eh max number of player
     * @return Max number of player
     */
    Integer getMaxPlayer();

    ServerStatus getServerStatus();

    /**
     * Get if the server need to be generated
     * @return True if the server need to be generated
     */
    boolean needGenerate();

    ServerAccess getServerAccess();

    Rank getRankAccess();

}
