package me.renedo.naizfit.testers.domain;

import static org.junit.jupiter.api.Assertions.*;

import me.renedo.naizfit.testers.application.CreateProductCommand;

public class ProductAggregateMother {
    public static ProductAggregate from(CreateProductCommand command) {
        return new ProductAggregate(ProductMother.from(command));
    }
}
