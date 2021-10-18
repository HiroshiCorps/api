/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  * Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *  * Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.sql;


import java.sql.Timestamp;
import java.util.HashMap;

public interface SQLRowSet {

    boolean first();

    boolean last();

    int getRow();

    boolean beforeFirst();

    boolean next();

    HashMap<String, ResultSetElement> getColumns();

    HashMap<String, Object> getColumnsObjects();

    Object getObject(String columnName);

    String getString(String columnName);

    Timestamp getTimestamp(String columnName);

    int getInt(String columnName);

    long getLong(String columnName);

    double getDouble(String columnName);

    byte getByte(String columnName);

    byte[] getBytes(String columnName);

    boolean isSigned(String columnName);

    boolean isInvalidColumn(String columnName, boolean checkNotNull);

    ResultSetMetaData getMetaData();

}
