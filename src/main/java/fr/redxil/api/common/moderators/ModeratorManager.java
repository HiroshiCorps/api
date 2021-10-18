/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  * Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *  * Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.moderators;

import fr.redxil.api.common.message.TextComponentBuilder;
import fr.redxil.api.common.player.APIPlayer;

import java.util.Collection;
import java.util.UUID;

public interface ModeratorManager {

    APIPlayerModerator loadModerator(APIPlayer apiPlayer);

    /**
     * Get the moderator with this name / nick
     *
     * @param name This need to be the name of the player / nick supported but take more query on redis
     * @return APIPlayerModerator or null if player is not loaded or not a moderator
     */
    APIPlayerModerator getModerator(String name);

    /**
     * Get the moderator with the APIPlayer
     *
     * @param apiPlayer Of course, the APIPlayer
     * @return APIPlayerModerator or null if player is not loaded or not a moderator
     */
    APIPlayerModerator getModerator(APIPlayer apiPlayer);

    /**
     * Get the moderator with the MemberId
     *
     * @param id this need to be the MemberId of the APIPlayer
     * @return APIPlayerModerator or null if player is not loaded or not a moderator
     */
    APIPlayerModerator getModerator(long id);

    /**
     * Get the moderator with this UUID, please prefer ModeratorManager.getModerator(MemberID) if you can
     *
     * @param uuid this need to be the UUID of the APIPlayer
     * @return APIPlayerModerator or null if player is not loaded or not a moderator
     */
    APIPlayerModerator getModerator(UUID uuid);

    /**
     * Get a list of the connected moderator
     *
     * @return The MemberId of the connected Moderator
     */
    Collection<Long> getLoadedModerator();

    void sendToModerators(TextComponentBuilder tcb);

    /**
     * Check if a APIPlayer is a server moderator
     *
     * @param APIPlayer Of course the APIPlayer
     * @return True if the APIPlayer is a moderator
     */
    boolean isModerator(APIPlayer apiPlayer);

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
     * @param memberId this need to be the MemberId of the APIPlayer
     * @return True if the player is a moderator
     */
    boolean isModerator(long memberId);

    /**
     * Check if a player is a server moderator
     *
     * @param name This need to be the name of the player / nick supported but take more query on redis
     * @return True if the player is a moderator
     */
    boolean isModerator(String name);

    boolean isLoaded(long memberId);

}
