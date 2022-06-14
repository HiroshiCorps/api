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

    protected TextComponentBuilder() {

    }

    public static TextComponentBuilder createTextComponent() {
        if (API.getInstance().isVelocity())
            return new TextComponentBuilderVelocity();
        else return new TextComponentBuilderSpigot();
    }

    public static TextComponentBuilder createTextComponent(String message) {
        if (API.getInstance().isVelocity())
            return new TextComponentBuilderVelocity(message);
        else return new TextComponentBuilderSpigot(message);
    }

    protected static TextComponentBuilder createTextComponent(TextComponentBuilder prev) {
        if (API.getInstance().isVelocity()) {
            TextComponentBuilderVelocity tcb = new TextComponentBuilderVelocity();
            tcb.previous = prev;
            return tcb;
        }
        TextComponentBuilderSpigot tcb = new TextComponentBuilderSpigot();
        tcb.previous = prev;
        return tcb;
    }

    protected static TextComponentBuilder createTextComponent(String message, TextComponentBuilder prev) {
        if (API.getInstance().isVelocity()) {
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

    public void sendTo(UUID uuid) {
        if (uuid.toString().equals("a12345678-b123-1234-a123-1234567891011"))
            System.out.println(getFinalTextComponent().toString());
        else API.getInstance().getAPIEnabler().sendMessage(uuid, toString());
    }

    public void sendTo(APIPlayer apiPlayer) {
        sendToID(apiPlayer.getMemberID());
    }

    public void sendTo(String name) {
        if (name.equals("Server;")) System.out.println(getFinalTextComponent().toString());
        else API.getInstance().getAPIEnabler().sendMessage(name, toString());
    }

    public void sendToID(Long id) {
        if (id == -5L) System.out.println(getFinalTextComponent().toString());
        else API.getInstance().getPlayerManager().getPlayer(id).ifPresent(this::sendTo);
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
