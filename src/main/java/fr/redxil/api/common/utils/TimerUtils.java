package fr.redxil.api.common.utils;

public class TimerUtils {

    public static String getTimeFormated(int time) {
        int minutes = time / 60;
        int secondes = time - (minutes * 60);
        return (minutes < 10 ? "0" : "") + minutes + ":" + (secondes < 10 ? "0" : "") + secondes;
    }

    public static String getTimeCooldown(int seconds) {
        int[] times = MathUtils.getDiviseTime(seconds);
        return (times[0] > 0 ? times[0] + "d " : "") + (times[1] > 0 ? times[1] + "h " : "") + times[2] + "m" + (times[0] > 0 ? "" : " " + times[3] + "s");
    }

}
