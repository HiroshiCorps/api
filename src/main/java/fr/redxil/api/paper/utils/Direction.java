/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.paper.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Direction {

    NORTH(337.5, 22.5, "⬆"),
    SOUTH(157.5, 202.5, "⬇"),
    WEST(247.5, 292.5, "⬅"),
    EAST(67.5, 112.5, "➡"),
    NORTH_WEST(292.5, 337.5, "⬉"),
    NORTH_EAST(22.5, 67.5, "⬈"),
    SOUTH_WEST(202.5, 247.5, "⬋"),
    SOUTH_EAST(112.5, 157.5, "⬊");

    double min, max;
    String symbol;

    Direction(double min, double max, String symbol) {
        this.min = min;
        this.max = max;
        this.symbol = symbol;
    }

    private static List<Direction> calcList() {
        List<Direction> dirList = new ArrayList<>(Arrays.asList(Direction.values()));
        dirList.remove(Direction.NORTH);
        return dirList;
    }

    public static Direction getDirection(double angle) {

        for (Direction dir : calcList()) {

            if (angle >= dir.getMinAngle() && angle <= dir.getMaxAngle())
                return dir;

        }

        return Direction.NORTH;

    }

    public static Direction getDirection(float angle) {

        return getDirection(Float.valueOf(angle).doubleValue());

    }

    public double getMinAngle() {
        return min;
    }

    public double getMaxAngle() {
        return max;
    }

    public String getSymbol() {
        return symbol;
    }

}
