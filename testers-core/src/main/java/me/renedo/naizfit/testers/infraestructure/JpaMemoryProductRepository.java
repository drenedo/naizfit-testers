package me.renedo.naizfit.testers.infraestructure;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import me.renedo.naizfit.testers.domain.Product;
import me.renedo.naizfit.testers.domain.ProductRepository;

@Component
public class JpaMemoryProductRepository implements ProductRepository {
    @Override
    public Optional<Product> findById(UUID id) {
        return Optional.empty();
    }
}
