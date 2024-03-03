package me.renedo.naizfit.testers.domain;

import org.jeasy.random.EasyRandom;

class NameMother {

    private final static EasyRandom EASY_RANDOM = new EasyRandom();

    public static Name any(){
        return EASY_RANDOM.nextObject(Name.class);
    }
}
