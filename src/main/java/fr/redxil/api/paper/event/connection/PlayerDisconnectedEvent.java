/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.paper.event.connection;

import fr.redxil.api.common.player.APIOfflinePlayer;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class PlayerDisconnectedEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final APIOfflinePlayer apiPlayer;

    public PlayerDisconnectedEvent(APIOfflinePlayer player) {
        this.apiPlayer = player;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public APIOfflinePlayer getAPIOfflinePlayer() {
        return this.apiPlayer;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
