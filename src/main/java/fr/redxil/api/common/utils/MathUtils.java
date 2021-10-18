package fr.redxil.api.common.utils;

import java.util.Random;

public class MathUtils {

    public static String getCompiledFormat(long value) {
        if (value >= 1000000000000000L) {
            return String.format("%.2fQ", (double) value / 1000000000000000.0);
        }
        if (value >= 1000000000000L) {
            return String.format("%.2fT", (double) value / 1000000000000.0);
        }
        if (value >= 1000000000L) {
            return String.format("%.2fB", (double) value / 1000000000.0);
        }
        if (value >= 1000000L) {
            return String.format("%.2fM", (double) value / 1000000.0);
        }
        if (value >= 1000L) {
            return String.format("%.1fk", (double) value / 1000.0);
        }
        return String.format("%d", value);
    }

    public static String cutLong(long value) {
        String dmgStr = "";
        String[] dmgStrList = String.valueOf(value).split("");
        int a = 1;

        for (int i = dmgStrList.length - 1; i >= 0; i--) {
            dmgStr = dmgStrList[i] + dmgStr;
            a++;
            if ((a > 3) && (i != 0)) {
                dmgStr = "." + dmgStr;
                a = 1;
            }
        }

        return dmgStr;
    }

    public static String cutInt(int value) {
        String dmgStr = "";
        String[] dmgStrList = String.valueOf(value).split("");
        int a = 1;

        for (int i = dmgStrList.length - 1; i >= 0; i--) {
            dmgStr = dmgStrList[i] + dmgStr;
            a++;
            if ((a > 3) && (i != 0)) {
                dmgStr = "." + dmgStr;
                a = 1;
            }
        }

        return dmgStr;
    }

    public static String cutDouble(double valueDouble) {
        long value = (long) valueDouble;
        double valueDecimal = valueDouble - value;
        String dmgStr = "";
        String[] dmgStrList = String.valueOf(value).split("");
        int a = 1;

        for (int i = dmgStrList.length - 1; i >= 0; i--) {
            dmgStr = dmgStrList[i] + dmgStr;
            a++;
            if ((a > 3) && (i != 0)) {
                dmgStr = "." + dmgStr;
                a = 1;
            }
        }

        return dmgStr + "," + (int) (valueDecimal * 10);
    }

    public static int[] getDiviseTime(Integer time) {
        long longVal = time.longValue();

        int days = (int) longVal / 86400;
        int hours = (int) (longVal - (days * 86400)) / 3600;
        int mins = (int) (longVal - ((days * 86400) + (hours * 3600))) / 60;
        int secs = (int) (longVal - ((days * 86400) + (hours * 3600) + (mins * 60)));

        return new int[]{days, hours, mins, secs};
    }

    public static int randInt(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    public static double randDouble(double min, double max) {
        return min + ((max - min) * new Random().nextDouble());
    }

}
