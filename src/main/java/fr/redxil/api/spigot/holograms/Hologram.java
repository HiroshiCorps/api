/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  * Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *  * Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.spigot.holograms;

import fr.redxil.api.spigot.holograms.utils.NMSUtil;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class Hologram {

    private static final Class<?> CraftWorld = NMSUtil.getOBCClass("CraftWorld"),
            World = NMSUtil.getNMSClass("World"),
            EntityArmorStand = NMSUtil.getNMSClass("EntityArmorStand"),
            PacketPlayOutSpawnEntityLiving = NMSUtil.getNMSClass("PacketPlayOutSpawnEntityLiving"),
            PacketPlayOutEntityDestroy = NMSUtil.getNMSClass("PacketPlayOutEntityDestroy"),
            PacketPlayOutEntityMetadata = NMSUtil.getNMSClass("PacketPlayOutEntityMetadata"),
            PacketPlayOutEntityTeleport = NMSUtil.getNMSClass("PacketPlayOutEntityTeleport"),
            Entity = NMSUtil.getNMSClass("Entity"),
            DataWatcher = NMSUtil.getNMSClass("DataWatcher"),
            EntityLiving = NMSUtil.getNMSClass("EntityLiving");
    private static Constructor<?> EntityArmorStandConstructor = null,
            PacketPlayOutSpawnEntityLivingConstructor = null,
            PacketPlayOutEntityDestroyConstructor = null,
            PacketPlayOutEntityMetadataConstructor = null,
            PacketPlayOutEntityTeleportConstructor = null;
    private static Method setInvisible = null, setCustomNameVisible = null,
            setCustomName = null, getId = null, getDataWatcher = null,
            setLocation = null;

    static {
        try {
            EntityArmorStandConstructor = EntityArmorStand.getConstructor(World, double.class, double.class, double.class);
            PacketPlayOutSpawnEntityLivingConstructor = PacketPlayOutSpawnEntityLiving.getConstructor(EntityLiving);
            PacketPlayOutEntityDestroyConstructor = PacketPlayOutEntityDestroy.getConstructor(int[].class);
            PacketPlayOutEntityMetadataConstructor = PacketPlayOutEntityMetadata.getConstructor(int.class, DataWatcher, boolean.class);
            PacketPlayOutEntityTeleportConstructor = PacketPlayOutEntityTeleport.getConstructor(Entity);
            setInvisible = EntityArmorStand.getMethod("setInvisible", boolean.class);
            setCustomNameVisible = EntityArmorStand.getMethod("setCustomNameVisible", boolean.class);
            setLocation = Entity.getMethod("setLocation", double.class, double.class, double.class, float.class, float.class);
            try {
                setCustomName = EntityArmorStand.getMethod("setCustomName", String.class);
            } catch (NoSuchMethodException x) {
                setCustomName = EntityArmorStand.getMethod("setCustomName", NMSUtil.IChatBaseComponent.IChatBaseComponent);
            }
            getId = EntityArmorStand.getMethod("getId");
            getDataWatcher = Entity.getMethod("getDataWatcher");
        } catch (NoSuchMethodException ignored) {
        }
    }

    private final Object armorStand;
    private final int id;
    private final Object packetPlayOutSpawnEntityLiving;
    private final Object packetPlayOutEntityDestroy;
    private final Set<Player> viewers = new HashSet<>();
    private Location location;
    private String text;

    public Hologram(Location location, String text) {
        location = location.clone().add(0, -1.65D, 0);
        this.location = location;
        this.text = text;
        try {
            this.armorStand = EntityArmorStandConstructor.newInstance(NMSUtil.getHandle(CraftWorld.cast(location.getWorld())), location.getX(), location.getY(), location.getZ());
            setInvisible.invoke(armorStand, true);
            setCustomNameVisible.invoke(armorStand, true);
            if (setCustomName.getParameterTypes()[0].equals(String.class)) {
                setCustomName.invoke(armorStand, text);
            } else {
                setCustomName.invoke(armorStand, NMSUtil.IChatBaseComponent.of(text));
            }
            this.id = (int) getId.invoke(armorStand);
            this.packetPlayOutSpawnEntityLiving = PacketPlayOutSpawnEntityLivingConstructor.newInstance(armorStand);
            this.packetPlayOutEntityDestroy = PacketPlayOutEntityDestroyConstructor.newInstance((Object) new int[]{id});
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
            throw new RuntimeException("An error occurred while creating the hologram.", e);
        }
    }

    public void display(Player... players) {
        try {
            for (Player player : players) {
                if (viewers.add(player)) {
                    NMSUtil.sendPacket(player, packetPlayOutSpawnEntityLiving);
                    updateMetadata(player);
                }
            }
        } catch (InvocationTargetException | IllegalAccessException | InstantiationException ignored) {
        }
    }

    public void hide(Player... players) {
        for (Player player : players) {
            if (viewers.remove(player)) {
                NMSUtil.sendPacket(player, packetPlayOutEntityDestroy);
            }
        }
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        try {
            setLocation.invoke(armorStand, location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
            this.location = location;
            updateLocation();
        } catch (InvocationTargetException | IllegalAccessException | InstantiationException ignored) {
        }
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        try {
            if (setCustomName.getParameterTypes()[0].equals(String.class)) {
                setCustomName.invoke(armorStand, text);
            } else {
                setCustomName.invoke(armorStand, NMSUtil.IChatBaseComponent.of(text));
            }
            this.text = text;
            updateMetadata();
        } catch (InvocationTargetException | IllegalAccessException | InstantiationException ignored) {
        }
    }

    private void updateMetadata() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Object packet = PacketPlayOutEntityMetadataConstructor.newInstance(id, getDataWatcher.invoke(armorStand), true);
        for (Player player : viewers) {
            NMSUtil.sendPacket(player, packet);
        }
    }

    private void updateMetadata(Player player) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        NMSUtil.sendPacket(player, PacketPlayOutEntityMetadataConstructor.newInstance(id, getDataWatcher.invoke(armorStand), true));
    }

    private void updateLocation() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        for (Player player : viewers) {
            NMSUtil.sendPacket(player, PacketPlayOutEntityTeleportConstructor.newInstance(armorStand));
        }
    }

}
