/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.redis;

import org.redisson.api.RList;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;

import java.util.List;
import java.util.Map;

public interface RedisManager {

    void initConnection();

    void closeConnection();

    RedissonClient getRedissonClient();

    String getRedisString(String key);

    void setRedisString(String key, String value);

    long getRedisLong(String key);

    void setRedisLong(String key, long value);

    Object getRedisObject(String key);

    void setRedisObject(String key, Object value);

    void setRedisDouble(String key, double value);

    double getRedisDouble(String key);

    boolean getRedisBoolean(String key);

    void setRedisBoolean(String key, boolean value);

    boolean containsKey(String key);

    <V> RList<V> getRedisList(String key);

    <V> void setRedisList(String key, List<V> list);

    <K, V> RMap<K, V> getRedisMap(String key);

    <K, V> void setRedisMap(String key, Map<K, V> map);

    void clone(String from, String to);

}
