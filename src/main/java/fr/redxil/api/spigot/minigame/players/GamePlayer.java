/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  * Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *  * Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.spigot.minigame.players;

import fr.redxil.api.common.team.Team;
import fr.redxil.api.spigot.minigame.kits.KitExecutor;

import java.util.UUID;

public class GamePlayer {

    private final UUID uuid;

    private boolean isDeath = false;

    private boolean isSpectator = false;

    private int kills = 0;

    private int deaths = 0;

    private KitExecutor kitExecutor = null;

    private Team team = null;

    public GamePlayer(UUID uuid) {
        this.uuid = uuid;
    }

    public KitExecutor getKitExecutor() {
        return kitExecutor;
    }

    public void setKitExecutor(KitExecutor kitExecutor) {
        this.kitExecutor = kitExecutor;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public boolean isDeath() {
        return isDeath;
    }

    public void setDeath(boolean death) {
        isDeath = death;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public void addKill() {
        kills++;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public boolean isSpectator() {
        return isSpectator;
    }

    public void setSpectator(boolean spectator) {
        isSpectator = spectator;
    }

    public UUID getUUID() {
        return uuid;
    }
}
