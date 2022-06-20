/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.time;

import java.util.Optional;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimerSystem implements Runnable {

    double milli = 0d, sec = 0d, min = 0d, hours = 0d;
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

    public boolean startTimer() {
        if (isRunning() || !canStart()) return false;
        this.timer = Executors.newSingleThreadScheduledExecutor();
        timer.scheduleAtFixedRate(this, 0L, 1L, TimeUnit.MILLISECONDS);
        return true;
    }

    public boolean startTimer(TimerListener timerListener) {
        setTimerListener(timerListener);
        return startTimer();
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

    public Optional<Double> getValue(TimeUnit timeEnum) {
        switch (timeEnum) {
            case MILLISECONDS -> {
                return Optional.of(milli);
            }
            case SECONDS -> {
                return Optional.of(sec);
            }
            case MINUTES -> {
                return Optional.of(min);
            }
            case HOURS -> {
                return Optional.of(hours);
            }
            default -> {
                return Optional.empty();
            }
        }
    }

    public void setValue(double value, TimeUnit timeEnum) {
        switch (timeEnum) {
            case MILLISECONDS -> this.milli = value;
            case SECONDS -> this.sec = value;
            case MINUTES -> this.min = value;
            case HOURS -> this.hours = value;
        }
    }

    public boolean remove(int time, TimeUnit timeEnum) {
        switch (timeEnum) {
            case MILLISECONDS -> {

                if (milli - time > 0) {
                    milli -= time;
                } else {
                    if (!remove(1, TimeUnit.SECONDS)) {
                        milli = 0;
                        return false;
                    }
                    double kRemove = (milli - time) * -1;
                    milli = 0999d;
                    if (kRemove != 0)
                        return remove(Double.valueOf(kRemove).intValue(), TimeUnit.MILLISECONDS);
                }
                return true;

            }
            case SECONDS -> {

                if (sec - time > 0) {
                    sec -= time;
                } else {
                    if (!remove(1, TimeUnit.MINUTES)) {
                        sec = 0;
                        return false;
                    }
                    double kRemove = (sec - time) * -1;
                    sec = 60d;
                    if (kRemove != 0)
                        return remove(Double.valueOf(kRemove).intValue(), TimeUnit.SECONDS);
                }
                return true;

            }
            case MINUTES -> {

                if (min - time > 0) {
                    min -= time;
                } else {
                    if (!remove(1, TimeUnit.HOURS)) {
                        min = 0;
                        return false;
                    }
                    double kRemove = (min - time) * -1;
                    min = 60d;
                    if (kRemove != 0)
                        return remove(Double.valueOf(kRemove).intValue(), TimeUnit.MINUTES);
                }
                return true;

            }
            case HOURS -> {
                if (hours - time != 0) {
                    hours -= time;
                    return true;
                } else {
                    hours = 0;
                    return false;
                }
            }
            default -> {
            }
        }
        return false;
    }

    public boolean canStart() {
        return canStart(timeUnit);
    }

    private boolean canStart(TimeUnit timeUnit) {
        Optional<Double> value = getValue(timeUnit);
        switch (timeUnit) {
            case MILLISECONDS -> {
                if (value.isPresent() && value.get() != 0)
                    return true;
                else return canStart(TimeUnit.SECONDS);
            }
            case SECONDS -> {
                if (value.isPresent() && value.get() != 0)
                    return true;
                else return canStart(TimeUnit.MINUTES);
            }
            case MINUTES -> {
                if (value.isPresent() && value.get() != 0)
                    return true;
                else return canStart(TimeUnit.HOURS);
            }
            case HOURS -> {
                return value.isPresent() && value.get() != 0;
            }
            default -> {
                return false;
            }
        }

    }

    @Override
    public void run() {

        if (!remove(period, timeUnit)) {

            if (timerListener.timerStop(this)) {
                stopTimer();
                return;
            }

            if (!canStart())
                stopTimer();

        } else timerListener.timerChange(this);

    }

}
