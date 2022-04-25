/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.message;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.format.TextColor;

public class TextComponentBuilderVelocity extends TextComponentBuilder {

    TextComponent component;

    public TextComponentBuilderVelocity() {
        this.component = Component.text("");
    }

    public TextComponentBuilderVelocity(String message) {
        this.component = Component.text(message);
    }

    @Override
    public TextComponentBuilder appendText(String text) {
        this.component = component.append(Component.text(text));
        return this;
    }

    @Override
    public TextComponentBuilder appendNewComponentBuilder(String text) {
        TextComponentBuilderVelocity tcb = (TextComponentBuilderVelocity) TextComponentBuilder.createTextComponent(text);
        this.component = component.append(tcb.getTextComponent());
        return tcb;
    }

    @Override
    public TextComponentBuilder setColor(Color color) {
        this.component = component.color(TextColor.color(color.getRed(), color.getGreen(), color.getBlue()));
        return this;
    }

    @Override
    public TextComponentBuilder setOnClickExecCommand(String command) {
        component.clickEvent(ClickEvent.runCommand(command));
        return this;
    }

    @Override
    public TextComponentBuilder setOnClickOpenURL(String command) {
        component.clickEvent(ClickEvent.openUrl(command));
        return this;
    }

    @Override
    public TextComponentBuilder setOnClickSuggCommand(String command) {
        component.clickEvent(ClickEvent.suggestCommand(command));
        return this;
    }

    @Override
    public String toString() {
        return getFinalTextComponent().toString();
    }

    @Override
    public TextComponentBuilder setHover(String hover) {
        this.component = component.hoverEvent(Component.text(hover).asHoverEvent());
        return this;
    }

    @Override
    public TextComponent getTextComponent() {
        return component;
    }

    @Override
    public TextComponent getFinalTextComponent() {
        return ((TextComponentBuilderVelocity) getFinalTextComponentBuilder()).getTextComponent();
    }

}
