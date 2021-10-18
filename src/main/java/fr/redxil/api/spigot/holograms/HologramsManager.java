/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  * Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *  * Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.spigot.holograms;

import org.bukkit.Location;

import java.util.ArrayList;

public interface HologramsManager {

    Holograms createHologram(Location lo, String line);

    ArrayList<Holograms> createHolograms(Location lo, String lines);

    ArrayList<Holograms> createHolograms(Location lo, String... lines);

}
