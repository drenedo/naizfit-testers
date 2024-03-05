package me.renedo.naizfit.testers.domain;

import org.jeasy.random.EasyRandom;

import me.renedo.naizfit.testers.application.product.CreateProductCommand;

public class ProductAggregateMother {

    private static final EasyRandom EASY_RANDOM = new EasyRandom();

    public static ProductAggregate any() {
        return EASY_RANDOM.nextObject(ProductAggregate.class);
    }

    public static ProductAggregate from(CreateProductCommand command) {
        return new ProductAggregate(ProductMother.from(command));
    }
}
