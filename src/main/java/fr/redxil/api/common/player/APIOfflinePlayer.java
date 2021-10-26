/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.player;

import fr.redxil.api.common.moderators.APIPlayerModerator;
import fr.redxil.api.common.player.data.SanctionInfo;
import fr.redxil.api.common.player.data.Setting;
import fr.redxil.api.common.rank.RankList;
import fr.redxil.api.common.utils.SanctionType;

import java.util.List;
import java.util.UUID;

public interface APIOfflinePlayer {

    /// <!-------------------- APIPlayer part --------------------!>

    Long getRankPower();

    Long getRankPower(boolean nickCare);

    RankList getRank();

    void setRank(RankList rank);

    boolean hasPermission(long l);

    boolean isNick();

    RankList getRank(boolean nickCare);

    String getName();

    void setName(String name);

    String getName(boolean nickCare);

    UUID getUUID();

    void setUUID(UUID uuid);

    long getMemberId();

    /// <!-------------------- Money part --------------------!>

    boolean isConnected();

    void addSolde(long value);

    boolean setSolde(long value);

    long getSolde();

    void addCoins(long value);

    /// <!-------------------- Sanction part --------------------!>

    boolean setCoins(long value);

    long getCoins();

    void loadSanction();

    SanctionInfo banPlayer(String reason, long time, APIPlayerModerator author);

    SanctionInfo mutePlayer(String reason, long time, APIPlayerModerator author);

    SanctionInfo warnPlayer(String reason, APIPlayerModerator author);

    List<SanctionInfo> getSanction();

    List<SanctionInfo> getSanction(SanctionType sanctionType);

    boolean isMute();

    boolean isBan();

    SanctionInfo getLastSanction(SanctionType sanctionType);

    boolean unBan(APIPlayerModerator mod);

    boolean unMute(APIPlayerModerator mod);

    List<String> getFriendInviteReceived();

    List<String> getFriendInviteSended();

    List<String> getFriendList();

    List<String> getBlackList();

    boolean hasFriend(APIOfflinePlayer playerName);

    void removeFriendReceived(APIOfflinePlayer playerName);

    boolean isBlackList(APIOfflinePlayer playerName);

    boolean hasFriendReceived(APIOfflinePlayer playerName);

    boolean friendInviteReceived(APIOfflinePlayer playerName);

    void friendInviteRevokeReceived(APIOfflinePlayer playerName);

    boolean hasFriendSend(APIOfflinePlayer playerName);

    boolean acceptFriendInviteReceived(APIOfflinePlayer playerName);

    void refusedFriendInviteReceived(APIOfflinePlayer playerName);

    /// <!-------------------- Setting part --------------------!>

    void loadSettings();

    List<Setting> getSettings();

    void removeSetting(String settingName);

    Setting createSetting(String settingName, String settingValue);

    Setting getSetting(String settingsName);

}
