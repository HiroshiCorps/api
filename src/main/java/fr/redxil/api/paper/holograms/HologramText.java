package fr.redxil.api.paper.holograms;

import org.bukkit.entity.Player;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class HologramText {

    private String text;
    private Consumer<String> beforeUpdate;
    private Consumer<String> thenUpdate;
    private BiFunction<Player, String, String> updater;
    private long interval;

    public HologramText(String text) {
        this.text = text;
    }

    public HologramText beforeUpdate(Consumer<String> consumer) {
        this.beforeUpdate = consumer;
        return this;
    }

    public HologramText onUpdate(BiFunction<Player, String, String> updater) {
        this.updater = updater;
        return this;
    }

    public HologramText thenUpdate(Consumer<String> consumer) {
        this.thenUpdate = consumer;
        return this;
    }

    public HologramText interval(long interval) {
        this.interval = interval;
        return this;
    }

    public Consumer<String> getBeforeUpdate() {
        return beforeUpdate;
    }

    public Consumer<String> getThenUpdate() {
        return thenUpdate;
    }

    public String getUpdatingLine(Player player) {
        return this.updater == null ? this.text : this.updater.apply(player, this.text);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getInterval() {
        return interval;
    }
}
