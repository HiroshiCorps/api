/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  * Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *  * Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.spigot.minigame.chests;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ChestsItems {

    private ItemStack itemStack;
    private ChestsType chestsType;

    public ChestsItems(ItemStack itemStack, ChestsType chestsType) {
        this.itemStack = itemStack;
        this.chestsType = chestsType;
    }

    public ChestsItems(Material material, ChestsType chestsType) {
        this.itemStack = new ItemStack(material);
        this.chestsType = chestsType;
    }

    public ChestsItems(Material material, int size, ChestsType chestsType) {
        this.itemStack = new ItemStack(material, size);
        this.chestsType = chestsType;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public void setItemStack(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public ChestsType getChestsType() {
        return chestsType;
    }

    public void setChestsType(ChestsType chestsType) {
        this.chestsType = chestsType;
    }
}
