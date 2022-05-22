/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.player;

import fr.redline.pms.utils.IpInfo;
import fr.redxil.api.common.player.data.LinkData;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.BiConsumer;

public interface APIPlayerManager {

    boolean dataExist(String name);

    /**
     * Get the APIPlayer with this name / nick (supported but take more query on redis, please use APIPlayerManager.getPlayer(memberID) if you can)
     *
     * @param name This need to be the name of the player / nick
     * @return APIPlayer or null if the player is not loaded
     */
    APIPlayer getPlayer(String name);

    /**
     * Get the APIPlayer with this UUID (supported but take more query on redis, please use APIPlayerManager.getPlayer(memberID) if you can)
     *
     * @param uuid this need to be the UUID of the APIPlayer
     * @return APIPlayerModerator or null if player is not loaded or not a moderator
     */
    APIPlayer getPlayer(UUID uuid);

    /**
     * Get the APIPlayer with the MemberId
     *
     * @param id this need to be the MemberId of the APIPlayer
     * @return APIPlayer or null if player is not loaded
     */
    APIPlayer getPlayer(long id);

    /**
     * Get the APIPlayerOffline with the name
     *
     * @param name this need to be the name of the APIPlayer
     * @return APIPlayerOffline or null if the player never connected on the server
     */
    APIOfflinePlayer getOfflinePlayer(String name);

    /**
     * Get the APIPlayerOffline with the name
     *
     * @param memberID this need to be the MemberID of the APIPlayer
     * @return APIPlayerOffline or null if the player never connected on the server
     */
    APIOfflinePlayer getOfflinePlayer(long memberID);

    /**
     * Get the APIPlayerOffline with the name
     *
     * @param uuid this need to be the MemberID of the APIPlayer
     * @return APIPlayerOffline or null if the player never connected on the server
     */
    APIOfflinePlayer getOfflinePlayer(UUID uuid);

    APIPlayer loadPlayer(String pseudo, UUID uuid, IpInfo ipInfo);

    /**
     * Check if a player is loaded with this name / nick (supported but take more query on redis, please use APIPlayerManager.getPlayer(memberID) if you can)
     *
     * @param name This need to be the name / nick (supported but take more query on redis, please use APIPlayerManager.getPlayer(memberID) if you can)
     * @return True if the player is loaded on Redis
     */
    boolean isLoadedPlayer(String name);

    /**
     * Check if a player is loaded with this MemberID
     *
     * @param id This need to be the MemberID of the player
     * @return True if the player is loaded on Redis
     */
    boolean isLoadedPlayer(long id);

    /**
     * Check if a player is loaded with this UUID
     *
     * @param uuid This need to be the UUID of the player
     * @return True if the player is loaded on Redis
     */
    boolean isLoadedPlayer(UUID uuid);

    List<Long> getLoadedPlayer();

    /**
     * When player loaded, if he has some linkType link, the BiConsumer will be used
     *
     * @param linkType   like a key
     * @param biConsumer the action to do
     */

    void addLinkOnConnectAction(String linkType, BiConsumer<APIPlayer, LinkData> biConsumer);

    /**
     * Remove the action for the specific LinkType
     *
     * @param linkType the key
     */

    void removeLinkOnConnectAction(String linkType);

    /**
     * Get the action linked to the linkType
     *
     * @param linkType the key
     * @return The linked action
     */
    BiConsumer<APIPlayer, LinkData> getLinkOnConnectAction(String linkType);

    /**
     * Get all register linkType
     *
     * @return all the register linkType
     */
    List<String> getLinkTypeList();

    /**
     * Check action linked to linkType
     *
     * @param linkType the key
     * @return true if action exist
     */
    boolean hasLinkType(String linkType);

    /**
     * Get LinkData with linkId
     *
     * @param linkID the id of the link
     * @return LinkData if the link exist
     */
    LinkData getLink(int linkID);

    Map<String, Long> getNameToLongMap();

    Map<String, Long> getUUIDToLongMap();

}
