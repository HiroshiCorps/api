/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.models.royaumes;

import java.util.HashMap;

public interface RoyaumesPlayerModel {

    void getOrInsert(int primaryKey);

    void getOrInsert(HashMap<String, Object> defaultValues, String query, Object... vars);

    int getPurse();

    String getClans();

    String getClasses();

    void set(String columnName, Object value);

}
