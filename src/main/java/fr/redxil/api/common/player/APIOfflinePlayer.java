/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.player;

import fr.redxil.api.common.player.data.LinkData;
import fr.redxil.api.common.player.data.LinkUsage;
import fr.redxil.api.common.player.data.SanctionInfo;
import fr.redxil.api.common.player.data.Setting;
import fr.redxil.api.common.player.moderators.APIPlayerModerator;
import fr.redxil.api.common.player.rank.Rank;
import fr.redxil.api.common.utils.SanctionType;

import javax.annotation.Nullable;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

public interface APIOfflinePlayer {

    /// <!-------------------- Rank part --------------------!>

    Long getRankPower();

    Rank getRank();

    void setRank(Rank rank);

    void setRank(Rank rank, Timestamp timestamp);

    boolean hasPermission(long l);

    /// <!-------------------- APIPlayer part --------------------!>

    String getName();

    boolean setName(String name);

    UUID getUUID();

    void setUUID(UUID uuid);

    boolean isConnected();

    long getMemberID();

    /// <!-------------------- Money part --------------------!>

    void addSolde(long value);

    boolean setSolde(long value);

    long getSolde();

    void addCoins(long value);

    boolean setCoins(long value);

    long getCoins();

    /// <!-------------------- Sanction part --------------------!>

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

    /// <!-------------------- Setting part --------------------!>

    void loadSettings();

    List<Setting> getSettings();

    void removeSetting(String settingName);

    Setting createSetting(String settingName, String settingValue);

    Setting getSetting(String settingsName);

    /// <!-------------------- Link part --------------------!>

    boolean hasLinkWith(LinkUsage linkUsage, @Nullable APIOfflinePlayer apiOfflinePlayer, String... linkType);

    List<LinkData> getLinks(LinkUsage linkUsage, @Nullable APIOfflinePlayer apiOfflinePlayer, String... linkType);

    LinkData getLink(LinkUsage linkUsage, @Nullable APIOfflinePlayer apiOfflinePlayer, String... linkType);

    LinkData createLink(APIOfflinePlayer apiOfflinePlayer, String linkType);

}
