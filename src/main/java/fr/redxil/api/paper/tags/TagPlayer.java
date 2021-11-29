/* Copyright (C) Hiroshi - Ibrahim - All Rights Reserved
 * Unauthorized copying or modification of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Ibrahim for Hiroshi, braimsou@gmail.com - contact@hiroshimc.net - 2021
 */

package fr.redxil.api.paper.tags;

import org.bukkit.entity.Player;

public interface TagPlayer {

    void update(TagProvider provider, TagPlayer target);

    Player getPlayer();

    String getPrefix();

    void setPrefix(String prefix);

    String getSuffix();

    void setSuffix(String suffix);

    String getListName();

    void setListName(String listName);

    int getPosition();

    void setPosition(int position);
}
