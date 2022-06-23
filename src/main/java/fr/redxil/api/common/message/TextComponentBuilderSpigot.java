/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.message;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;

public class TextComponentBuilderSpigot extends TextComponentBuilder {

    TextComponent textComponent;

    public TextComponentBuilderSpigot() {
        this.textComponent = new TextComponent();
    }

    public TextComponentBuilderSpigot(String message) {
        this.textComponent = new TextComponent(message);
    }

    @Override
    public TextComponentBuilder appendText(String text) {
        textComponent.setText(textComponent.getText() + text);
        return this;
    }

    @Override
    public TextComponentBuilder appendNewComponentBuilder(String text) {
        TextComponentBuilderSpigot tcb = (TextComponentBuilderSpigot) TextComponentBuilder.createTextComponent(text, this);
        textComponent.addExtra(tcb.getTextComponent());
        return this;
    }

    @Override
    public TextComponentBuilder setColor(Color color) {
        textComponent.setColor(ChatColor.getByChar(color.getChar()));
        return this;
    }

    @Override
    public TextComponentBuilder setOnClickExecCommand(String command) {
        textComponent.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, command));
        return this;
    }

    @Override
    public TextComponentBuilder setOnClickOpenURL(String command) {
        textComponent.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, command));
        return this;
    }

    @Override
    public TextComponentBuilder setOnClickSuggCommand(String command) {
        textComponent.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, command));
        return this;
    }

    @Override
    public String toString() {
        return getFinalTextComponent().toString();
    }

    @Override
    public TextComponentBuilder setHover(String hover) {
        textComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(hover)));
        return this;
    }

    @Override
    public TextComponent getTextComponent() {
        return textComponent;
    }

    @Override
    public TextComponent getFinalTextComponent() {
        return ((TextComponentBuilderSpigot) getFinalTextComponentBuilder()).getTextComponent();
    }

}
