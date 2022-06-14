package fr.redxil.api.common.server.creator;

import fr.redline.pms.utils.IpInfo;
import fr.redxil.api.common.player.rank.Rank;
import fr.redxil.api.common.server.type.ServerAccess;
import fr.redxil.api.common.server.type.ServerStatus;
import fr.xilitra.hiroshisav.enums.ServerType;

public class HUBServerInfo extends ServerInfo {
    public HUBServerInfo(String serverName, IpInfo ipInfo, ServerStatus serverStatus, Boolean needGenerate, Integer maxPlayer) {
        super(serverName, ipInfo, ServerType.HUB, serverStatus, ServerAccess.LIMITED, Rank.JOUEUR, needGenerate, "hub", maxPlayer+5);
    }
}