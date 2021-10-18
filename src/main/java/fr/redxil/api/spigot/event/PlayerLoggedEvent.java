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

public class PlayerLoggedEvent extends Event {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    APIPlayer apiPlayer;

    public PlayerLoggedEvent(APIPlayer apiPlayer) {
        this.apiPlayer = apiPlayer;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public APIPlayer getAPIPlayer() {
        return apiPlayer;
    }

}
