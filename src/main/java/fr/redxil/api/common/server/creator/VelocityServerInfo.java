package fr.redxil.api.common.server.creator;

import fr.redline.pms.utils.IpInfo;
import fr.redxil.api.common.player.rank.Rank;
import fr.redxil.api.common.server.type.ServerAccess;
import fr.redxil.api.common.server.type.ServerStatus;
import fr.xilitra.hiroshisav.enums.ServerType;

public class VelocityServerInfo extends ServerInfo {

    public VelocityServerInfo(String serverName, IpInfo port, ServerStatus serverStatus, Boolean needGenerate, String serverMap, Integer maxPlayer) {
        super(serverName, port, ServerType.VELOCITY, serverStatus, ServerAccess.OPEN, Rank.JOUEUR, needGenerate, serverMap, maxPlayer);
    }
}
