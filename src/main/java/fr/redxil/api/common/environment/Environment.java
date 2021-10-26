/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.environment;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class Environment {

    public static HashMap<EnvVar, String> getVariables() {
        HashMap<EnvVar, String> variables = new HashMap<>();

        try {
            variables.put(EnvVar.SQL_HOST, System.getenv("SQL_HOST"));
            variables.put(EnvVar.SQL_PORT, System.getenv("SQL_PORT"));
            variables.put(EnvVar.SQL_DATABASE, System.getenv("SQL_DATABASE"));
            variables.put(EnvVar.SQL_USERNAME, System.getenv("SQL_USERNAME"));
            variables.put(EnvVar.SQL_PASSWORD, System.getenv("SQL_PASSWORD"));
            variables.put(EnvVar.REDIS_HOST, System.getenv("REDIS_HOST"));
            variables.put(EnvVar.REDIS_PORT, System.getenv("REDIS_PORT"));
            variables.put(EnvVar.REDIS_PASSWORD, System.getenv("REDIS_PASSWORD"));
        } catch (Exception ignored) {
        }

        FileInputStream in = null;
        try {
            Properties properties = new Properties();
            in = new FileInputStream("data/sql.properties");
            properties.load(in);

            if (properties.containsKey("sql-host")
                    && properties.containsKey("sql-database")
                    && properties.containsKey("sql-user")
                    && properties.containsKey("sql-password")) {
                variables.put(EnvVar.SQL_HOST, (String) properties.get("sql-host"));
                variables.put(EnvVar.SQL_PORT, "3306");
                variables.put(EnvVar.SQL_DATABASE, (String) properties.get("sql-database"));
                variables.put(EnvVar.SQL_USERNAME, (String) properties.get("sql-user"));
                variables.put(EnvVar.SQL_PASSWORD, (String) properties.get("sql-password"));
            }
        } catch (IOException ignored) {
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ignored) {
            }
        }

        /*try {
            Properties properties = new Properties();
            in = new FileInputStream("/home/data/redis.properties");
            properties.load(in);

            if (properties.containsKey("redis-host")
                    && properties.containsKey("redis-port")
                    && properties.containsKey("redis-password")) {
                variables.put(REDIS_HOST, (String) properties.get("redis-host"));
                variables.put(REDIS_PORT, (String) properties.get("redis-port"));
                variables.put(REDIS_PASSWORD, (String) properties.get("redis-password"));
            }
        } catch (IOException ignored) {
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ignored) {
            }
        }*/

        return variables;
    }

}
