/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.paper.event;

import fr.redxil.api.common.API;
import fr.redxil.api.common.player.APIPlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerConnectedEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    private final org.bukkit.entity.Player player;
    private final APIPlayer apiPlayer;

    public PlayerConnectedEvent(org.bukkit.entity.Player player) {
        this.player = player;
        this.apiPlayer = API.getInstance().getPlayerManager().getPlayer(player.getUniqueId());
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public HandlerList getHandlers() {
        return null;
    }

    public org.bukkit.entity.Player getPlayer() {
        return this.player;
    }

    public APIPlayer getAPIPlayer() {
        return this.apiPlayer;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public void setCancelled(boolean b) {

    }
}
