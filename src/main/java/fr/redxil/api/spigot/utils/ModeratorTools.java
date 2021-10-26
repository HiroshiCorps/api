/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.spigot.utils;

import fr.redxil.api.common.API;
import fr.redxil.api.common.moderators.APIPlayerModerator;
import fr.redxil.api.common.player.APIPlayer;
import fr.redxil.api.common.utils.TextUtils;
import fr.redxil.api.spigot.gui.SanctionGUI;
import fr.redxil.api.spigot.gui.ServerGUI;
import fr.redxil.api.spigot.itemstack.APIItemStack;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.block.Action;

import java.util.ArrayList;
import java.util.List;

public enum ModeratorTools {

    RANDOM_TP(0, new APIItemStack(Material.COMPASS).setName("§6Téléportation aléatoire §7(Clique droit)").setOFFInvAction(
            (player, event) -> {
                event.setCancelled(true);
                if (event.getPlayer().hasCooldown(event.getItem().getType())) return;
                event.getPlayer().setCooldown(event.getItem().getType(), 20);
                APIPlayerModerator playerMod = API.get().getModeratorManager().getModerator(player.getUniqueId());
                if (playerMod == null) return;
                String targetName = playerMod.getCible();

                if (targetName == null) {
                    pickRandom(playerMod);
                    return;
                }

                if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                    pickRandom(playerMod);
                    return;
                }

                org.bukkit.entity.Player target = Bukkit.getPlayer(targetName);
                if (target == null) {
                    event.getPlayer().sendMessage(TextUtils.getPrefix("CIBLE") + "Votre cible: " + targetName + " semble être déconnecté");
                    return;
                }

                event.getPlayer().sendMessage(TextUtils.getPrefix("CIBLE") + "Lancement du voyage intersidéral vers: " + targetName);
                event.getPlayer().teleport(target);
            }
    )),

    INFORMATION(1, new APIItemStack(Material.PAPER).setName("§bInformations §7(Clique droit)").setOFFInvAction((player, event) -> {
        event.setCancelled(true);
        if (event.getPlayer().hasCooldown(event.getItem().getType())) return;
        event.getPlayer().setCooldown(event.getItem().getType(), 20);
        org.bukkit.entity.Player target = Targeter.getTargetPlayer(event.getPlayer());
        if (target == null) {
            event.getPlayer().sendMessage(ChatColor.RED + "S'il vous plait, veillez à viser un joueur");
            return;
        }
        player.performCommand("info " + target.getName());
    })),

    HISTORY_SANCTION(2, new APIItemStack(Material.ENCHANTED_BOOK).setName("§dHistorique sanctions §7(Clique droit)").setOFFInvAction((player, event) -> {
        event.setCancelled(true);
        if (event.getPlayer().hasCooldown(event.getItem().getType())) return;
        event.getPlayer().setCooldown(event.getItem().getType(), 20);
        org.bukkit.entity.Player target = Targeter.getTargetPlayer(event.getPlayer());
        if (target == null) {
            event.getPlayer().sendMessage(ChatColor.RED + "S'il vous plait, veillez à viser un joueur");
            return;
        }
        new SanctionGUI(target).openGUI(event.getPlayer());
    })),

    ANTI_KB(3, new APIItemStack(Material.STICK).setName("§6Anti-KB").addItemEnchantment(Enchantment.KNOCKBACK, 2)),

    SWITCH_SERVER(4, new APIItemStack(Material.SKULL_ITEM).setName("§aChanger de serveur").setOFFInvAction((player, event) -> {
        event.setCancelled(true);
        if (event.getPlayer().hasCooldown(event.getItem().getType())) return;
        event.getPlayer().setCooldown(event.getItem().getType(), 20);
        new ServerGUI(player).openGUI(player);
    })),

    ANTI_CHEAT(6, new APIItemStack(Material.ENCHANTMENT_TABLE).setName("§cAntiCheat §7(Clique droit)")),

    INVENTORY(7, new APIItemStack(Material.CHEST).setName("§eInventaires §7(Clique droit)").setOFFInvAction(
            (player, event) -> {
                event.setCancelled(true);
                if (event.getPlayer().hasCooldown(event.getItem().getType())) return;
                event.getPlayer().setCooldown(event.getItem().getType(), 20);
                org.bukkit.entity.Player target = Targeter.getTargetPlayer(player);
                if (target == null) {
                    player.sendMessage(ChatColor.RED + "S'il vous plait, veillez à viser un joueur");
                    return;
                }
                player.openInventory(target.getInventory());
            }
    )),

    FREEZE(8, new APIItemStack(Material.PACKED_ICE).setName("§3Freeze le joueur §7(Clique droit)").setOFFInvAction(
            (player, event) -> {
                event.setCancelled(true);
                if (event.getPlayer().hasCooldown(event.getItem().getType())) return;
                event.getPlayer().setCooldown(event.getItem().getType(), 20);
                org.bukkit.entity.Player target = Targeter.getTargetPlayer(event.getPlayer());
                if (target == null) {
                    event.getPlayer().sendMessage(ChatColor.RED + "S'il vous plait, veillez à viser un joueur");
                    return;
                }
                event.getPlayer().performCommand("freeze " + target.getName());
            }
    ));

    private final APIItemStack APIItemStack;
    private final int slot;

    ModeratorTools(int slot, APIItemStack APIItemStack) {
        this.APIItemStack = APIItemStack;
        this.slot = slot;
    }

    public static void setModeratorInventory(org.bukkit.entity.Player player) {
        player.getInventory().clear();
        for (ModeratorTools moderatorTools : ModeratorTools.values()) {
            player.getInventory().setItem(moderatorTools.getSlot(), moderatorTools.getItemStack());
        }
    }

    public static void pickRandom(APIPlayerModerator mod) {

        org.bukkit.entity.Player modPlayer = Bukkit.getPlayer(mod.getUUID());
        List<org.bukkit.entity.Player> players = new ArrayList<>();

        Bukkit.getOnlinePlayers().forEach((player) -> {
            if (!API.get().getModeratorManager().isModerator(player.getUniqueId()))
                players.add(player);
        });

        if (players.isEmpty()) {
            modPlayer.sendMessage(TextUtils.getPrefix("CIBLE") + "Aucune cible disponible sur ce server");
            return;
        }

        int rand = Double.valueOf(Math.random() * (players.size())).intValue();
        org.bukkit.entity.Player target = players.get(rand);
        APIPlayer apiPlayer = API.get().getPlayerManager().getPlayer(target.getUniqueId());

        mod.setCible(apiPlayer.getName());
        modPlayer.sendMessage(TextUtils.getPrefix("CIBLE") + "Vous avez une nouvelle cible: " + apiPlayer.getName());
        modPlayer.teleport(target);

    }

    public APIItemStack getItemStack() {
        return APIItemStack;
    }

    public int getSlot() {
        return slot;
    }

}
