/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  * Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *  * Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.spigot.minigame.kits;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class KitExecutor {

    public static final int HELMET = 39;
    public static final int CHESTPLATE = 38;
    public static final int LEGGINGS = 37;
    public static final int BOOTS = 36;

    private final String name;
    private final ItemStack itemStack;
    private final HashMap<Integer, ItemStack> items = new HashMap<>();
    private String displayName;
    private boolean food = false;
    private boolean combo = false;
    private int power = 0;

    public KitExecutor(String name, String displayName, ItemStack itemStack) {
        this.name = name;
        this.displayName = displayName;
        this.itemStack = itemStack;
    }

    public void giveTo(Player player) {
        player.getInventory().clear();

        for (Map.Entry<Integer, ItemStack> entry : this.getItems().entrySet()) {
            int slot = entry.getKey();
            player.getInventory().setItem(slot, entry.getValue());
        }
    }

    protected abstract HashMap<Integer, ItemStack> getItems();

    public ArrayList<PotionEffect> getPotionsEffects() {
        return new ArrayList<>();
    }

    public HashMap<Integer, ItemStack> getContent() {
        return items;
    }

    public String getName() {
        return name;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isCombo() {
        return combo;
    }

    public void setCombo(boolean combo) {
        this.combo = combo;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
