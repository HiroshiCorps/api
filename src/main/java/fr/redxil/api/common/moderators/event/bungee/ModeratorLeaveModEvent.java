/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.moderators.event.bungee;

import fr.redxil.api.common.moderators.APIPlayerModerator;

public class ModeratorLeaveModEvent {

    private final APIPlayerModerator moderator;

    public ModeratorLeaveModEvent(APIPlayerModerator moderator) {
        this.moderator = moderator;
    }

    public APIPlayerModerator getModerator() {
        return moderator;
    }
}
