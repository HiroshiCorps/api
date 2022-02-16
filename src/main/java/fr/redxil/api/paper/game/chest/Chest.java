/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.paper.game.chest;

import org.bukkit.Location;
import org.bukkit.block.Block;

public class Chest {

    final Location location;
    final ChestLegendary chestLegendary;

    public Chest(Location location, ChestLegendary chestLegendary){
        this.location = location;
        this.chestLegendary = chestLegendary;
    }

    public Location getChestLocation(){
        return location;
    }

    public ChestLegendary getChestLegendary(){
        return chestLegendary;
    }

    public org.bukkit.block.Chest getChest(){

        Block block = location.getBlock();
        if(block.getState() instanceof org.bukkit.block.Chest)
            return (org.bukkit.block.Chest) block.getState();

        return null;

    }

}