/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.time;

import java.util.Timer;
import java.util.TimerTask;

public class TimerGest extends TimerTask {

    public double milli = 0d, sec = 0d, min = 0d, hours = 0d;
    Timer timer = new Timer();
    TimerListener timerListener;
    TimeEnum timeEnum;
    boolean started = false;

    public void startTimer(TimeEnum timeEnum, TimerListener timerListener) {
        if (started || !canStart()) return;
        this.timerListener = timerListener;
        this.timeEnum = timeEnum;
        timer.schedule(this, timeEnum.getTimeStampLong());
        started = true;
    }

    public void stopTimer() {
        if (!started) return;
        timer.cancel();
        timer.purge();
        timerListener = null;
        timeEnum = null;
        started = false;
    }

    public boolean isRunning() {
        return started;
    }

    public TimeEnum getTimerEnum() {
        return timeEnum;
    }

    public TimerListener getTimerListener() {
        return timerListener;
    }

    public double getValue(TimeEnum timeEnum) {
        switch (timeEnum) {
            case MILLISECONDS: {
                return milli;
            }
            case SECONDS: {
                return sec;
            }
            case MINUTES: {
                return min;
            }
            case HOURS: {
                return hours;
            }
        }
        return 0d;
    }

    public void setValue(TimeEnum timeEnum, double value) {
        switch (timeEnum) {
            case MILLISECONDS: {
                this.milli = value;
                break;
            }
            case SECONDS: {
                this.sec = value;
                break;
            }
            case MINUTES: {
                this.min = value;
                break;
            }
            case HOURS: {
                this.hours = value;
                break;
            }
        }
    }

    public boolean remove(TimeEnum timeEnum, int time) {
        switch (timeEnum) {
            case MILLISECONDS: {

                if (milli - time > 0) {
                    milli -= time;
                    return true;
                } else {
                    if (!remove(TimeEnum.SECONDS, 1)) {
                        milli = 0;
                        return false;
                    }
                    double kRemove = (milli - time) * -1;
                    milli = 0999d;
                    if (kRemove != 0)
                        return remove(TimeEnum.MILLISECONDS, Double.valueOf(kRemove).intValue());
                    return true;
                }

            }

            case SECONDS: {

                if (sec - time > 0) {
                    sec -= time;
                    return true;
                } else {
                    if (!remove(TimeEnum.MINUTES, 1)) {
                        sec = 0;
                        return false;
                    }
                    double kRemove = (sec - time) * -1;
                    sec = 60d;
                    if (kRemove != 0)
                        return remove(TimeEnum.SECONDS, Double.valueOf(kRemove).intValue());
                    return true;
                }

            }

            case MINUTES: {

                if (min - time > 0) {
                    min -= time;
                    return true;
                } else {
                    if (!remove(TimeEnum.HOURS, 1)) {
                        min = 0;
                        return false;
                    }
                    double kRemove = (min - time) * -1;
                    min = 60d;
                    if (kRemove != 0)
                        return remove(TimeEnum.MINUTES, Double.valueOf(kRemove).intValue());
                    return true;
                }

            }

            case HOURS: {
                if (hours - time != 0) {
                    hours -= time;
                    return true;
                } else {
                    hours = 0;
                    return false;
                }
            }
        }
        return false;
    }

    public boolean canStart() {
        return milli != 0 || sec != 0 || min != 0 || hours != 0;
    }

    @Override
    public void run() {

        if (!started) return;
        if (!remove(timeEnum, 1)) {

            if (!(!timerListener.timerStop(this) && canStart()))
                stopTimer();

        } else timerListener.timerChange(this);

    }

}
