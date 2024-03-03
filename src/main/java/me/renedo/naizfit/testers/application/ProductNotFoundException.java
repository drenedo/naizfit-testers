package me.renedo.naizfit.testers.application;

import java.util.UUID;

public class ProductNotFoundException extends RuntimeException{

    private final UUID id;

    public ProductNotFoundException(UUID id) {
        this.id = id;
    }

    public static ProductNotFoundException withId(UUID id) {
        return new ProductNotFoundException(id);
    }
}
