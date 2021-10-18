/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  * Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *  * Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.time;

import java.sql.Timestamp;

public enum TimeEnum {
    HOURS(3600000L, "heure(s)", "hr", "h"),
    MINUTES(60000L, "minute(s)", "min", "m"),
    SECONDS(1000L, "seconde(s)", "sec", "s"),
    MILLISECONDS(1L, "milliseconde(s)", "mils", "ms");

    final long timeStampLong;
    final Timestamp timeStamp;
    final String big, moy, min;

    TimeEnum(long timeStamp, String big, String moy, String min) {
        this.timeStampLong = timeStamp;
        this.timeStamp = new Timestamp(timeStampLong);
        this.big = big;
        this.moy = moy;
        this.min = min;
    }

    public static TimeEnum getTimerEnum(TallEnum tallEnum, String s) {
        for (TimeEnum te : values())
            if (te.getString(tallEnum).equals(s))
                return te;
        return null;
    }

    public long getTimeStampLong() {
        return timeStampLong;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public String getString(TallEnum tallEnum) {
        switch (tallEnum) {
            case SMALL:
                return min;
            case MOY:
                return moy;
            default:
                return big;
        }
    }

}
