/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.player.data;

import java.util.ArrayList;

public interface PlayerData {

    int getKeyCommun();

    void setKeyCommun(int key_commun);

    int getKeyRare();

    void setKeyRare(int key_rare);

    int getKeyEpique();

    void setKeyEpique(int key_epique);

    int getKeyLegendaire();

    void setKeyLegendaire(int key_legendaire);

    int getKeyArtefact();

    void setKeyArtefact(int key_artefact);

    int getKeyTitanesque();

    void setKeyTitanesque(int key_titanesque);

    ArrayList<?> getBoosters();


}
