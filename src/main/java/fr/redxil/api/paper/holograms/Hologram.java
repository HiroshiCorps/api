package fr.redxil.api.paper.holograms;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.List;

public interface Hologram {

    List<HologramLine> lines();

    Location location();

    default long refreshInterval() {
        return -1L;
    }

    default double indent() {
        return 0.25;
    }

    default void spawned(Player player) {
    }

    default void destroyed(Player player) {
    }
}
