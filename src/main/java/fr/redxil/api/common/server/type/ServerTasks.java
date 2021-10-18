/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  * Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *  * Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.server.type;

import java.util.Arrays;
import java.util.List;

public enum ServerTasks {

    PROXY("Proxy-%id%", TasksType.BUNGEECORD),
    LOBBY("Lobby-%id%", TasksType.MINECRAFT_SERVER),
    HOST("host-%id%", TasksType.MINECRAFT_SERVER),
    UNKNOWN(null, TasksType.MINECRAFT_SERVER);

    final String name;
    final TasksType tasksType;

    ServerTasks(String name, TasksType tasksType) {
        this.name = name;
        this.tasksType = tasksType;
    }

    public static ServerTasks getTasksByService(String name) {
        for (ServerTasks serverTasks : ServerTasks.values()) {
            if (serverTasks == ServerTasks.UNKNOWN) {
                continue;
            }

            if (serverTasks.getStaticName().equalsIgnoreCase(name.replaceAll(getID(name), "").replaceAll("-", ""))) {
                return serverTasks;
            }
        }

        return null;
    }

    public static ServerTasks getTasks(String name) {
        return ServerTasks.valueOf(name.toUpperCase());
    }

    public static String getID(String name) {
        StringBuilder id = new StringBuilder();
        List<Character> numbers = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
        for (char cha : name.toCharArray()) {
            if (numbers.contains(cha)) id.append(cha);
        }

        return id.toString();
    }

    public String getName() {
        return name;
    }

    public String getStaticName() {
        return name.replaceAll("-%id%", "");
    }

    public TasksType getTasksType() {
        return tasksType;
    }

    private enum TasksType {

        MINECRAFT_SERVER,
        BUNGEECORD;

    }

}
