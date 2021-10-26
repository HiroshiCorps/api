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

public interface SanctionInfo {


    Integer getSanctionID();

    long getTargetID();

    long getAuthorID();

    SanctionType getSanctionType();

    String getReason();

    Long getCanceller();

    void setCanceller(long playerID);

    boolean isCancelled();

    long getSanctionDateTS();

    long getSanctionEndTS();

    boolean hasSanctionEnd();

    boolean isEffective();

    TextComponentBuilder getSancMessage();

}
