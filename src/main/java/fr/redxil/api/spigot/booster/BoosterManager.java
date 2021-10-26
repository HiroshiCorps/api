/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.spigot.booster;

import org.bukkit.entity.Player;

import java.util.HashMap;

public interface BoosterManager {

    /* Booster activé acutellement sur le serveur

        @Param name Nom du booster.
     */

    BoosterData getBooster(String name);

    void setBooster(String name, BoosterData data);

    /* Récupérer tout les boosters */

    HashMap<String, BoosterData> getBoosters();

    void addNewBoosters(Player player, int value, int quantity);

    void openBoostersMenu(Player player);

    String getBoosterLabel(String booster);

    int getBoosterValue(String boosterName, int value);

}
