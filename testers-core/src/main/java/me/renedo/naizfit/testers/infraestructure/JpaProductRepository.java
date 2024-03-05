package me.renedo.naizfit.testers.infraestructure;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import me.renedo.naizfit.testers.domain.Product;
import me.renedo.naizfit.testers.domain.ProductRepository;
import me.renedo.naizfit.testers.infraestructure.jpa.ProductEntityRepository;

@Component
public class JpaProductRepository implements ProductRepository {

    private final ProductEntityRepository productEntityRepository;

    public JpaProductRepository(ProductEntityRepository productEntityRepository) {
        this.productEntityRepository = productEntityRepository;
    }

    @Override
    public Optional<Product> findById(UUID id) {
        return productEntityRepository.findById(id).map(DomainEntityMapper::toProduct);
    }
}
