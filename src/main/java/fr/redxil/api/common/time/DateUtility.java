/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.time;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtility {

    public static long toTimeStamp(String timeArgs) {

        if (timeArgs.equals("perm"))
            return -1L;

        TimeEnum timeEnum = TimeEnum.getTimerEnum(TallEnum.SMALL, Character.valueOf(timeArgs.charAt(timeArgs.length() - 1)).toString());
        if (timeEnum != null)
            try {
                return Integer.parseInt(timeArgs.replace(timeEnum.getString(TallEnum.SMALL), "")) * timeEnum.getTimeStampLong();
            } catch (NumberFormatException ignored) {
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

        return Calendar.getInstance(TimeZone.getDefault()).getTimeInMillis();

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
