/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  * Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *  * Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.spigot.holograms.utils;

import org.bukkit.entity.Player;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NMSUtil {

    private static Method sendPacket = null;
    private static Method a = null;
    private NMSUtil() {
    }

    public static Object getHandle(Object object) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return object.getClass().getMethod("getHandle").invoke(object);
    }

    public static void sendPacket(Player player, Object packet) {
        try {
            Object handle = getHandle(player);
            Object playerConnection = handle.getClass().getField("playerConnection").get(handle);
            if (sendPacket == null) {
                sendPacket = playerConnection.getClass().getMethod("sendPacket", NMSUtil.getNMSClass("Packet"));
            }
            sendPacket.invoke(playerConnection, packet);
        } catch (NoSuchMethodException | NoSuchFieldException | IllegalAccessException | InvocationTargetException ignored) {
        }
    }

    public static void a(Player player, Object packet) {
        try {
            Object handle = getHandle(player);
            Object playerConnection = handle.getClass().getField("playerConnection").get(handle);
            if (a == null) {
                a = playerConnection.getClass().getMethod("a", packet.getClass());
            }
            a.invoke(playerConnection, packet);
        } catch (NoSuchMethodException | NoSuchFieldException | IllegalAccessException | InvocationTargetException ignored) {
        }
    }

    /**
     * net.minecraft.server
     */
    public static Class<?> getNMSClass(String className) {
        try {
            return Class.forName("net.minecraft.server." + ServerVersion.getVersion() + "." + className);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException("An error occurred while finding NMS class.", ex);
        }
    }

    /**
     * org.bukkit.craftbukkit
     */
    public static Class<?> getOBCClass(String className) {
        try {
            return Class.forName("org.bukkit.craftbukkit." + ServerVersion.getVersion() + "." + className);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException("An error occurred while finding NMS class.", ex);
        }
    }

    public static class IChatBaseComponent {

        public static final Class<?> IChatBaseComponent = getNMSClass("IChatBaseComponent");
        private static final Logger logger = Logger.getLogger(IChatBaseComponent.class.getName());
        private static Method newIChatBaseComponent = null;

        static {
            try {
                newIChatBaseComponent = IChatBaseComponent.getDeclaredClasses()[0].getMethod("a", String.class);
            } catch (NoSuchMethodException e) {
                logger.log(Level.SEVERE, "An error occurred while initializing IChatBaseComponent.");
            }
        }

        public static Object of(String string) throws InvocationTargetException, IllegalAccessException {
            return newIChatBaseComponent.invoke(null, "{\"text\": \"" + string + "\"}");
        }

    }

}
