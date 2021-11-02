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


    boolean hasTeam(APIPlayer apiPlayer);

    boolean hasTeam(UUID uuid);

    boolean isTeamExist(long teamID);

    Team getTeam(long teamID);

    Team createTeam(String name, int maxPlayer);

    Team createTeam(String name, int maxPlayer, Color color);

    Team getPlayerTeam(UUID uuid);

    Team getPlayerTeam(APIPlayer apiPlayer);

    boolean areAllInTeams(List<UUID> playerList);

    boolean attributeTeamToAll(List<UUID> playerList);

}
