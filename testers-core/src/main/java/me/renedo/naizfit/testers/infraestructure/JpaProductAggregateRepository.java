package me.renedo.naizfit.testers.infraestructure;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import me.renedo.naizfit.testers.domain.ProductAggregate;
import me.renedo.naizfit.testers.domain.ProductAggregateRepository;

@Component
public class JpaProductAggregateRepository implements ProductAggregateRepository {
    @Override
    public Optional<ProductAggregate> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public void save(ProductAggregate productAggregate) {

    }

    @Override
    public void delete(ProductAggregate productAggregate) {

    }
}
