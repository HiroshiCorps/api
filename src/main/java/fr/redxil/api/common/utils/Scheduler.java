package fr.redxil.api.common.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

public abstract class Scheduler implements Runnable {

    private static final ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());
    private static final ExecutorService executor = Executors.newCachedThreadPool();

    public static void runTask(Runnable run) {
        executor.submit(run);
    }

    public static void cancelTasks() {
        executor.shutdown();
        scheduledExecutor.shutdown();
    }

    public ScheduledFuture scheduleAsyncDelayedTask(long delay, java.util.concurrent.TimeUnit timeUnit) {
        return scheduledExecutor.schedule(this, delay, timeUnit);
    }

    public ScheduledFuture scheduleAsyncRepeatingTask(long start, long period, java.util.concurrent.TimeUnit timeUnit) {
        return scheduledExecutor.scheduleAtFixedRate(this, start, period, timeUnit);
    }

    public void runTask() {
        Scheduler.runTask(this);
    }

}
