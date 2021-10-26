/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.message;

import fr.redxil.api.common.API;
import fr.redxil.api.common.player.APIPlayer;

import java.util.Collection;
import java.util.UUID;

public abstract class TextComponentBuilder {

    TextComponentBuilder previous = null;

    public static TextComponentBuilder createTextComponent() {
        if (API.get().isBungee())
            return new TextComponentBuilderVelocity();
        else return new TextComponentBuilderSpigot();
    }

    public static TextComponentBuilder createTextComponent(String message) {
        if (API.get().isBungee())
            return new TextComponentBuilderVelocity(message);
        else return new TextComponentBuilderSpigot(message);
    }

    protected static TextComponentBuilder createTextComponent(TextComponentBuilder prev) {
        if (API.get().isBungee()) {
            TextComponentBuilderVelocity tcb = new TextComponentBuilderVelocity();
            tcb.previous = prev;
            return tcb;
        }
        TextComponentBuilderSpigot tcb = new TextComponentBuilderSpigot();
        tcb.previous = prev;
        return tcb;
    }

    protected static TextComponentBuilder createTextComponent(String message, TextComponentBuilder prev) {
        if (API.get().isBungee()) {
            TextComponentBuilderVelocity tcb = new TextComponentBuilderVelocity(message);
            tcb.previous = prev;
            return tcb;
        }
        TextComponentBuilderSpigot tcb = new TextComponentBuilderSpigot(message);
        tcb.previous = prev;
        return tcb;
    }

    public abstract TextComponentBuilder appendText(String text);

    public abstract TextComponentBuilder appendNewComponentBuilder(String text);

    public abstract TextComponentBuilder setColor(Color color);

    public abstract TextComponentBuilder setOnClickExecCommand(String command);

    public abstract TextComponentBuilder setOnClickOpenURL(String command);

    public abstract TextComponentBuilder setOnClickSuggCommand(String command);

    public TextComponentBuilder getFinalTextComponentBuilder() {
        if (previous == null)
            return this;
        return previous.getFinalTextComponentBuilder();
    }

    public abstract Object getFinalTextComponent();

    public abstract Object getTextComponent();

    public TextComponentBuilder getPreviousBuilder() {
        return previous;
    }

    public abstract String toString();

    public abstract TextComponentBuilder setHover(String hover);

    public abstract void sendTo(UUID uuid);

    public void sendTo(APIPlayer apiPlayer) {
        if (apiPlayer == null)
            return;
        sendTo(apiPlayer.getUUID());
    }

    public abstract void sendTo(String name);

    public void sendToID(Long id) {
        sendTo(API.get().getPlayerManager().getPlayer(id));
    }

    public void sendToUUIDs(Collection<UUID> uuid) {
        uuid.forEach(this::sendTo);
    }

    public void sendToPlayers(Collection<APIPlayer> apiPlayer) {
        apiPlayer.forEach(this::sendTo);
    }

    public void sendToNames(Collection<String> name) {
        name.forEach(this::sendTo);
    }

    public void sendToIDS(Collection<Long> idList) {
        idList.forEach(this::sendToID);
    }

}
