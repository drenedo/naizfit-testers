package me.renedo.naizfit.testers.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.jeasy.random.EasyRandom;

class BrandMother {

    public static Brand any(){
        return new EasyRandom().nextObject(Brand.class);
    }
}
