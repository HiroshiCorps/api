/* Copyright (C) Hiroshi - Ibrahim - All Rights Reserved
 * Unauthorized copying or modification of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Ibrahim for Hiroshi, braimsou@gmail.com - contact@hiroshimc.net - 2021
 */

package fr.redxil.api.paper.tags;

import org.bukkit.entity.Player;

public interface TagScore {

    Player getPlayer();

    int getScore();

    void setScore(int score);
}
