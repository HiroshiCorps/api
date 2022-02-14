/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.group.team;

import fr.redxil.api.common.game.Game;
import fr.redxil.api.common.message.Color;
import fr.redxil.api.common.player.APIPlayer;
import fr.redxil.api.common.server.Server;

import java.util.List;
import java.util.UUID;

public interface TeamManager {

    /**
     * Get team list thanks to the game id
     *
     * @param game The game to check
     * @return Team list
     */
    List<Team> getTeamList(Game game);

    List<String> getTeamNameList(Game game);

    List<Team> getTeamWithRemainingPlace(List<Team> teamList, int remain);

    List<Team> getTeamWithRemainingPlace(List<Team> teamList);

    List<Team> getTeamWithRemainingPlace(Game game, int i);

    List<Team> getTeamWithRemainingPlace(Game game);


    List<Team> getTeamWithMinPlayer(List<Team> teamList, int playerMin);

    List<Team> getTeamWithMinPlayer(Game game, int playerMin);

    List<Team> getTeamWithMinPlayer(List<Team> teamList);

    List<Team> getTeamWithMinPlayer(Game game);


    List<Team> getTeamOrderByRemainingPlace(List<Team> teamList2);

    List<Team> getTeamOrderByRemainingPlace(Game game, boolean remainingOnly);

    List<Team> getTeamOrderByRemainingPlace(Game game);

    /**
     * Check if player his in a team
     *
     * @param game The game to check
     * @param apiPlayer The player to ckeck
     * @return true if the player his in a team
     */
    boolean hasTeam(Game game, APIPlayer apiPlayer);

    /**
     * Check if player his in a team with this uuid
     *
     * @param game The game to check
     * @param uuid The uuid to check
     * @return true if the uuid his in a team
     */
    boolean hasTeam(Game game, UUID uuid);

    /**
     * Check if player his in a team with this uuid
     *
     * @param game The game to check
     * @return true if team exist in game
     */
    boolean hasTeam(Game game);

    /**
     * Check if a team exist with an id
     *
     * @param game The game to check
     * @param teamName Check if team exist with the team name
     * @return true if the team exist
     */
    boolean isTeamExist(Game game, String teamName);

    /**
     * Get team thanks to the team id
     *
     * @param game The game to check
     * @param teamName team to get
     * @return Team interface if the team exist
     */
    Team getTeam(Game game, String teamName);

    /**
     * Create team with a name
     *
     * @param game The game to check
     * @param name      Name of the team
     * @param maxPlayer Number max of player
     * @return Team interface, null if a team already exist with this name
     */
    Team createTeam(Game game, String name, int maxPlayer);

    /**
     * Create team with a name
     *
     * @param game The game to check
     * @param name      Name of the team
     * @param maxPlayer Number max of player
     * @param color     Team color
     * @return Team interface, null if a team already exist with this name
     */
    Team createTeam(Game game, String name, int maxPlayer, Color color);

    /**
     * @param game The game to check
     * @param uuid the player uuid
     * @return Team interface if player has team, if no, null
     */
    Team getPlayerTeam(Game game, UUID uuid);

    /**
     * @param game The game to check
     * @param apiPlayer the player
     * @return Team interface if player has team, if no, null
     */
    Team getPlayerTeam(Game game, APIPlayer apiPlayer);

    boolean areAllInTeams(Game game, List<UUID> playerList);

    boolean attributeTeamToAll(Game game, List<UUID> playerList);

}
