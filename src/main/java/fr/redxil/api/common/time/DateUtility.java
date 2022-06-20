/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.time;

import javax.annotation.Nullable;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Locale;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class DateUtility {

    public static Optional<TimeUnit> getTimerUnit(char s) {
        switch (s) {
            case 's' -> {
                return Optional.of(TimeUnit.SECONDS);
            }
            case 'm' -> {
                return Optional.of(TimeUnit.MINUTES);
            }
            case 'h' -> {
                return Optional.of(TimeUnit.HOURS);
            }
            case 'j' -> {
                return Optional.of(TimeUnit.DAYS);
            }
        }
        return Optional.empty();
    }

    public static Optional<Timestamp> getTimeStamp(TimeUnit s) {
        switch (s) {
            case NANOSECONDS -> {
                return Optional.of(new Timestamp(1L));
            }
            case MICROSECONDS -> {
                return Optional.of(new Timestamp(10L));
            }
            case MILLISECONDS -> {
                return Optional.of(new Timestamp(100L));
            }
            case SECONDS -> {
                return Optional.of(new Timestamp(1000L));
            }
            case MINUTES -> {
                return Optional.of(new Timestamp(60000L));
            }
            case HOURS -> {
                return Optional.of(new Timestamp(3600000L));
            }
            case DAYS -> {
                return Optional.of(new Timestamp(86400000L));
            }
        }
        return Optional.empty();
    }

    public static Optional<Timestamp> toTimeStamp(String timeArgs) {

        Optional<TimeUnit> timeUnit = getTimerUnit(timeArgs.charAt(timeArgs.length() - 1));
        if (timeUnit.isPresent()) {
            timeArgs = timeArgs.replace(Character.valueOf(timeArgs.charAt(timeArgs.length() - 1)).toString(), "");
            try {
                Optional<Timestamp> timestamp = getTimeStamp(timeUnit.get());
                if (timestamp.isPresent())
                    return Optional.of(new Timestamp(Integer.parseInt(timeArgs) * timestamp.get().getTime()));
            } catch (NumberFormatException ignored) {
            }
        }

        return Optional.empty();

    }

    public static Timestamp addToCurrentTimeStamp(Timestamp timeArgs) {

        return sumTimeStamp(getCurrentTimeStamp(), timeArgs);

    }

    public static Timestamp sumTimeStamp(Timestamp timeArgs1, Timestamp timeArgs2) {

        return new Timestamp(timeArgs1.getTime() + timeArgs2.getTime());

    }

    public static Timestamp getCurrentTimeStamp() {

        return new Timestamp(System.currentTimeMillis());

    }

    public static String getMessage(@Nullable Timestamp time) {

        if (time == null)
            return "permanent";
        else
            return DateFormat.getDateTimeInstance(
                    DateFormat.SHORT, DateFormat.SHORT,
                    Locale.FRANCE).format(time.getTime());

    }

}
