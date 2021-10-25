/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  * Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *  * Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.spigot.scoreboard;

import fr.redxil.api.common.API;
import fr.redxil.api.common.player.APIPlayer;

import java.util.*;

public abstract class Scoreboard {

    private final List<String> adresse = new ArrayList<String>() {{
        add(" redxil - api");
        add(" redxil - api");
    }};

    private final String name;
    private final HashMap<UUID, ScoreboardBuilder> players = new HashMap<>();
    private int update = -1;

    private int animateFooter = 1;

    public Scoreboard(String name) {
        this.name = name;
    }

    public Scoreboard(String name, int update, int animateFooter) {
        this.name = name;
        this.update = update;
        this.animateFooter = animateFooter;
        this.update();
    }

    private void update() {
        Timer timer = new Timer();
        timer.schedule(
                new TimerTask() {
                    @Override
                    public void run() {

                        ArrayList<UUID> disconnectedUUID = new ArrayList<>();
                        for (Map.Entry<UUID, ScoreboardBuilder> entry : players.entrySet()) {
                            APIPlayer apiPlayer = API.get().getPlayerManager().getPlayer(entry.getKey());
                            if (apiPlayer != null)
                                updateScoreboard(apiPlayer, entry.getValue());
                            else disconnectedUUID.add(entry.getKey());
                        }

                        disconnectedUUID.forEach((uuid) -> removeScoreboard(uuid));

                    }
                }, 250L, 100L);
    }

    public void addScoreboard(org.bukkit.entity.Player player) {
        ScoreboardBuilder scoreboardBuilder = new ScoreboardBuilder(player, this.name);
        HashMap<Integer, String> lignes = new HashMap<>();

        this.buildScoreboard(API.get().getPlayerManager().getPlayer(player.getUniqueId()), lignes);

        scoreboardBuilder.create();

        for (Map.Entry<Integer, String> entry : lignes.entrySet()) {
            scoreboardBuilder.setLine(entry.getKey(), entry.getValue());
        }

        if (lignes.isEmpty()) {
            scoreboardBuilder.setLine(0, "No lignes found");
        }

        players.put(player.getUniqueId(), scoreboardBuilder);
    }

    public void removeScoreboard(org.bukkit.entity.Player player) {
        ScoreboardBuilder scoreboardBuilder = players.remove(player.getUniqueId());
        if (scoreboardBuilder != null)
            scoreboardBuilder.destroy();
    }

    public void removeScoreboard(UUID uuid) {
        ScoreboardBuilder scoreboardBuilder = players.remove(uuid);
        if (scoreboardBuilder != null)
            scoreboardBuilder.destroy();
    }

    protected abstract void buildScoreboard(APIPlayer apiPlayer, HashMap<Integer, String> lignes);

    protected abstract void updateScoreboard(APIPlayer apiPlayer, ScoreboardBuilder scoreboardBuilder);

    public String getName() {
        return this.name;
    }

    public int hasAnimateFooter() {
        return this.animateFooter;
    }

    public List<String> getAdresse() {
        return adresse;
    }
}
