/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.game;

import fr.redxil.api.common.game.utils.HostAccess;

import java.util.List;
import java.util.UUID;

public interface Host extends Game {

    UUID getAuthor();

    HostAccess getHostAccess();

    void setHostAccess(HostAccess value);

    List<UUID> getAllowPlayer();

    List<UUID> getAllowSpectator();

    boolean isAllowPlayer(UUID player);

    boolean isAllowSpectator(UUID player);

}
