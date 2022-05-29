/*
 *
 * Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 * Unauthorized copying or modification of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.utils.id;

import fr.redxil.api.common.API;
import fr.redxil.api.common.redis.RedisManager;

import java.util.HashMap;
import java.util.Optional;

public class IDGenerator {

    public static HashMap<String, Long> idMap = new HashMap<>();

    public static int generateINTID(String idv) {
        return Long.valueOf(generateLONGID(idv)).intValue();
    }

    public static long generateLONGID(String idv) {
        Optional<RedisManager> rm = API.getInstance().getRedisManager();
        if (rm.isPresent()) {
            return rm.get().getRedissonClient().getIdGenerator(idv).nextId();
        } else {
            if (idMap.containsKey(idv)) {
                long newID = idMap.get(idv) + 1;
                idMap.replace(idv, newID);
                return newID;
            } else {
                idMap.put(idv, 1L);
                return 1L;
            }
        }
    }

    public static void resetID(String idv) {
        API.getInstance().getRedisManager().ifPresent(redis -> redis.getRedissonClient().getBucket(idv).delete());
    }

}
