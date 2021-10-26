/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.models;

import fr.redxil.api.common.models.hub.HubPlayerModel;
import fr.redxil.api.common.models.practice.PracticePlayerModel;
import fr.redxil.api.common.models.royaumes.RoyaumesClansModel;
import fr.redxil.api.common.models.royaumes.RoyaumesPlayerModel;

public interface ModelsManager {

    RoyaumesPlayerModel generateRoyaumesPlayerModel();

    RoyaumesClansModel generateRoyaumesClansModel();

    PracticePlayerModel generatePracticePlayerModel();

    HubPlayerModel generateHubPlayerModel();

}
