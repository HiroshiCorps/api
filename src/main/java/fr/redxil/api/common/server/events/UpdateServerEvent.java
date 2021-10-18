/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  * Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *  * Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.server.events;

import fr.redxil.api.common.server.Server;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.Arrays;
import java.util.List;

public class UpdateServerEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final Server server;
    private final List<String> informations;

    public UpdateServerEvent(Server server, String... informations) {
        this.server = server;

        this.informations = Arrays.asList(informations);
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public Server getServer() {
        return server;
    }

    public List<String> getInformations() {
        return informations;
    }
}
