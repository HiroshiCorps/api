package fr.redxil.api.paper.holograms;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.List;

public interface HologramsManager {

    void create(Location location, List<HologramText> hologramTextList);

    void spawnHolograms(Player player, World bukkitWorld);

    void destroyHolograms(Player player, World bukkitWorld);

}
