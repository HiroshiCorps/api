package fr.redxil.api.common.server.creator;

import fr.redline.pms.utils.IpInfo;
import fr.redxil.api.common.player.rank.Rank;
import fr.redxil.api.common.server.type.ServerAccess;
import fr.redxil.api.common.server.type.ServerStatus;
import fr.xilitra.hiroshisav.enums.ServerType;
import fr.xilitra.hiroshisav.enums.TypeGame;

public class GameServerInfo extends ServerInfo {

    final TypeGame typeGame;

    public GameServerInfo(String serverName, IpInfo ipInfo, ServerStatus serverStatus, Boolean needGenerate, String serverMap, TypeGame typeGame) {
        super(serverName, ipInfo, ServerType.GAME, serverStatus, ServerAccess.LIMITED, Rank.JOUEUR, needGenerate, serverMap, typeGame.getDefaultMaxNPSpec()+typeGame.getDefaultMaxP()+5);
        this.typeGame = typeGame;
    }

    public TypeGame getTypeGame(){
        return typeGame;
    }

}