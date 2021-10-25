/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  * Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *  * Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.spigot.gui;

import fr.redxil.api.common.API;
import fr.redxil.api.common.player.APIPlayer;
import fr.redxil.api.common.player.data.SanctionInfo;
import fr.redxil.api.common.time.DateUtility;
import fr.redxil.api.common.utils.SanctionType;
import fr.redxil.api.spigot.inventory.InventoryGUI;
import fr.redxil.api.spigot.itemstack.APIItemStack;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class SanctionGUI extends InventoryGUI {

    public SanctionGUI(org.bukkit.entity.Player player) {
        super(player, "Sanctions: ", 3);
    }

    @Override
    public void buildGUI() {

        APIPlayer apiPlayer = API.get().getPlayerManager().getPlayer(getPlayerRelated().getUniqueId());

        List<SanctionInfo> bans = apiPlayer.getSanction(SanctionType.BAN);
        List<SanctionInfo> mutes = apiPlayer.getSanction(SanctionType.MUTE);
        List<SanctionInfo> kicks = apiPlayer.getSanction(SanctionType.KICK);
        List<SanctionInfo> warns = apiPlayer.getSanction(SanctionType.WARN);

        APIItemStack totalItem = new APIItemStack(Material.BOOK, 1);
        ItemMeta totalItemMeta = totalItem.getItemMeta();

        totalItemMeta.setDisplayName("Totals sanctions");
        List<String> totalLore = new ArrayList<>();
        totalLore.add("Total: " + (bans.size() + mutes.size() + kicks.size()));

        totalItemMeta.setLore(totalLore);
        totalItem.setItemMeta(totalItemMeta);

        totalItem.setInvAction(((player, inventoryClickEvent) -> player.performCommand("info " + getPlayerRelated().getName())));

        getInventory().setItem(4, totalItem);


        APIItemStack banItem = new APIItemStack(Material.BARRIER, 1);
        ItemMeta banMeta = banItem.getItemMeta();

        banMeta.setDisplayName("Bans");
        List<String> lore = new ArrayList<>();
        lore.add("Total: " + bans.size());
        if (!bans.isEmpty())
            lore.add("Last One: " + DateUtility.getMessage(bans.get(0).getSanctionDateTS()));

        banMeta.setLore(lore);
        banItem.setItemMeta(banMeta);

        banItem.setInvAction(((player, inventoryClickEvent) -> player.performCommand("info " + getPlayerRelated().getName() + " ban")));

        getInventory().setItem(12, banItem);


        APIItemStack muteItem = new APIItemStack(Material.JUKEBOX, 1);
        ItemMeta muteMeta = muteItem.getItemMeta();

        muteMeta.setDisplayName("Mutes");
        List<String> muteLore = new ArrayList<>();
        muteLore.add("Total: " + mutes.size());
        if (!mutes.isEmpty())
            muteLore.add("Last One: " + DateUtility.getMessage(mutes.get(0).getSanctionDateTS()));

        muteMeta.setLore(muteLore);
        muteItem.setItemMeta(muteMeta);

        muteItem.setInvAction(((player, inventoryClickEvent) -> player.performCommand("info " + getPlayerRelated().getName() + " mute")));

        getInventory().setItem(13, muteItem);


        APIItemStack kickItem = new APIItemStack(Material.LEATHER_BOOTS, 1);
        ItemMeta kickMeta = kickItem.getItemMeta();

        kickMeta.setDisplayName("Kicks");
        List<String> kickLore = new ArrayList<>();
        kickLore.add("Total: " + kicks.size());
        if (!kicks.isEmpty())
            kickLore.add("Last One: " + DateUtility.getMessage(kicks.get(0).getSanctionDateTS()));
        kickMeta.setLore(kickLore);
        kickItem.setItemMeta(kickMeta);

        kickItem.setInvAction(((player, inventoryClickEvent) -> player.performCommand("info " + getPlayerRelated().getName() + " kick")));
        getInventory().setItem(14, kickItem);


        APIItemStack warnItem = new APIItemStack(Material.LEATHER_BOOTS, 1);
        ItemMeta warnMeta = warnItem.getItemMeta();

        warnMeta.setDisplayName("Warns");
        List<String> warnLore = new ArrayList<>();
        warnLore.add("Total: " + warns.size());
        if (!warns.isEmpty())
            warnLore.add("Last One: " + DateUtility.getMessage(warns.get(0).getSanctionDateTS()));
        warnMeta.setLore(warnLore);
        warnItem.setItemMeta(warnMeta);

        warnItem.setInvAction(((player, inventoryClickEvent) -> player.performCommand("info " + getPlayerRelated().getName() + " warn")));

        getInventory().setItem(14, warnItem);

    }

    @Override
    public void onInteract(InventoryInteractEvent inventoryInteractEvent) {
        inventoryInteractEvent.setCancelled(true);
    }

    @Override
    public void onClick(InventoryClickEvent inventoryClickEvent) {

    }

    @Override
    public void onClose(InventoryCloseEvent inventoryCloseEvent) {

    }

}
