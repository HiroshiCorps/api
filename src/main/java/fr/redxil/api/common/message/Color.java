/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.message;

public enum Color {
    BLACK('0', 0, 0, 0),
    DARK_BLUE('1', 0, 0, 170),
    DARK_GREEN('2', 0, 170, 0),
    DARK_AQUA('3', 0, 170, 170),
    DARK_RED('4', 170, 0, 0),
    DARK_PURPLE('5', 170, 0, 170),
    GOLD('6', 255, 170, 0),
    GRAY('7', 170, 170, 170),
    DARK_GRAY('8', 85, 85, 85),
    BLUE('9', 85, 85, 255),
    GREEN('a', 85, 255, 85),
    AQUA('b', 85, 255, 255),
    RED('c', 255, 85, 85),
    LIGHT_PURPLE('d', 255, 85, 255),
    YELLOW('e', 255, 255, 85),
    WHITE('f', 255, 255, 255),
    RESET('r', 0, 0, 0);

    final char carac;
    final int red, green, blue;

    Color(char carac, int r, int g, int b) {
        this.carac = carac;
        this.red = r;
        this.green = g;
        this.blue = b;
    }

    public static Color getByChar(char car) {
        for (Color color : values())
            if (color.getChar() == car)
                return color;
        return null;
    }

    public static Color getByMOTD(String motd) {
        return getByChar(motd.charAt(motd.length() - 1));
    }

    public char getChar() {
        return carac;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public java.awt.Color getColor() {
        return new java.awt.Color(getRed(), getGreen(), getBlue());
    }

    public String getMOTD() {
        return "/uA00A7" + getChar();
    }

    @Override
    public String toString() {
        return getMOTD();
    }

}
