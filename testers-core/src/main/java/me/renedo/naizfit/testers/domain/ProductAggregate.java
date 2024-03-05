package me.renedo.naizfit.testers.domain;

import java.util.UUID;

public class ProductAggregate {

    private final Product product;

    public ProductAggregate(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public UUID getProductId(){
        return product.getId();
    }
}
