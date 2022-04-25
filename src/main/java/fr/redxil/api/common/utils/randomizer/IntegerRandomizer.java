/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.utils.randomizer;

import java.util.Random;

public class IntegerRandomizer implements Randomizer<Integer> {

    final int min, max;

    public IntegerRandomizer(int min, int max) {
        this.max = max;
        this.min = min;
    }

    @Override
    public Integer getRandom() {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        return new Random().nextInt((max - min) + 1) + min;
    }
}
