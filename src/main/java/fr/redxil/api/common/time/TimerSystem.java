/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.time;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimerSystem implements Runnable {

    public double milli = 0d, sec = 0d, min = 0d, hours = 0d;
    ScheduledExecutorService timer;
    TimerListener timerListener = null;
    int period = 1;
    TimeUnit timeUnit = TimeUnit.SECONDS;

    public TimerListener getTimerListener() {
        return this.timerListener;
    }

    public void setTimerListener(TimerListener timerListener) {
        this.timerListener = timerListener;
    }

    public boolean isRunning() {
        if (timer == null)
            return false;
        return !timer.isShutdown();
    }

    public void startTimer() {
        if (isRunning() || !canStart()) return;
        this.timer = Executors.newSingleThreadScheduledExecutor();
        timer.scheduleAtFixedRate(this, 0L, 1L, TimeUnit.MILLISECONDS);
    }

    public void stopTimer() {
        if (!isRunning()) return;
        timer.shutdownNow();
        timerListener = null;
    }

    public void setPeriod(int period, TimeUnit timeUnit) {
        boolean running = isRunning();
        stopTimer();
        this.period = period;
        this.timeUnit = timeUnit;
        if (running)
            startTimer();
    }

    public double getValue(TimeUnit timeEnum) {
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

    public void setValue(TimeUnit timeEnum, double value) {
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

    public boolean remove(TimeUnit timeEnum, int time) {
        switch (timeEnum) {
            case MILLISECONDS: {

                if (milli - time > 0) {
                    milli -= time;
                } else {
                    if (!remove(TimeUnit.SECONDS, 1)) {
                        milli = 0;
                        return false;
                    }
                    double kRemove = (milli - time) * -1;
                    milli = 0999d;
                    if (kRemove != 0)
                        return remove(TimeUnit.MILLISECONDS, Double.valueOf(kRemove).intValue());
                }
                return true;

            }

            case SECONDS: {

                if (sec - time > 0) {
                    sec -= time;
                } else {
                    if (!remove(TimeUnit.MINUTES, 1)) {
                        sec = 0;
                        return false;
                    }
                    double kRemove = (sec - time) * -1;
                    sec = 60d;
                    if (kRemove != 0)
                        return remove(TimeUnit.SECONDS, Double.valueOf(kRemove).intValue());
                }
                return true;

            }

            case MINUTES: {

                if (min - time > 0) {
                    min -= time;
                } else {
                    if (!remove(TimeUnit.HOURS, 1)) {
                        min = 0;
                        return false;
                    }
                    double kRemove = (min - time) * -1;
                    min = 60d;
                    if (kRemove != 0)
                        return remove(TimeUnit.MINUTES, Double.valueOf(kRemove).intValue());
                }
                return true;

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
        return canStart(timeUnit);
    }

    private boolean canStart(TimeUnit timeUnit) {
        switch (timeUnit) {
            case MILLISECONDS: {
                if (getValue(timeUnit) != 0)
                    return true;
                else return canStart(TimeUnit.SECONDS);
            }
            case SECONDS: {
                if (getValue(timeUnit) != 0)
                    return true;
                else return canStart(TimeUnit.MINUTES);
            }
            case MINUTES: {
                if (getValue(timeUnit) != 0)
                    return true;
                else return canStart(TimeUnit.HOURS);
            }
            case HOURS: {
                return getValue(timeUnit) != 0;
            }
        }
        return false;
    }

    @Override
    public void run() {

        if (!remove(timeUnit, period)) {

            if (timerListener.timerStop(this)) {
                stopTimer();
                return;
            }

            if (!canStart())
                stopTimer();

        } else timerListener.timerChange(this);

    }

}
