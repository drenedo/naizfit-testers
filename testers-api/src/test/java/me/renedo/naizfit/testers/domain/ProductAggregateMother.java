package me.renedo.naizfit.testers.domain;

import org.jeasy.random.EasyRandom;

public class ProductAggregateMother {

    private static final EasyRandom EASY_RANDOM = new EasyRandom();

    public static ProductAggregate any() {
        return EASY_RANDOM.nextObject(ProductAggregate.class);
    }
}
