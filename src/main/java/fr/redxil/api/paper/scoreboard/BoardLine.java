/* Copyright (C) Hiroshi - Ibrahim - All Rights Reserved
 * Unauthorized copying or modification of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Ibrahim for Hiroshi, braimsou@gmail.com - contact@hiroshimc.net - 2021
 */

package fr.redxil.api.paper.scoreboard;

import org.bukkit.entity.Player;

import java.util.function.BiFunction;

public class BoardLine {

    private static final BiFunction<String, Player, String> defaultFunction = (line, player) -> line;
    private final long updateInterval;
    private String line;
    private BiFunction<String, Player, String> updateFunction;

    public BoardLine(String line, BiFunction<String, Player, String> updateFunction, long updateInterval) {
        this.line = line;
        this.updateFunction = updateFunction;
        this.updateInterval = updateInterval;
    }

    public BoardLine(String line, BiFunction<String, Player, String> updateFunction) {
        this(line, updateFunction, -1L);
    }

    public BoardLine(String line, long updateInterval) {
        this(line, defaultFunction, -1L);
    }

    public BoardLine(String line) {
        this(line, defaultFunction, -1L);
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public BiFunction<String, Player, String> getUpdateFunction() {
        return updateFunction;
    }

    public void setUpdateFunction(BiFunction<String, Player, String> updateFunction) {
        this.updateFunction = updateFunction;
    }

    public long getUpdateInterval() {
        return updateInterval;
    }
}
