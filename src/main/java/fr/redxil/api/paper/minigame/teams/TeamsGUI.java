/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.paper.minigame.teams;

import fr.redxil.api.common.game.team.Team;
import fr.redxil.api.common.game.team.TeamManager;
import fr.redxil.api.paper.inventory.InventoryGUI;
import fr.redxil.api.paper.itemstack.APIItemStack;
import fr.redxil.api.paper.minigame.GameBuilder;
import fr.redxil.api.paper.utils.ObjectColor;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;

import java.util.List;
import java.util.UUID;

public class TeamsGUI extends InventoryGUI {

    private final TeamManager teamManager;

    private final int page;
    private final int limitPage;

    private final List<Team> pageTeams;

    public TeamsGUI(Player player, int page) {
        super(player, "Sélectionner une équipe", 6);

        this.page = page;

        this.teamManager = GameBuilder.getGameBuilder().getTeamManager();

        this.limitPage = teamManager.getTeamList().size() / 28;

        this.pageTeams = teamManager.getTeamOrderByRemainingPlace();
    }

    @Override
    public void buildGUI() {

        if (page >= limitPage) {
            getPlayerRelated().closeInventory();
        }

        int[] slots = {10, 11, 12, 13, 14, 15, 16, 19, 20, 21, 22, 23, 24, 25, 28, 29, 30, 31, 32, 33, 34};

        int slot = 0;

        for (Team team : pageTeams) {

            StringBuilder lore = new StringBuilder();
            lore.append("§8❙ §7Membres de l'équipe\n");

            int place = team.getMaxPlayers();

            for (UUID uuid : team.getListPlayerUUID()) {
                if (Bukkit.getPlayer(uuid) != null) {
                    lore.append("§8- §7§o").append(Bukkit.getPlayer(uuid).getName()).append("\n");
                } else {
                    lore.append("§8- §cErreur de chargement\n");
                }
            }

            place = place - team.getPlayers().size();

            for (int i = 0; i < place; i++) {
                lore.append("§8- §7§oPlace disponible\n");
            }

            lore.append("\n§8» §eClique pour rejoindre");

            APIItemStack apiItemStack = new APIItemStack(Material.BANNER, 1);
            fr.redxil.api.common.message.Color teamColor = team.getColor();
            ObjectColor.setColor(apiItemStack, DyeColor.getByColor(Color.fromRGB(teamColor.getRed(), teamColor.getGreen(), teamColor.getBlue())));
            apiItemStack.setName(team.getDisplayName());
            apiItemStack.setLore(lore.toString());
            apiItemStack.setInvAction((p, event) -> {

                event.setCancelled(true);

                if (teamManager.hasTeam(p.getUniqueId()) && teamManager.getPlayerTeam(p.getUniqueId()).getName().equals(team.getName())) {
                    teamManager.getPlayerTeam(p.getUniqueId()).removePlayer(p.getUniqueId());

                    p.setDisplayName("§7" + p.getName());
                    p.setPlayerListName("§7" + p.getName());

                    p.sendMessage("§cVous avez quitté l'équipe : " + team.getName());
                    p.closeInventory();
                    return;
                }

                team.addPlayer(p.getUniqueId());

                p.closeInventory();
                p.sendMessage("§aVous avez rejoins l'équipe : " + team.getName());
            });

            getInventory().setItem(slots[slot], apiItemStack);

            slot++;


        }
    }

    @Override
    public void onInteract(InventoryInteractEvent inventoryInteractEvent) {

    }

    @Override
    public void onClick(InventoryClickEvent inventoryClickEvent) {

    }

    @Override
    public void onClose(InventoryCloseEvent inventoryCloseEvent) {

    }

}
