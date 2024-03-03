package me.renedo.naizfit.testers.domain;

import me.renedo.naizfit.testers.application.CreateProductCommand;

public class ProductMother {

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
            )
        );
    }
}
