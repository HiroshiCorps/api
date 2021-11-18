/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.spigot.utils;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class MathMain {

    public static double radToDeg(double rad) {
        return rad * (180 / Math.PI);
    }

    public static double calculDiff(Location from, Location to, boolean high) {

        double x = to.getX() - from.getX(),
                y = to.getY() - from.getY(),
                z = to.getZ() - from.getZ();

        return !high ? Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2))
                :
                Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));

    }

    public static Direction calculateDirection(Player from, Player to) {

        return calculateDirection(from, to.getLocation());

    }

    public static Direction calculateDirection(Player p, Location to) {
        Vector vector = to.toVector().subtract(p.getLocation().toVector());
        return Direction.getDirection(calcAngle(p.getEyeLocation().getDirection(), vector, false, false));
    }

    public static Double calcAngle(Location from, Location to, boolean highAtZ, boolean keepNegative) {
        return calcAngle(from.getDirection(), to.toVector(), highAtZ, keepNegative);
    }

    public static Double calcAngle(Vector v1, Vector v2, boolean highAtZ, boolean keepNegative) {
        double dot;
        double det;
        if (!highAtZ) {
            dot = v1.getX() * v2.getX() + v1.getZ() * v2.getZ();
            det = v1.getX() * v2.getZ() - v1.getZ() * v2.getX();
        } else {
            dot = v1.getX() * v2.getX() + v1.getY() * v2.getY();
            det = v1.getX() * v2.getY() - v1.getY() * v2.getX();
        }
        double deg = radToDeg(Math.atan2(det, dot));
        if (!keepNegative)
            deg += 360;
        return deg;
    }
}
