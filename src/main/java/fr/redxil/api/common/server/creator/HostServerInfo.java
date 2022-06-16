package fr.redxil.api.common.server.creator;

import fr.redline.pms.utils.IpInfo;
import fr.redxil.api.common.player.rank.Rank;
import fr.redxil.api.common.server.type.ServerAccess;
import fr.redxil.api.common.server.type.ServerStatus;
import fr.xilitra.hiroshisav.enums.ServerType;
import fr.xilitra.hiroshisav.enums.TypeGame;

public class HostServerInfo extends ServerInfo {

    final Long host;
    final TypeGame typeGame;

    public HostServerInfo(String serverName, IpInfo port, ServerStatus serverStatus, Boolean needGenerate, String serverMap, TypeGame typeGame, Long host) throws GameConfigError {
        super(serverName, port, ServerType.HOST, serverStatus, ServerAccess.LIMITED, Rank.JOUEUR, needGenerate, serverMap, typeGame.getDefaultMaxNPSpec() + typeGame.getDefaultMaxP() + 5);
        this.host = host;
        this.typeGame = typeGame;
        if (!this.getTypeGame().getAvailableMap().contains(serverMap))
            throw new GameConfigError("Map: " + serverMap + " is not available for game: " + typeGame.getName());
    }

    public Long getHost() {
        return host;
    }

    public TypeGame getTypeGame() {
        return typeGame;
    }

}
