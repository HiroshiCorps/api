/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.spigot.minigame.chest;

import org.bukkit.inventory.ItemStack;

public class Items {

    final ItemStack itemStack;
    final ChestLegendary chestLegendary;
    final int percentage;

    public Items(ItemStack itemStack, ChestLegendary chestLegendary, int percentage){
        this.itemStack = itemStack;
        this.chestLegendary = chestLegendary;
        this.percentage = percentage;
    }

    public ItemStack getItemStack(){
        return itemStack;
    }

    public ChestLegendary getLegendary() {
        return chestLegendary;
    }

    public int getPercentage() {
        return percentage;
    }
}
