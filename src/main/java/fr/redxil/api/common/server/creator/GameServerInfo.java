package fr.redxil.api.common.server.creator;

import fr.redline.pms.utils.IpInfo;
import fr.redxil.api.common.player.rank.Rank;
import fr.redxil.api.common.server.type.ServerAccess;
import fr.redxil.api.common.server.type.ServerStatus;
import fr.xilitra.hiroshisav.enums.ServerType;
import fr.xilitra.hiroshisav.enums.TypeGame;

public class GameServerInfo extends ServerInfo {

    final TypeGame typeGame;

    public GameServerInfo(String serverName, IpInfo port, ServerStatus serverStatus, Boolean needGenerate, String serverMap, TypeGame typeGame) throws GameConfigError {
        super(serverName, port, ServerType.GAME, serverStatus, ServerAccess.LIMITED, Rank.JOUEUR, needGenerate, serverMap, typeGame.getDefaultMaxNPSpec() + typeGame.getDefaultMaxP() + 5);
        this.typeGame = typeGame;
        if (!this.getTypeGame().getAvailableMap().contains(serverMap))
            throw new GameConfigError("Map: " + serverMap + " is not available for game: " + typeGame.getName());
    }

    public TypeGame getTypeGame() {
        return typeGame;
    }

}