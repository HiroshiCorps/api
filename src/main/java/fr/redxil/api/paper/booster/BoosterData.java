/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.paper.booster;

public interface BoosterData {

    long getTimeStart();

    void setTimeStart(long timeStart);

    String author();

    void setPseudo(String pseudo);

    int getValue();

    void setValue(int value);

    String getColorName();

    String getBoosterName(boolean maximized);

    String getBoossterName(boolean maximized, int div);

}
