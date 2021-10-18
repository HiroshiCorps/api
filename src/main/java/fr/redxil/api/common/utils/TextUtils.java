package fr.redxil.api.common.utils;

import org.bukkit.ChatColor;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TextUtils {

    public static String getProgressBar(int value, int maxValue) {
        return getProgressBar(value, maxValue, "§b");
    }

    public static String getProgressBar(int value, int maxValue, String prefixColor) {
        StringBuilder progressBar = new StringBuilder(prefixColor + MathUtils.cutInt(value) + " §b§m");
        for (int i = 0; i < Math.round((5.0 / (double) maxValue) * (double) value); i++) {
            progressBar.append("-");
        }
        progressBar.append("§7§m");
        for (int i = 0; i < Math.round(5.0 - ((5.0 / (double) maxValue) * (double) value)); i++) {
            progressBar.append("-");
        }
        progressBar.append("§e ").append(MathUtils.getCompiledFormat(maxValue));
        return progressBar.toString();
    }

    public static String getDate() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Paris"));
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        return day + "/" + 0 + (month += 1) + "/" + String.valueOf(year).replace("20", "");
    }

    public static String getPrefix(String name) {
        return "§e§l" + name.toUpperCase() + " §f❙ §7";
    }

    public static String getPrefix(String name, ChatColor chatColor) {
        return "§e§l" + name.toUpperCase() + " §f❙ " + chatColor;
    }

    public static String createLines(String lore) {
        return createLines(lore, 120);
    }

    public static String createLines(String lore, int size) {
        if (lore.endsWith(" !")) {
            lore = lore.substring(0, lore.length() - 2);
            lore += "!";
        }

        int i = 0;
        StringBuilder str = new StringBuilder();
        String[] splitlore = lore.split(" ");
        String color = "";

        if (lore.substring(0, 2).startsWith("§")) {
            size -= 10;
            color = lore.substring(0, 2);
        }

        int a = 0;
        for (String string : splitlore) {
            i+=5*string.toCharArray().length;
            str.append(string).append(" ");
            if (i >= size && a < splitlore.length - 1) {
                str.append("\n").append(color);
                i = 0;
            } else {
                i += 4;
            }
            a++;
        }

        return str.toString();
    }

    public static String getCenteredBook(String message) {
        return getCentered(message, 60);
    }

    public static String getCenteredMessage(String message) {
        return getCentered(message, 154);
    }

    private static String getCentered(String message, int CENTER_PX) {
        message = ChatColor.translateAlternateColorCodes('&', message);

        int messagePxSize = 0;
        boolean previousCode = false;
        boolean isBold = false;

        for (char c : message.toCharArray()) {
            if (c == '§') {
                previousCode = true;
            } else if (previousCode) {
                previousCode = false;
                isBold = (c == 'l') || (c == 'L');
            } else {
                messagePxSize += isBold ? 6 : 5;
                messagePxSize++;
            }
        }

        int halvedMessageSize = messagePxSize / 2;
        int toCompensate = CENTER_PX - halvedMessageSize;
        int spaceLength = 4;
        int compensated = 0;
        StringBuilder sb = new StringBuilder();
        while (compensated < toCompensate) {
            sb.append(" ");
            compensated += spaceLength;
        }
        return (sb + message);
    }

}
