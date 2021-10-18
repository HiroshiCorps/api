/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  * Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *  * Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.spigot.event;

import fr.redxil.api.common.player.APIPlayer;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class AsyncPlayerConnectedEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private APIPlayer apiPlayer;

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public APIPlayer getAPIPlayer() {
        return this.apiPlayer;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
