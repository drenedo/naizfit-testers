package me.renedo.naizfit.testers.domain;

import java.util.UUID;

public class Test {
    private final UUID id;

    private final Tester tester;

    private final Product product;

    private final Size size;

    public Test(UUID id, Tester tester, Product product, Size size) {
        this.id = id;
        this.tester = tester;
        this.product = product;
        this.size = size;
    }

    public UUID getId() {
        return id;
    }

    public Tester getTester() {
        return tester;
    }

    public Product getProduct() {
        return product;
    }

    public Size getSize() {
        return size;
    }
}
