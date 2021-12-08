package fr.redxil.api.paper.holograms;

import org.bukkit.World;
import org.bukkit.entity.Player;

public interface HologramsManager {

    void spawn(Hologram hologram);

    void delete(Hologram hologram);

    void updateLine(Hologram hologram, int line);

    void updateLineFor(Hologram hologram, int line, Player player);

    void refresh(Hologram hologram);

    void destroy(Hologram hologram, Player player);

    void send(Hologram hologram, Player player);

    void spawnHolograms(Player player, World bukkitWorld);

    void destroyHolograms(Player player, World bukkitWorld);

}
