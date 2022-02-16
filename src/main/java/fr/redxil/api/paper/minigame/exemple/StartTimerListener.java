package fr.redxil.api.paper.minigame.exemple;

import fr.redxil.api.common.time.TimerListener;
import fr.redxil.api.common.time.TimerSystem;

public class StartTimerListener implements TimerListener {

    TestGame testGame;

    public StartTimerListener(TestGame testGame) {
        this.testGame = testGame;
    }

    @Override
    public boolean timerStop(TimerSystem timerSystem) {
        testGame.startTimerFinish();
        /// Here if false return, timer will not stop, timer update necessary
        /// With true, the timer will definetly stop running
        return false;
    }

    @Override
    public void timerChange(TimerSystem timerSystem) {

    }
}
