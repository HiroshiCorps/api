package fr.redxil.api.spigot.utils;

import fr.redxil.api.common.utils.MathUtils;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

import java.util.Random;

public class FireworkUtils {

    private static Color getColor(int i) {
        Color c = null;

        if (i == 1) {
            c = Color.AQUA;
        } else if (i == 2) {
            c = Color.BLACK;
        } else if (i == 3) {
            c = Color.BLUE;
        } else if (i == 4) {
            c = Color.FUCHSIA;
        } else if (i == 5) {
            c = Color.GRAY;
        } else if (i == 6) {
            c = Color.GREEN;
        } else if (i == 7) {
            c = Color.LIME;
        } else if (i == 8) {
            c = Color.MAROON;
        } else if (i == 9) {
            c = Color.NAVY;
        } else if (i == 10) {
            c = Color.OLIVE;
        } else if (i == 11) {
            c = Color.ORANGE;
        } else if (i == 12) {
            c = Color.PURPLE;
        } else if (i == 13) {
            c = Color.RED;
        } else if (i == 14) {
            c = Color.SILVER;
        } else if (i == 15) {
            c = Color.TEAL;
        } else if (i == 16) {
            c = Color.WHITE;
        } else if (i == 17) {
            c = Color.YELLOW;
        }
        return c;
    }

    public static void spawnFirework(Player player) {
        spawnFirework(player.getLocation());
    }

    public static void spawnFirework(Location lo) {
        Firework fw = (Firework) lo.getWorld().spawnEntity(lo, EntityType.FIREWORK);
        FireworkMeta fwm = fw.getFireworkMeta();
        Random r = new Random();

        int rt = MathUtils.randInt(1, 2);
        FireworkEffect.Type type = FireworkEffect.Type.BALL;
        if (rt == 2) {
            type = FireworkEffect.Type.BALL_LARGE;
        }
        int r1i = r.nextInt(17) + 1;
        int r2i = r.nextInt(17) + 1;
        Color c1 = getColor(r1i);
        Color c2 = getColor(r2i);

        FireworkEffect effect = FireworkEffect.builder().flicker(r.nextBoolean()).withColor(c1).withFade(c2).with(type).trail(r.nextBoolean()).build();

        fwm.addEffect(effect);
        fwm.setPower(0);
        fw.setFireworkMeta(fwm);
    }

    public static void spawnFirework(Location lo, Color color) {
        Firework fw = (Firework) lo.getWorld().spawnEntity(lo, EntityType.FIREWORK);
        FireworkMeta fwm = fw.getFireworkMeta();
        Random r = new Random();

        int rt = MathUtils.randInt(1, 2);
        FireworkEffect.Type type = FireworkEffect.Type.BALL;
        if (rt == 2) {
            type = FireworkEffect.Type.BALL_LARGE;
        }

        FireworkEffect effect = FireworkEffect.builder().flicker(r.nextBoolean()).withColor(color).with(type).trail(r.nextBoolean()).build();

        fwm.addEffect(effect);
        fwm.setPower(0);
        fw.setFireworkMeta(fwm);
    }

}
