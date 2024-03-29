package fr.redxil.api.paper.utils;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.Optional;

/*
 * Code from https://bukkit.org/threads/get-entity-player-is-looking.300661/
 */

public class Targeter {

    public static Optional<Player> getTargetPlayer(final Player player) {
        return getTarget(player, player.getWorld().getPlayers());
    }

    public static Optional<Entity> getTargetEntity(final Entity entity) {
        return getTarget(entity, entity.getWorld().getEntities());
    }

    public static <T extends Entity> Optional<T> getTarget(final Entity entity,
                                                           final Iterable<T> entities) {
        if (entity == null)
            return Optional.empty();
        T target = null;
        final double threshold = 1;
        for (final T other : entities) {
            final Vector n = other.getLocation().toVector()
                    .subtract(entity.getLocation().toVector());
            if (entity.getLocation().getDirection().normalize().crossProduct(n)
                    .lengthSquared() < threshold
                    && n.normalize().dot(
                    entity.getLocation().getDirection().normalize()) >= 0) {
                if (target == null
                        || target.getLocation().distanceSquared(
                        entity.getLocation()) > other.getLocation()
                        .distanceSquared(entity.getLocation()))
                    target = other;
            }
        }
        return Optional.ofNullable(target);
    }

}