/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.spigot.itemstack;

import org.bukkit.entity.Player;

public interface GlobalAction {
    /**
     * @param player
     * @return true if you want the started event to be cancelled
     */
    boolean onClick(Player player);
}
