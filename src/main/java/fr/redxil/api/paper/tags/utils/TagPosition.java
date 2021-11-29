/* Copyright (C) Hiroshi - Ibrahim - All Rights Reserved
 * Unauthorized copying or modification of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Ibrahim for Hiroshi, braimsou@gmail.com - contact@hiroshimc.net - 2021
 */
/*
 * Class get from Unknown - Unknown
 * Modified by Ibrahim for Hiroshi
 * Contact: braimsou@gmail.com - contact@hiroshimc.net - 2021
 */

package fr.redxil.api.paper.tags.utils;

import org.bukkit.entity.Player;

public class TagPosition {

    private static final char[] entries = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private static final String[] cache = new String[81];

    static {
        for (int i = 0; i <= 80; i++) {
            cache[i] = getPositionAt(i);
        }
    }

    public static String getPositionAt(Player player, int index) {
        return getPositionAt(index) + "-" + player.getEntityId();
    }

    public static String getPositionAt(int index) {
        String result = cache[index];
        if (result == null) {
            final StringBuilder builder = new StringBuilder();
            final double size = index / 26.0;
            for (int i = 0; i < Math.floor(size); ++i) {
                builder.append(entries[25]);
            }
            result = builder.append(entries[(int) Math.round(26.0 * (size - Math.floor(size)))]).toString();
        }

        return result;
    }
}
