package fr.redxil.api.common.utils;

import java.util.Optional;

public enum TimeUnit {

    TICKS,
    SECONDS,
    MINUTES,
    HOURS,
    DAYS;

    public static Optional<Integer> convertToTick(int time, TimeUnit unitTime) {
        return switch (unitTime) {
            case SECONDS -> Optional.of(time * 20);
            case MINUTES -> Optional.of(time * 20 * 60);
            case HOURS -> Optional.of(time * 20 * 60 * 60);
            case DAYS -> Optional.of(time * 20 * 60 * 60 * 24);
            default -> Optional.empty();
        };
    }

    public Optional<java.util.concurrent.TimeUnit> toJavaTimeUnit() {
        return switch (this) {
            case SECONDS -> Optional.of(java.util.concurrent.TimeUnit.SECONDS);
            case MINUTES -> Optional.of(java.util.concurrent.TimeUnit.MINUTES);
            case HOURS -> Optional.of(java.util.concurrent.TimeUnit.HOURS);
            case DAYS -> Optional.of(java.util.concurrent.TimeUnit.DAYS);
            default -> Optional.empty();
        };
    }

}
