/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  * Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *  * Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.spigot.minigame.kits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KitsManager {

    private List<KitExecutor> kits = new ArrayList<>();

    public KitsManager() {

    }

    public void addKit(KitExecutor... kitExecutors) {
        kits.addAll(Arrays.asList(kitExecutors));
    }

    public List<KitExecutor> getKits() {
        return kits;
    }
}
