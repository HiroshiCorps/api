/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.player.moderators;

import fr.redxil.api.common.message.TextComponentBuilder;
import fr.redxil.api.common.player.APIPlayer;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public interface ModeratorManager {

    Optional<APIPlayerModerator> loadModerator(long id, UUID memberID, String name);

    /**
     * Get the moderator with this name / nick
     *
     * @param name This need to be the name of the player / nick supported but take more query on redis
     * @return APIPlayerModerator or null if player is not loaded or not a moderator
     */
    Optional<APIPlayerModerator> getModerator(String name);

    /**
     * Get the moderator with the MemberId
     *
     * @param id this need to be the MemberId of the APIPlayer
     * @return APIPlayerModerator or null if player is not loaded or not a moderator
     */
    Optional<APIPlayerModerator> getModerator(long id);

    /**
     * Get the moderator with this UUID, please prefer ModeratorManager.getModerator(MemberID) if you can
     *
     * @param uuid this need to be the UUID of the APIPlayer
     * @return APIPlayerModerator or null if player is not loaded or not a moderator
     */
    Optional<APIPlayerModerator> getModerator(UUID uuid);

    /**
     * Get the moderator with this UUID, please prefer ModeratorManager.getModerator(MemberID) if you can
     *
     * @param apiPlayer this need to be the APIPlayer
     * @return APIPlayerModerator or null if player is not loaded or not a moderator
     */
    Optional<APIPlayerModerator> getModerator(APIPlayer apiPlayer);

    /**
     * Get a list of the connected moderator
     *
     * @return The MemberId of the connected Moderator
     */
    Collection<Long> getLoadedModerator();

    Map<String, Long> getStringToLongModerator();

    Map<String, Long> getUUIDToLongModerator();

    void sendToModerators(TextComponentBuilder tcb);

    /**
     * Check if a player is a server moderator
     *
     * @param uuid This need to be the UUID of the player
     * @return True if the player is a moderator
     */
    boolean isModerator(UUID uuid);

    /**
     * Check if a player is a server moderator
     *
     * @param memberID this need to be the MemberId of the APIPlayer
     * @return True if the player is a moderator
     */
    boolean isModerator(long memberID);

    /**
     * Check if a player is a server moderator
     *
     * @param name This need to be the name of the player / nick supported but take more query on redis
     * @return True if the player is a moderator
     */
    boolean isModerator(String name);

    boolean isLoaded(long memberID);

    boolean isLoaded(UUID uuid);

    boolean isLoaded(String name);

    APIPlayerModerator getServerModerator();

}
