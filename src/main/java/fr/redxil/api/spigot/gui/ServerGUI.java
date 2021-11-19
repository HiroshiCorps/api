/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.spigot.gui;

import fr.redxil.api.common.API;
import fr.redxil.api.common.player.APIPlayer;
import fr.redxil.api.common.server.Server;
import fr.redxil.api.common.server.type.ServerType;
import fr.redxil.api.spigot.inventory.InventoryGUI;
import fr.redxil.api.spigot.itemstack.APIItemStack;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ServerGUI extends InventoryGUI {

    public ServerGUI(org.bukkit.entity.Player player) {
        super(player, "List Server:", 4, new HashMap<String, Object>() {{
            put("page", 1);
        }});
    }

    @Override
    public void buildGUI() {

        int totalServerAff = (getInventory().getSize() / 9 - 1) * 9;
        int page = (Integer) getToTransmit().get("page");

        int minList = totalServerAff * (page - 1);
        int maxList = totalServerAff * page - 1;

        List<Server> serverList = API.getInstance().getServerManager().getListServer();

        for (int invPos = 0, posList = minList; posList <= maxList && posList < serverList.size(); posList += 1, invPos += 1) {
            Server server = serverList.get(posList);
            if (server.getServerType() != ServerType.BUNGEE)
                getInventory().setItem(invPos, createServerItem(serverList.get(posList)));
            else
                invPos -= 1;
        }

        if (maxList < serverList.size() - 1) {
            getInventory().setItem(totalServerAff + 7, openPage(page + 1));
        }

        if (page > 1) {
            getInventory().setItem(totalServerAff + 2, openPage(page - 1));
        }

    }

    private org.bukkit.inventory.ItemStack createServerItem(Server server) {
        Material serverMaterial = Material.GRASS;

        ServerType serverType = server.getServerType();

        if (serverType == ServerType.GAME)
            serverMaterial = Material.DIAMOND_SWORD;
        else if (serverType == ServerType.HOST)
            serverMaterial = Material.BOOK;
        else if (serverType == ServerType.PRIVATE)
            serverMaterial = Material.DIAMOND_HELMET;
        else
            serverMaterial = Material.BARRIER;

        APIItemStack APIItemStack = new APIItemStack(serverMaterial, 1);
        ItemMeta itemMeta = APIItemStack.getItemMeta();

        itemMeta.setDisplayName("Server: " + server.getServerName());

        List<String> lore = new ArrayList<>();

        lore.add("Type: " + serverType.name());
        lore.add("Joueurs: " + server.getPlayerList().size() + "/" + server.getMaxPlayers());
        Server actualServer = API.getInstance().getServer();
        if (actualServer != null)
            if (actualServer.getServerName().equals(server.getServerName()))
                lore.add("CURRENT SERVER");

        itemMeta.setLore(lore);

        APIItemStack.setItemMeta(itemMeta);

        APIItemStack.setInvAction(((player, inventoryClickEvent) -> {
            APIPlayer apiPlayer = API.getInstance().getPlayerManager().getPlayer(player.getUniqueId());
            if (apiPlayer == null) return;
            apiPlayer.switchServer(server.getServerName());
        }));

        return APIItemStack;
    }

    private org.bukkit.inventory.ItemStack openPage(int targetPage) {

        APIItemStack APIItemStack = new APIItemStack(Material.BOOK, 1);
        ItemMeta itemMeta = APIItemStack.getItemMeta();

        itemMeta.setDisplayName("Page: " + targetPage);

        APIItemStack.setItemMeta(itemMeta);

        APIItemStack.setInvAction(((player, inventoryClickEvent) -> {
            getToTransmit().remove("page");
            getToTransmit().put("page", targetPage);
            getInventory().clear();
            buildGUI();
        }));

        return APIItemStack;

    }

    @Override
    public void onInteract(InventoryInteractEvent inventoryInteractEvent) {
        inventoryInteractEvent.setCancelled(true);
    }

    @Override
    public void onClick(InventoryClickEvent inventoryClickEvent) {
        inventoryClickEvent.setCancelled(true);
    }

    @Override
    public void onClose(InventoryCloseEvent inventoryCloseEvent) {

    }
}
