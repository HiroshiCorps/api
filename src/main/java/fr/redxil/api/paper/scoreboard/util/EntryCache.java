/* Copyright (C) Hiroshi - Ibrahim - All Rights Reserved
 * Unauthorized copying or modification of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Ibrahim for Hiroshi, braimsou@gmail.com - contact@hiroshimc.net - 2021
 */

package fr.redxil.api.paper.scoreboard.util;

import org.bukkit.ChatColor;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class EntryCache {

    private static final Map<Integer, String> playerEntries = new HashMap<>();

    public static String getFakeName(int line) {
        ChatColor[] colors = ChatColor.values();
        String name = playerEntries.get(line);
        if (name == null) {
            while (name == null) {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < 5; i++) {
                    builder.append(colors[ThreadLocalRandom.current().nextInt(colors.length)]);
                }
                builder.append(ChatColor.RESET);
                String result = builder.toString();
                if (!playerEntries.containsValue(result)) {
                    name = result;
                }
            }

            playerEntries.put(line, name);
        }

        return name;
    }
}
