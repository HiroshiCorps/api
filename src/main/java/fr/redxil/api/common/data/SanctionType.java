/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  * Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *  * Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.data;

public enum SanctionType {

    BAN(1),
    MUTE(2),
    WARN(3),
    KICK(4);

    final int id;

    SanctionType(Integer id) {
        this.id = id;
    }

    public static SanctionType getSanctionType(int id) {

        for (SanctionType st : values())
            if (st.getID() == id)
                return st;

        return null;

    }

    public static SanctionType getSanctionType(String name) {

        name = name.toUpperCase();

        for (SanctionType st : values())
            if (st.getName().equals(name))
                return st;

        return null;

    }

    public int getID() {
        return id;
    }

    public String getName() {
        return this.toString();
    }

}
