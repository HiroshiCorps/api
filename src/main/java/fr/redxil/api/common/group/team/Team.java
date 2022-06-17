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

    long getServerID();

    String getTeamName();


    String getDisplayName();

    void setDisplayName(String dspName);


    String getPrefix();

    void setPrefix(String prefix);

    String getSuffix();

    void setSuffix(String suffix);


    boolean getFriendlyFire();

    void setFriendlyFire(boolean value);

    /*
     *
     * APIPlayer part
     *
     */

    List<UUID> getListPlayerUUID();

    boolean addPlayer(UUID player);

    boolean removePlayer(UUID player);

    int getSize();

    boolean isEmpty();

    boolean hasPlayer(UUID apiPlayer);

    int getMaxPlayers();

    void setMaxPlayers(int maxPlayers);

    int getRemainingPlace();

    boolean hasAttached(String key);

    void addAttach(String key, Object object);

    void removeAttach(String key);

    Object getAttach(String key);

    Map<String, Object> getAttachedMap();

}