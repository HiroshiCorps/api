/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.group.team;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public interface TeamManager {

    /**
     * Get team list thanks to the game id
     *
     * @return Team list
     */
    List<String> getTeamList();

    /**
     * Check if player his in a team with this uuid
     *
     * @param uuid The uuid to check
     * @return true if the uuid his in a team
     */
    boolean hasTeam(UUID uuid);

    /**
     * Check if player his in a team with this uuid
     *
     * @return true if team exist in game
     */
    boolean hasTeam();

    /**
     * Check if a team exist with an id
     *
     * @param teamName Check if team exist with the team name
     * @return true if the team exist
     */
    boolean isTeamExist(String teamName);

    /**
     * Get team thanks to the team id
     *
     * @param teamName team to get
     * @return Team interface if the team exist
     */
    Optional<Team> getTeam(String teamName);

    /**
     * Create team with a name
     *
     * @param name      Name of the team
     * @param maxPlayer Number max of player
     * @return Team interface, null if a team already exist with this name
     */
    Optional<Team> createTeam(String name, int maxPlayer);

    /**
     * @param uuid the player uuid
     * @return Team interface if player has team, if no, null
     */
    Optional<Team> getPlayerTeam(UUID uuid);

    boolean areAllInTeams(List<UUID> playerList);

    Map<UUID, String> getUUIDToTeamMap();

}
