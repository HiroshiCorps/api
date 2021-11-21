/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.game.team;

import fr.redxil.api.common.message.Color;
import fr.redxil.api.common.player.APIPlayer;

import java.util.List;
import java.util.UUID;

public interface TeamManager {

    List<Team> getTeamList();

    List<Long> getTeamIDList();

    List<Team> getTeamWithRemainingPlace(List<Team> teamList, int remain);

    List<Team> getTeamWithRemainingPlace(List<Team> teamList);

    List<Team> getTeamWithRemainingPlace(int i);

    List<Team> getTeamWithRemainingPlace();


    List<Team> getTeamWithMinPlayer(List<Team> teamList, int playerMin);

    List<Team> getTeamWithMinPlayer(int playerMin);

    List<Team> getTeamWithMinPlayer(List<Team> teamList);

    List<Team> getTeamWithMinPlayer();


    List<Team> getTeamOrderByRemainingPlace(List<Team> teamList2);

    List<Team> getTeamOrderByRemainingPlace(boolean remainingOnly);

    List<Team> getTeamOrderByRemainingPlace();

    /**
     * Check if player his in a team
     *
     * @param apiPlayer The player to ckeck
     * @return true if the player his in a team
     */
    boolean hasTeam(APIPlayer apiPlayer);

    /**
     * Check if player his in a team with this uuid
     *
     * @param uuid The uuid to check
     * @return true if the uuid his in a team
     */
    boolean hasTeam(UUID uuid);

    /**
     * Check if a team exist with an id
     *
     * @param teamID Check if team exist with the team id
     * @return true if the team exist
     */
    boolean isTeamExist(long teamID);

    /**
     * Get team thanks to the team id
     *
     * @param teamID
     * @return Team interface if the team exist
     */
    Team getTeam(long teamID);

    /**
     * Create team with a name
     *
     * @param name      Name of the team
     * @param maxPlayer Number max of player
     * @return Team interface, null if a team already exist with this name
     */
    Team createTeam(String name, int maxPlayer);

    /**
     * Create team with a name
     *
     * @param name      Name of the team
     * @param maxPlayer Number max of player
     * @param color     Team color
     * @return Team interface, null if a team already exist with this name
     */
    Team createTeam(String name, int maxPlayer, Color color);

    /**
     * @param uuid the player uuid
     * @return Team interface if player has team, if no, null
     */
    Team getPlayerTeam(UUID uuid);

    /**
     * @param apiPlayer the player
     * @return Team interface if player has team, if no, null
     */
    Team getPlayerTeam(APIPlayer apiPlayer);

    boolean areAllInTeams(List<UUID> playerList);

    boolean attributeTeamToAll(List<UUID> playerList);

}
