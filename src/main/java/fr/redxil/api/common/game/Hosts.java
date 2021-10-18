/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  * Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *  * Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.game;

import java.util.List;

public interface Hosts extends Games {

    String getAuthor();

    HostAccess getHostAccess();

    void setHostAccess(HostAccess value);

    List<String> getAllowPlayer();

    List<String> getAllowSpectator();

    boolean isAllowPlayer(String player);

    boolean isAllowSpectator(String player);

}
