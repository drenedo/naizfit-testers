package me.renedo.naizfit.testers.domain;

import org.jeasy.random.EasyRandom;

class SizeMother {

    private final static EasyRandom EASY_RANDOM = new EasyRandom();

    public static Size any(){
        return EASY_RANDOM.nextObject(Size.class);
    }
}
