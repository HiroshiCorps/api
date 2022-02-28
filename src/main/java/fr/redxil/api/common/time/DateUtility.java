/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.time;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class DateUtility {

    public static TimeUnit getTimerUnit(char s) {
        switch (s) {
            case 's' -> {
                return TimeUnit.SECONDS;
            }
            case 'm' -> {
                return TimeUnit.MINUTES;
            }
            case 'h' -> {
                return TimeUnit.HOURS;
            }
            case 'j' -> {
                return TimeUnit.DAYS;
            }
        }
        return null;
    }

    public static long getTimeStampLong(TimeUnit s) {
        switch (s) {
            case SECONDS -> {
                return 1000L;
            }
            case MINUTES -> {
                return 60000L;
            }
            case HOURS -> {
                return 3600000L;
            }
            case DAYS -> {
                return 86400000L;
            }
        }
        return 0L;
    }

    public static long toTimeStamp(String timeArgs) {

        if (timeArgs.equals("perm"))
            return -1L;

        TimeUnit timeUnit = getTimerUnit(timeArgs.charAt(timeArgs.length() - 1));
        if (timeUnit != null) {
            timeArgs = timeArgs.replace(Character.valueOf(timeArgs.charAt(timeArgs.length() - 1)).toString(), "");
            try {
                return Integer.parseInt(timeArgs) * getTimeStampLong(timeUnit);
            } catch (NumberFormatException ignored) {
            }
        }

        return -2L;

    }

    public static long addToCurrentTimeStamp(long timeArgs) {

        long durationTime = getCurrentTimeStamp();
        if (timeArgs == -1L) return -1L;
        return durationTime + timeArgs;

    }

    public static long sumTimeStamp(long timeArgs1, long timeArgs2) {

        if (timeArgs1 == -1L || timeArgs2 == -1L) return -1L;

        return timeArgs1 + timeArgs2;

    }

    public static long getCurrentTimeStamp() {

        return new Timestamp(System.currentTimeMillis()).getTime();

    }

    public static boolean isANumber(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException ignored) {
            return false;
        }
    }

    public static String getMessage(long time) {

        if (time < 0)
            return "permanent";
        else
            return DateFormat.getDateTimeInstance(
                    DateFormat.SHORT, DateFormat.SHORT,
                    Locale.FRANCE).format(new Date(time).getTime());

    }

}
