package fr.redxil.api.common.utils;

public enum TimeUnit {

    TICKS,
    SECONDS,
    MINUTES,
    HOURS,
    DAYS;

    public static int convertToTick(int time, TimeUnit unitTime) {
        switch (unitTime) {
            case SECONDS:
                time *= 20;
                break;
            case MINUTES:
                time *= 20 * 60;
                break;
            case HOURS:
                time *= 20 * 60 * 60;
                break;
            case DAYS:
                time *= 20 * 60 * 60 * 24;
                break;
        }
        return time;
    }

    public java.util.concurrent.TimeUnit toJavaTimeUnit() {
        switch (this) {
            case SECONDS:
                return java.util.concurrent.TimeUnit.SECONDS;
            case MINUTES:
                return java.util.concurrent.TimeUnit.MINUTES;
            case HOURS:
                return java.util.concurrent.TimeUnit.HOURS;
            case DAYS:
                return java.util.concurrent.TimeUnit.DAYS;
        }
        return java.util.concurrent.TimeUnit.MILLISECONDS;
    }

}
