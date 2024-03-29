package me.renedo.naizfit.testers.domain;

import java.net.URL;
import java.util.Set;
import java.util.UUID;

public class Product {

    private final UUID id;

    private final SKU sku;

    private final Sizes sizes;

    private final Set<URL> pictures;

    private final Brand brand;

    private final String color;

    public Product(UUID id, SKU sku, Sizes sizes, Set<URL> pictures, Brand brand, String color) {
        this.id = id;
        this.sku = sku;
        this.sizes = sizes;
        this.pictures = pictures;
        this.brand = brand;
        this.color = color;
        verify();
    }

    public String getColor() {
        return color;
    }

    public UUID getId() {
        return id;
    }

    public SKU getSku() {
        return sku;
    }

    public Sizes getSizes() {
        return sizes;
    }

    public Set<URL> getPictures() {
        return pictures;
    }

    public Brand getBrand() {
        return brand;
    }


    private void verify() {
        if(id == null) {
            throw new ProductWithOutIdException();
        }
    }
}
