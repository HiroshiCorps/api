/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.utils.randomizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class ListRandomizer<K>  implements Randomizer<K>{

    List<K> randomizer = new ArrayList<>();

    public void addItem(K k){
        randomizer.add(k);
    }

    public void addAllItem(Collection<K> kList){
        randomizer.addAll(kList);
    }

    @Override
    public K getRandom(){
        return randomizer.get(new Random().nextInt(randomizer.size()));
    }

    public K getRandomAndRemove(){
        K k = getRandom();
        randomizer.remove(k);
        return k;
    }

}
