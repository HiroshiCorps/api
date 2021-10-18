/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  * Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *  * Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.spigot.minigame.chests;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class Chests {

    private String world;
    private double x, y, z;

    private String chestType;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public String getChestType() {
        return chestType;
    }

    public void setChestType(String chestType) {
        this.chestType = chestType;
    }

    public Location toBukkitLocation() {
        return new Location(Bukkit.getWorld(world), x, y, z);
    }

    public World getBukkitWorld() {
        return Bukkit.getWorld(world);
    }

    public ChestsType toChestType() {
        return ChestsType.valueOf(chestType);
    }

    public String getWorld() {
        return world;
    }

    public void setWorld(String world) {
        this.world = world;
    }
}
