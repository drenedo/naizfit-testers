package me.renedo.naizfit.testers.domain;

import org.jeasy.random.EasyRandom;

import me.renedo.naizfit.testers.application.product.CreateProductCommand;

public class ProductMother {

    private final static EasyRandom EASY_RANDOM = new EasyRandom();

    public static Product any() {
        return EASY_RANDOM.nextObject(Product.class);
    }

    public static Product from(CreateProductCommand command) {
        return new Product(
            command.id(),
            new SKU(command.sku()),
            new Sizes(command.sizes().stream().map(Size::new).toList()),
            command.pictures(),
            new Brand(
                command.brand().id(),
                new Name(command.brand().name()),
                command.brand().logo()
            ),
                command.color());
    }
}
