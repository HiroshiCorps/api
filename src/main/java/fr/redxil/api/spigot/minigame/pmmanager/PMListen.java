/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  * Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *  * Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.spigot.minigame.pmmanager;

import fr.redline.pms.connect.linker.pm.PMManager;
import fr.redline.pms.connect.linker.pm.PMReceiver;
import fr.redxil.api.common.API;
import fr.redxil.api.spigot.minigame.GameBuilder;
import org.redisson.api.RedissonClient;

public class PMListen implements PMReceiver {

    public PMListen() {
        RedissonClient rc = API.get().getRedisManager().getRedissonClient();
        PMManager.addRedissonPMListener(rc, "forceSTART", String.class, this);
        PMManager.addRedissonPMListener(rc, "forceSTOPSTART", String.class, this);
        PMManager.addRedissonPMListener(rc, "forceEND", String.class, this);
        PMManager.addRedissonPMListener(rc, "forceWIN", String.class, this);

    }

    @Override
    public void pluginMessageReceived(String s, Object o) {
        switch (s) {
            case "forceSTART": {
                GameBuilder.getGameBuilder().forceStart();
                break;
            }
            case "forceSTOPSTART": {
                GameBuilder.getGameBuilder().stopStart();
                break;
            }
            case "forceEND": {
                GameBuilder.getGameBuilder().forceEnd(((String) o).split("<split>")[1]);
                break;
            }
            case "forceWIN": {
                String[] splitted = ((String) o).split("<split>");
                GameBuilder.getGameBuilder().forceWin(GameBuilder.getGameBuilder().getTeamManager().getTeam(Long.parseLong(splitted[1])), splitted[2]);
                break;
            }
        }
    }
}
