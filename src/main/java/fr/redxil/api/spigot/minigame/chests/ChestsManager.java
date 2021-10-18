/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  * Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *  * Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.spigot.minigame.chests;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class ChestsManager {

    private HashMap<ItemStack, ChestsType> items = new HashMap<>();

    private List<Chests> loadedChests = new ArrayList<>();

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    public void loadItems(HashMap<String, ChestsType>... chests) {

        for (HashMap<String, ChestsType> chest : chests) {
            chest.forEach((s, chestsType) -> {
                ItemStack itemStack = null;

                for (Material material : Material.values()) {
                    if (s.toLowerCase().contains(material.toString().toLowerCase())) {
                        itemStack = new ItemStack(material);
                    }
                }

                if (itemStack != null) {
                    String newS = s.replaceAll(itemStack.getType().toString().toUpperCase(), "").replaceAll(" : ", "");

                    if (isInteger("" + newS.charAt(0))) {
                        itemStack.setAmount(Integer.parseInt("" + newS.charAt(0)));
                    }

                    if (newS.length() > 1 && isInteger("" + newS.charAt(1))) {
                        String amount = String.valueOf(itemStack.getAmount());
                        amount = amount + newS.charAt(1);

                        itemStack.setAmount(Integer.parseInt(amount));
                    }

                    String enchantmentS = newS.replaceAll("" + itemStack.getAmount(), "").replaceAll("enchant:", "").replaceAll(" ", "").replaceAll(":", "");

                    for (Enchantment enchantment : Enchantment.values()) {
                        if (enchantmentS.replaceAll(":", "").startsWith(enchantment.getName().toUpperCase())) {
                            String newEnchantment = enchantmentS.replaceAll(enchantment.toString().toUpperCase(), "").replaceAll(":", "");

                            if (isInteger("" + newEnchantment.charAt(0))) {
                                itemStack.addEnchantment(enchantment, Integer.parseInt("" + newEnchantment.charAt(0)));
                            } else {
                                itemStack.addEnchantment(enchantment, 1);
                            }
                        }
                    }


                    items.put(itemStack, chestsType);
                } else {
                    throw new NullPointerException("Cannot find material for chest item : " + s);
                }
            });
        }

    }

    public void loadChest(Collection<Chests>... chests) {

        List<Chests> collectionChestsTypeHashMap = new ArrayList<>();

        for (Collection<Chests> chest : chests) {
            collectionChestsTypeHashMap.addAll(chest);
        }

        if (collectionChestsTypeHashMap.isEmpty())
            return;

        for (Chests chest : collectionChestsTypeHashMap) {
            Block block = chest.getBukkitWorld().getBlockAt(chest.toBukkitLocation());

            if (block.getType() == Material.CHEST) {
                Chest c = (Chest) block.getState();
                Inventory inventory = c.getBlockInventory();

                List<ItemStack> chestsItems = getChestsByType(chest.toChestType());

                Random rand = new Random();

                for (int amountOfItems = 0; amountOfItems < 9; amountOfItems++) {
                    int random = (int) (Math.random() * ((26) + 1));

                    inventory.setItem(random, chestsItems.get(rand.nextInt(chestsItems.size())));

                }
            } else {
                continue;
            }
        }

        loadedChests.addAll(collectionChestsTypeHashMap);
    }

    public List<ItemStack> getChestsByType(ChestsType type) {
        List<ItemStack> i = new ArrayList<>();

        items.forEach((chestsItems, t) -> {
            if (t == type) {
                i.add(chestsItems);
            }
        });

        return i;
    }

}
