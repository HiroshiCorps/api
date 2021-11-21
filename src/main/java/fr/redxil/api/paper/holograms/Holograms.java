/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.paper.holograms;

import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;

public interface Holograms {

    void spawnHologram();

    void spawnHologram(boolean remove);

    String getName();

    void setName(String name);

    ArmorStand getEntity();

    void remove();

    void teleport(Location location);

    void remove(int timeToRemove);

}
