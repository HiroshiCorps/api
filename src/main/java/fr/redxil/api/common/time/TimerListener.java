/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.time;

public interface TimerListener {

    /**
     * Function called when the timer is about to stop
     * @param timerSystem The timer who stopped
     * @return false if you want to cancel the timer stop (Only work if you set a new value)
     */
    boolean timerStop(TimerSystem timerSystem);

    /**
     * Function called when the remaining delay is changing
     * @param timerSystem The timer who delay changed
     */
    void timerChange(TimerSystem timerSystem);

}
