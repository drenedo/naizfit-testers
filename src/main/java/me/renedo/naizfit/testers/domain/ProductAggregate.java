package me.renedo.naizfit.testers.domain;

public class ProductAggregate {

    private final Product product;

    public ProductAggregate(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }
}
