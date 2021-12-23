/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.player;

import fr.redline.pms.utils.IpInfo;
import fr.redxil.api.common.group.party.Party;
import fr.redxil.api.common.group.team.Team;
import fr.redxil.api.common.player.data.SanctionInfo;
import fr.redxil.api.common.player.moderators.APIPlayerModerator;
import fr.redxil.api.common.player.rank.Rank;
import fr.redxil.api.common.server.Server;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

public interface APIPlayer extends APIOfflinePlayer {

    /// <!-------------------- APIPlayer part --------------------!>

    UUID getUUID();

    IpInfo getIpInfo();

    void unloadPlayer();

    boolean isLogin();


    Rank getRealRank();

    void setRealRank(Rank rank);

    String getRealName();

    void setRealName(String name);

    Long getRealRankPower();

    void setRealRank(Rank rank, Timestamp timestamp);

    /// <!-------------------- Print rank part --------------------!>

    String getTabString();

    String getChatString();

    /// <!-------------------- Server part --------------------!>

    Server getServer();

    Server getBungeeServer();

    void switchServer(String server);

    /// <!-------------------- Sanction part --------------------!>

    SanctionInfo kickPlayer(String reason, APIPlayerModerator author);

    boolean isFreeze();

    /// <!-------------------- Party part --------------------!>

    boolean hasParty();

    Party getParty();

    /// <!-------------------- Team part --------------------!>

    boolean hasTeam();

    Team getTeam();

    /// <!-------------------- Temp part --------------------!>

    void addTempData(String key, Object object);

    Object removeTempData(String key);

    Object getTempData(String key);

    List<String> getTempDataKeyList();

}