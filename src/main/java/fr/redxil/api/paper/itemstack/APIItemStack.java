/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.paper.itemstack;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.apache.commons.codec.binary.Base64;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.material.MaterialData;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class APIItemStack extends org.bukkit.inventory.ItemStack {

    private GlobalAction action = null;
    private InvItemAction invInteractAction = null;
    private OFFInvItemAction offInvInteractAction = null;

    public APIItemStack(org.bukkit.inventory.ItemStack item, String displayName, String lore) {
        super(item);
    }

    public APIItemStack(org.bukkit.inventory.ItemStack item, String displayName) {
        super(item);
    }

    public APIItemStack(org.bukkit.inventory.ItemStack item) {
        super(item);
    }

    public APIItemStack(Material material, int amount, byte data) {
        super(material, amount, data);
    }

    public APIItemStack(Material material, int amount) {
        super(material, amount);
    }

    public APIItemStack(Material material) {
        super(material);
    }

    public static APIItemStack getBackGuiItem() {
        return new APIItemStack(Material.ARROW).setName("§aRetour");
    }

    public static APIItemStack getCloseGuiItem() {
        return new APIItemStack(Material.BARRIER).setName("§cFermer");
    }

    public static APIItemStack getPane(int data) {
        return new APIItemStack(Material.STAINED_GLASS_PANE).setData((byte) data);
    }

    public static org.bukkit.inventory.ItemStack getSkull(String url) {
        org.bukkit.inventory.ItemStack head = new org.bukkit.inventory.ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        if (url.isEmpty()) return head;

        SkullMeta headMeta = (SkullMeta) head.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        byte[] encodedData = Base64.encodeBase64(String.format("{textures:{SKIN:{url:\"%s\"}}}", url).getBytes());
        profile.getProperties().put("textures", new Property("textures", new String(encodedData)));
        Field profileField = null;
        try {
            profileField = headMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(headMeta, profile);
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e1) {
            e1.printStackTrace();
        }
        head.setItemMeta(headMeta);
        return head;
    }

    public APIItemStack setLore(String lore) {
        if (lore == null || lore.equals("")) {
            return this;
        }

        ItemMeta meta = this.getItemMeta();

        // Remove attributes
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);

        // Set Lore on ItemMeta
        lore = ChatColor.translateAlternateColorCodes('&', lore);
        String[] loreString = lore.split("\n");
        meta.setLore(new ArrayList<>(Arrays.asList(loreString)));
        this.setItemMeta(meta);

        return this;
    }

    public APIItemStack setName(String displayName) {
        if (displayName == null || displayName.equals("")) {
            return this;
        }

        ItemMeta meta = this.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', displayName));
        this.setItemMeta(meta);

        return this;
    }

    public APIItemStack setLeatherColor(Color color) {
        LeatherArmorMeta lch = (LeatherArmorMeta) this.getItemMeta();
        lch.setColor(color);
        this.setItemMeta(lch);
        return this;
    }

    public APIItemStack setLoreAction(String actionName) {
        if (actionName.startsWith("§")) {
            this.addLineToLore(null, actionName);
        } else {
            this.addLineToLore(null, "§6§l» §eCliquez pour " + actionName + " !");
        }
        return this;
    }

    public APIItemStack setData(byte data) {
        MaterialData materialData = this.getData();
        materialData.setData(data);
        this.setData(materialData);
        return this;
    }

    public APIItemStack setGlow(boolean enabled) {
        if (enabled) {
            this.setGlow();
        }
        return this;
    }

    public APIItemStack addItemEnchantment(Enchantment enchantment, int integer) {
        this.addEnchantment(enchantment, integer);
        return this;
    }

    public APIItemStack setGlow() {
        this.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 0);
        ItemMeta meta = this.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        this.setItemMeta(meta);
        return this;
    }

    private void addLineToLore(String... lines) {
        ItemMeta meta = this.getItemMeta();
        List<String> lore = meta.getLore();
        if (lore == null) {
            lore = new ArrayList<>();
        }
        int i = -1;
        for (String line : lines) {
            ++i;
            if (i == 0 && line == null && !hasAlreadyLore()) {
                continue;
            }
            lore.add(line == null ? "" : line);
        }
        meta.setLore(lore);
        this.setItemMeta(meta);
    }

    private boolean hasAlreadyLore() {
        ItemMeta meta = this.getItemMeta();
        if (meta == null) {
            return false;
        }
        List<String> lore = meta.getLore();
        return lore != null && lore.size() > 0;
    }

    public GlobalAction getGlobalAction() {
        return action;
    }

    public APIItemStack setGlobalAction(GlobalAction action) {
        this.action = action;
        return this;
    }

    public InvItemAction getInvAction() {
        return invInteractAction;
    }

    public APIItemStack setInvAction(InvItemAction action) {
        this.invInteractAction = action;
        return this;
    }

    public OFFInvItemAction getOFFInvAction() {
        return offInvInteractAction;
    }

    public APIItemStack setOFFInvAction(OFFInvItemAction action) {
        this.offInvInteractAction = action;
        return this;
    }

}
