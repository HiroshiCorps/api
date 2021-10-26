/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.velocity;

import com.velocitypowered.api.proxy.ProxyServer;

public abstract class Velocity {

    static Velocity instance;

    public Velocity() {
        instance = this;
    }

    public static Velocity getInstance() {
        return instance;
    }

    public abstract ProxyServer getProxyServer();

}
