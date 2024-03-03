package me.renedo.naizfit.testers.application;

import me.renedo.naizfit.testers.domain.Brand;
import me.renedo.naizfit.testers.domain.Name;
import me.renedo.naizfit.testers.domain.Product;
import me.renedo.naizfit.testers.domain.ProductAggregate;
import me.renedo.naizfit.testers.domain.ProductAggregateRepository;
import me.renedo.naizfit.testers.domain.SKU;
import me.renedo.naizfit.testers.domain.Size;
import me.renedo.naizfit.testers.domain.Sizes;

public class CreateProductUseCase {

    private final ProductAggregateRepository repository;

    public CreateProductUseCase(ProductAggregateRepository repository) {
        this.repository = repository;
    }

    public void execute(CreateProductCommand command) {
        ProductAggregate product = toDomain(command);
        repository.save(product);
    }

    private ProductAggregate toDomain(CreateProductCommand command) {
        Brand brand = new Brand(command.brand().id(), new Name(command.brand().name()), command.brand().logo());
        Product product = new Product(command.id(), new SKU(command.sku()), new Sizes(command.sizes().stream().map(Size::new).toList()), command.pictures(), brand);
        return new ProductAggregate(product);
    }
}
