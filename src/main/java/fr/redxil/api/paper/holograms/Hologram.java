package fr.redxil.api.paper.holograms;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public interface Hologram {

    void updateText(int line);

    void updateTextFor(int line, Player player);

    void refresh();

    void send(Player player);

    void destroy(Player player);

    void delete();

    Location getCurrentLocation();

    void setCurrentLocation(Location location);

    long getRefreshInterval();

    void setRefreshInterval(long interval);

    double getLineIndent();

    void setLineIndent(double interval);

}
