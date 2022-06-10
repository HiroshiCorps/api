/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.player;

import fr.redxil.api.common.player.data.SanctionInfo;
import fr.redxil.api.common.player.moderators.APIPlayerModerator;
import fr.redxil.api.common.player.rank.Rank;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface APIPlayer extends APIOfflinePlayer {

    void sendMessage(String message);

    /// <!-------------------- APIPlayer part --------------------!>

    void unloadPlayer();


    boolean isNick();

    Rank getRealRank();

    void setRealRank(Rank rank);

    String getRealName();

    boolean setRealName(String name);

    Long getRealRankPower();

    void setRealRank(Rank rank, Timestamp timestamp);

    Optional<Timestamp> getRealRankTimeStamp();

    void restoreRealData();

    /// <!-------------------- Print rank part --------------------!>

    String getTabString();

    String getChatString();

    /// <!-------------------- Server part --------------------!>

    String getServerName();

    void setServerName(String name);

    long getBungeeServerID();

    void switchServer(long serverID);

    /// <!-------------------- Sanction part --------------------!>

    Optional<SanctionInfo> kickPlayer(String reason, APIPlayerModerator author);

    boolean isFreeze();

    Optional<Long> getFreeze();

    void setFreeze(Long playerModerator);

    /// <!-------------------- Temp part --------------------!>

    void addTempData(String key, Object object);

    Optional<Object> removeTempData(String key);

    Optional<Object> getTempData(String key);

    List<String> getTempDataKeyList();

    Optional<String> getLastMSGPlayer();

    void setLastMSGPlayer(String player);

}