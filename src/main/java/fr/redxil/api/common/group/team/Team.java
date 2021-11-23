/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.group.team;

import fr.redxil.api.common.message.Color;
import fr.redxil.api.common.player.APIPlayer;
import org.redisson.api.RMap;

import java.util.List;
import java.util.UUID;

public interface Team {

    void deleteTeam();

    /*
     *
     * Scoreboard part
     *
     */

    boolean hisClientSideAvailable();

    void setClientSideAvailable(boolean value);

    boolean getHideToOtherTeams();

    void setHideToOtherTeams(boolean value);

    boolean getCollide();

    void setCollide(boolean value);


    /*
     *
     * Team data part
     *
     */

    long getTeamID();

    String getName();


    String getDisplayName();

    void setDisplayName(String dspName);


    String getPrefix();

    void setPrefix(String prefix);

    String getSuffix();

    void setSuffix(String suffix);


    Color getChatColor();

    void setChatColor(Color chatColor);

    Color getColor();

    void setColor(Color color);

    String getColoredName();

    boolean getFriendlyFire();

    void setFriendlyFire(boolean value);

    /*
     *
     * APIPlayer part
     *
     */

    List<String> getListPlayerName(boolean nickCare);

    List<APIPlayer> getPlayers();

    List<String> getListPlayerUUIDS();

    List<UUID> getListPlayerUUID();

    boolean addPlayer(UUID player);

    boolean removePlayer(UUID player);

    int getSize();

    boolean isEmpty();

    boolean hasPlayer(APIPlayer apiPlayer);

    int getMaxPlayers();

    void setMaxPlayers(int maxPlayers);

    int getRemainingPlace();

    boolean hasAttached(String key);

    void addAttach(String key, Object object);

    void removeAttach(String key);

    Object getAttach(String key);

    RMap<String, Object> getAttachedMap();

}