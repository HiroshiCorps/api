package fr.redxil.api.paper.holograms;

import org.bukkit.entity.Player;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class HologramLine {

    private String line;
    private Consumer<String> beforeUpdate;
    private Consumer<String> thenUpdate;
    private BiFunction<Player, String, String> updater;
    private long interval;

    public HologramLine(String line) {
        this.line = line;
    }

    public HologramLine beforeUpdate(Consumer<String> consumer) {
        this.beforeUpdate = consumer;
        return this;
    }

    public HologramLine onUpdate(BiFunction<Player, String, String> updater) {
        this.updater = updater;
        return this;
    }

    public HologramLine thenUpdate(Consumer<String> consumer) {
        this.thenUpdate = consumer;
        return this;
    }

    public HologramLine interval(long interval) {
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
        return this.updater == null ? this.line : this.updater.apply(player, this.line);
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public long getInterval() {
        return interval;
    }
}
