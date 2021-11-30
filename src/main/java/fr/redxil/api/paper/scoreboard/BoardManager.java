/* Copyright (C) Hiroshi - Ibrahim - All Rights Reserved
 * Unauthorized copying or modification of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Ibrahim for Hiroshi, braimsou@gmail.com - contact@hiroshimc.net - 2021
 */

package fr.redxil.api.paper.scoreboard;

import org.bukkit.entity.Player;

public interface BoardManager {

    void setProvider(Player player, BoardProvider provider);

    BoardProvider getProvider(Player player);

    void removeProvider(Player player);

    void updateLine(BoardProvider provider, int line);

    void updateTitle(BoardProvider provider);
}
