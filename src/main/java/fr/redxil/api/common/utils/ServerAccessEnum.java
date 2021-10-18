package fr.redxil.api.common.utils;

import fr.redxil.api.common.data.PlayerDataValue;

public enum ServerAccessEnum {

    PRENIUM(PlayerDataValue.PLAYER_UUID_SQL),
    CRACK(PlayerDataValue.PLAYER_NAME_SQL);

    private final PlayerDataValue pdv;

    ServerAccessEnum(PlayerDataValue playerDataValue){
        this.pdv = playerDataValue;
    }

    public PlayerDataValue getPlayerDataValueEquivalent(){
        return pdv;
    }

}
