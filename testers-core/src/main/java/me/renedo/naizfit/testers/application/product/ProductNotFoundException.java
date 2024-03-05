package me.renedo.naizfit.testers.application.product;

import java.util.UUID;

public class ProductNotFoundException extends RuntimeException{


    public ProductNotFoundException(UUID id) {
        super("Product with id " + id + " not found");
    }

    public static ProductNotFoundException withId(UUID id) {
        return new ProductNotFoundException(id);
    }
}
