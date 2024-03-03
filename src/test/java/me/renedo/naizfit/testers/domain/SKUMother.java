package me.renedo.naizfit.testers.domain;

import org.jeasy.random.EasyRandom;

public class SKUMother {

    public static SKU any(){
        return new EasyRandom().nextObject(SKU.class);
    }
}
