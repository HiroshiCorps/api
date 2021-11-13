/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.utils.randomizer;

public class BooleanRandomizer implements Randomizer<Boolean> {

    PercentRandomizer<Boolean> percentRandomizer = new PercentRandomizer<>();

    public BooleanRandomizer(int luckTrue) throws IllegalArgumentException {
        if (luckTrue > 100)
            throw new IllegalArgumentException("Error, luck must be under or equivalent of 100");
        percentRandomizer.addItem(true, luckTrue);
        percentRandomizer.addItem(false, 100 - luckTrue);
    }

    @Override
    public Boolean getRandom() {
        return percentRandomizer.getRandom();
    }
}
