/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.player.data;

import fr.redxil.api.common.message.TextComponentBuilder;
import fr.redxil.api.common.utils.SanctionType;

import java.sql.Timestamp;
import java.util.Optional;

public interface SanctionInfo {


    Optional<Long> getSanctionID();

    Long getTargetID();

    Long getAuthorID();

    SanctionType getSanctionType();

    String getReason();

    Optional<Long> getCanceller();

    void setCanceller(long playerID);

    boolean isCancelled();

    Timestamp getSanctionDateTS();

    Optional<Timestamp> getSanctionEndTS();

    boolean hasSanctionEnd();

    boolean isEffective();

    TextComponentBuilder getSancMessage();

}
