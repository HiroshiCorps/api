/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  * Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *  * Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.data.utils;

public enum DataType {

    GLOBAL("GLOBAL"),
    SERVER("SERVER"),
    TEAM("TEAM"),
    PLAYER("PLAYER");

    final String type;

    DataType(String type) {
        this.type = type;
    }

    public static DataType getDataType(String type) {
        for (DataType dataType : DataType.values()) {
            if (dataType.getType().equals(type))
                return dataType;
        }
        return null;
    }

    public String toString() {
        return getType();
    }

    public String getType() {
        return this.type;
    }

    public boolean equals(DataType dataType) {
        return this.getType().equals(dataType.getType());
    }

}
