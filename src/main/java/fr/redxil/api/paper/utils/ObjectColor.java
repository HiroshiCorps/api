/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.paper.utils;

import org.bukkit.DyeColor;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Colorable;

public class ObjectColor {

    public static DyeColor getColor(ItemStack itemStack) {
        return !(itemStack instanceof Colorable) ? null : ((Colorable) itemStack).getColor();
    }

    public static DyeColor getColor(Block block) {
        return !(block instanceof Colorable) ? null : ((Colorable) block).getColor();
    }

    public static boolean setColor(ItemStack itemStack, DyeColor dyeColor) {

        if (!(itemStack instanceof Colorable)) return false;
        ((Colorable) itemStack).setColor(dyeColor);
        return true;

    }

    public static boolean setColor(Block block, DyeColor dyeColor) {

        if (!(block instanceof Colorable)) return false;
        ((Colorable) block).setColor(dyeColor);
        return true;

    }

    public static boolean hasColor(Block block) {
        return block instanceof Colorable;
    }

    public static boolean hasColor(ItemStack itemStack) {
        return itemStack instanceof Colorable;
    }

}
