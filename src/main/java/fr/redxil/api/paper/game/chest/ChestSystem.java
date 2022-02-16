/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.paper.game.chest;

import fr.redxil.api.common.utils.randomizer.ListRandomizer;

import java.util.*;

public class ChestSystem {

    public final HashMap<ChestLegendary, List<Chest>> chestByLegendary = new HashMap<>();
    public final HashMap<ChestLegendary, List<Items>> itemsByLegendary = new HashMap<>();
    public final Random random = new Random();

    public List<Chest> getChests(ChestLegendary chestLegendary){

        return chestByLegendary.get(chestLegendary);

    }

    public List<Items> getItems(ChestLegendary chestLegendary){

        return itemsByLegendary.get(chestLegendary);

    }

    public void addChest(Collection<Chest> chests){

        chests.forEach((chest) -> chestByLegendary.computeIfAbsent(chest.getChestLegendary(), k -> new ArrayList<>()).add(chest));

    }

    public void addItems(Collection<Items> items){

        items.forEach((item) -> itemsByLegendary.computeIfAbsent(item.getLegendary(), k -> new ArrayList<>()).add(item));

    }

    public boolean hadChance(Items items){

        return items.getPercentage() >= 100 || random.nextInt(101) <= items.getPercentage();

    }

    public void fillChest(ChestLegendary chestLegendary){

        for(Chest chest : getChests(chestLegendary)){

            org.bukkit.block.Chest bukkitChest = chest.getChest();

            if(bukkitChest == null) continue;

            bukkitChest.getBlockInventory().clear();
            ListRandomizer<Integer> integerRandomizer = new ListRandomizer<>();
            for(int i = 0; i<bukkitChest.getInventory().getSize(); i++)
                integerRandomizer.addItem(i);

            getItems(chestLegendary).forEach((item) -> {

                if (hadChance(item))
                    bukkitChest.getBlockInventory().setItem(integerRandomizer.getRandomAndRemove(), item.getItemStack());

            });

        }

    }

    public void fillChest(){

        for(ChestLegendary chestLegendary : ChestLegendary.values())
            fillChest(chestLegendary);

    }

}
