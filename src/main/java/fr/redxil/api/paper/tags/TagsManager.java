/* Copyright (C) Hiroshi - Ibrahim - All Rights Reserved
 * Unauthorized copying or modification of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Ibrahim for Hiroshi, braimsou@gmail.com - contact@hiroshimc.net - 2021
 */

package fr.redxil.api.paper.tags;

import org.bukkit.entity.Player;

import java.util.Collection;

public interface TagsManager {

    TagProvider getTagProvider();

    void setTagProvider(TagProvider provider);

    void addPlayer(Player player);

    void removePlayer(Player player);

    void updatePlayer(Player player);

    void updateOnline(Player player);

    void updateHeaderFooter(Player player, String header, String footer);

    boolean isDisplayHealth();

    void setDisplayHealth(boolean displayHealth);

    TagScore getScore(Player player);

    Collection<? extends Player> getTagPlayers();

    Collection<? extends Player> getScorePlayers();
}
