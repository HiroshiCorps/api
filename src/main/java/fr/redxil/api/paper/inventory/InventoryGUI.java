/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.paper.inventory;

import org.bukkit.Bukkit;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public abstract class InventoryGUI implements InventoryHolder {

    Inventory inventory;
    Player player;
    String menu;
    HashMap<String, Object> toTransmit;

    public InventoryGUI(Player player, String name, int line) {
        this.player = player;
        this.menu = name;
        this.inventory = Bukkit.createInventory(this, 9 * line, name);
        this.toTransmit = new HashMap<>();
        buildGUI();
    }

    public InventoryGUI(String name, int line) {
        this.menu = name;
        this.inventory = Bukkit.createInventory(this, 9 * line, name);
        this.toTransmit = new HashMap<>();
        buildGUI();
    }

    public InventoryGUI(Player player, String name, int line, HashMap<String, Object> toTransmit) {
        this.player = player;
        this.menu = name;
        this.inventory = Bukkit.createInventory(this, 9 * line, name);
        this.toTransmit = toTransmit;
        buildGUI();
    }

    public InventoryGUI(String name, int line, HashMap<String, Object> toTransmit) {
        this.menu = name;
        this.inventory = Bukkit.createInventory(this, 9 * line, name);
        this.toTransmit = toTransmit;
        buildGUI();
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public void setName(String name) {
        closeInventory();
        ItemStack[] listItems = inventory.getContents();
        this.inventory = Bukkit.createInventory(this, this.inventory.getSize(), name);
        this.inventory.setContents(listItems);
    }

    public void setSize(int line) {
        closeInventory();
        this.inventory = Bukkit.createInventory(this, 9 * line, this.inventory.getName());
    }

    public void setType(InventoryType inventoryType) {
        closeInventory();
        this.inventory = Bukkit.createInventory(this, inventoryType, this.inventory.getName());
    }

    public void closeInventory() {
        this.inventory.getViewers().forEach(HumanEntity::closeInventory);
    }

    protected abstract void buildGUI();

    public abstract void onInteract(InventoryInteractEvent inventoryInteractEvent);

    public abstract void onClick(InventoryClickEvent inventoryClickEvent);

    public abstract void onClose(InventoryCloseEvent inventoryCloseEvent);

    @Override
    public Inventory getInventory() {
        return inventory;
    }

    public Player getPlayerRelated() {
        return player;
    }

    public void setPlayerRelated(Player playerRelated) {
        this.player = playerRelated;
    }

    public void openGUI(Player player) {
        player.openInventory(inventory);
    }

    public HashMap<String, Object> getToTransmit() {
        return toTransmit;
    }

}
