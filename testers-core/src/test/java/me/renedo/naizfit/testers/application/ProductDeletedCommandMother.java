package me.renedo.naizfit.testers.application;

import java.util.UUID;

public class ProductDeletedCommandMother {
    public static ProductDeletedCommand from(UUID productId, UUID brandId) {
        return new ProductDeletedCommand(productId, brandId);
    }
}
