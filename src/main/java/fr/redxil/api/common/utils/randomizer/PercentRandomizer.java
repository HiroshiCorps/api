package fr.redxil.api.common.utils.randomizer;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PercentRandomizer<K> implements Randomizer<K> {

    Map<K, Integer> kChanceMap;

    public PercentRandomizer() {
        this.kChanceMap = new HashMap<>();
    }

    public PercentRandomizer(Map<K, Integer> kChanceMap) {
        this.kChanceMap = kChanceMap;
    }

    public void addItem(K k, Integer chance) {
        kChanceMap.put(k, chance);
    }

    private int calcSum() {
        int sum = 0;
        for (int values : kChanceMap.values())
            sum += values;
        return sum;
    }

    @Override
    public K getRandom() {

        if (kChanceMap.isEmpty())
            return null;

        int randVal = new Random().nextInt(calcSum() + 1);
        int sumMin = 0;
        for (Map.Entry<K, Integer> entry : kChanceMap.entrySet()) {

            if (sumMin <= randVal && randVal <= sumMin + entry.getValue())
                return entry.getKey();
            else sumMin += entry.getValue();

        }
        return getRandom();

    }

    public K getRandomAndRemove() {

        K k = getRandom();

        kChanceMap.remove(k);

        return k;

    }

}
