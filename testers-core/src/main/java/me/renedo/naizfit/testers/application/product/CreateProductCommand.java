package me.renedo.naizfit.testers.application.product;

import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public record CreateProductCommand(
    UUID id,
    String sku,
    List<String> sizes,
    Set<URL> pictures,
    String color,
    Brand brand
) {

    public record Brand(UUID id, String name, URL logo) {
    }
}
