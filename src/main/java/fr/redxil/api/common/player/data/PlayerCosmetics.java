/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.player.data;

public interface PlayerCosmetics {

    void addDoublons(int value, boolean output);

    boolean delDoublons(int value);

    int getDoublons();

    void addBox(String boxName, int addAmount);

}
