/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.paper.holograms;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class HologramPacket {

    private static final double ABS = 0.3D;
    private static final String path;
    private static final String version;
    /*
     * Cache for getPacket()-Method
     */
    private static Class<?> armorStand;
    private static Class<?> worldClass;
    private static Class<?> nmsEntity;
    private static Class<?> craftWorld;
    private static Class<?> packetClass;
    private static Class<?> entityLivingClass;
    private static Constructor<?> armorStandConstructor;
    /*
     * Cache for getDestroyPacket()-Method
     */
    private static Class<?> destroyPacketClass;
    private static Constructor<?> destroyPacketConstructor;
    /*
     * Cache for sendPacket()-Method
     */
    private static Class<?> nmsPacket;

    static {
        path = Bukkit.getServer().getClass().getPackage().getName();
        version = path.substring(path.lastIndexOf(".") + 1);

        try {
            armorStand = Class.forName("net.minecraft.server." + version + ".EntityArmorStand");
            worldClass = Class.forName("net.minecraft.server." + version + ".World");
            nmsEntity = Class.forName("net.minecraft.server." + version + ".Entity");
            craftWorld = Class.forName("org.bukkit.craftbukkit." + version + ".CraftWorld");
            packetClass = Class.forName("net.minecraft.server." + version + ".PacketPlayOutSpawnEntityLiving");
            entityLivingClass = Class.forName("net.minecraft.server." + version + ".EntityLiving");
            armorStandConstructor = armorStand.getConstructor(worldClass);

            destroyPacketClass = Class.forName("net.minecraft.server." + version + ".PacketPlayOutEntityDestroy");
            destroyPacketConstructor = destroyPacketClass.getConstructor(int[].class);

            nmsPacket = Class.forName("net.minecraft.server." + version + ".Packet");
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException ex) {
            System.err.println("Error - Classes not initialized!");
            ex.printStackTrace();
        }
    }

    private final List<Object> destroyCache;
    private final List<Object> spawnCache;
    private final List<UUID> players;
    private final List<String> lines;
    private final Location loc;

    /**
     * Create a new hologram
     * Note: The constructor will automatically initialize the internal cache; it may take some millis
     *
     * @param loc   The location where this hologram is shown
     * @param lines The text-lines, from top to bottom, farbcodes are possible
     */
    public HologramPacket(Location loc, String... lines) {
        this(loc, Arrays.asList(lines));
    }

    /**
     * Create a new hologram
     * Note: The constructor will automatically initialize the internal cache; it may take some millis
     *
     * @param loc   The location where this hologram is shown
     * @param lines The text-lines, from top to bottom, farbcodes are possible
     */
    public HologramPacket(Location loc, List<String> lines) {
        this.lines = lines;
        this.loc = loc;
        this.players = new ArrayList<>();
        this.spawnCache = new ArrayList<>();
        this.destroyCache = new ArrayList<>();

        // Init
        Location displayLoc = loc.clone().add(0, (ABS * lines.size()), 0); // - 1.97D
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i) != null) {
                Object packet = this.getPacket(this.loc.getWorld(), displayLoc.getX(), displayLoc.getY(), displayLoc.getZ(), this.lines.get(i));
                this.spawnCache.add(packet);
                try {
                    Field field = packetClass.getDeclaredField("a");
                    field.setAccessible(true);
                    this.destroyCache.add(this.getDestroyPacket((int) field.get(packet)));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            displayLoc.add(0, ABS * (-1), 0);
        }
    }

    /**
     * Shows this hologram to the given player
     *
     * @param p The player who will see this hologram at the location specified by calling the constructor
     * @return true, if the action was successful, else false
     */
    public boolean display(Player p) {
        for (int i = 0; i < spawnCache.size(); i++) {
            this.sendPacket(p, spawnCache.get(i));
        }

        this.players.add(p.getUniqueId());
        return true;
    }

    /**
     * Removes this hologram from the players view
     *
     * @param p The target player
     * @return true, if the action was successful, else false (including the try to remove a non-existing hologram)
     */
    public boolean destroy(Player p) {
        if (this.players.contains(p.getUniqueId())) {
            for (int i = 0; i < this.destroyCache.size(); i++) {
                this.sendPacket(p, this.destroyCache.get(i));
            }
            this.players.remove(p.getUniqueId());
            return true;
        }
        return false;
    }

    private Object getPacket(World w, double x, double y, double z, String text) {
        try {
            Object craftWorldObj = craftWorld.cast(w);
            Method getHandleMethod = craftWorldObj.getClass().getMethod("getHandle");
            Object entityObject = armorStandConstructor.newInstance(getHandleMethod.invoke(craftWorldObj));
            Method setCustomName = entityObject.getClass().getMethod("setCustomName", String.class);
            setCustomName.invoke(entityObject, text);
            Method setCustomNameVisible = nmsEntity.getMethod("setCustomNameVisible", boolean.class);
            setCustomNameVisible.invoke(entityObject, true);
            Method setGravity = entityObject.getClass().getMethod("setGravity", boolean.class);
            setGravity.invoke(entityObject, false);
            Method setLocation = entityObject.getClass().getMethod("setLocation", double.class, double.class, double.class, float.class, float.class);
            setLocation.invoke(entityObject, x, y, z, 0.0F, 0.0F);
            Method setInvisible = entityObject.getClass().getMethod("setInvisible", boolean.class);
            setInvisible.invoke(entityObject, true);
            Method setMarker = entityObject.getClass().getMethod("n", boolean.class);
            setMarker.invoke(entityObject, true);
            Constructor<?> cw = packetClass.getConstructor(entityLivingClass);
            Object packetObject = cw.newInstance(entityObject);
            return packetObject;
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Object getDestroyPacket(int... id) {
        try {
            return destroyPacketConstructor.newInstance(id);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void sendPacket(Player p, Object packet) {
        try {
            Method getHandle = p.getClass().getMethod("getHandle");
            Object entityPlayer = getHandle.invoke(p);
            Object pConnection = entityPlayer.getClass().getField("playerConnection").get(entityPlayer);
            Method sendMethod = pConnection.getClass().getMethod("sendPacket", nmsPacket);
            sendMethod.invoke(pConnection, packet);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}