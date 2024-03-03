package me.renedo.naizfit.testers.domain;

import java.util.Optional;
import java.util.UUID;

public interface ProductAggregateRepository {

    Optional<ProductAggregate> findById(UUID id);

    void save(ProductAggregate productAggregate);

    void delete(ProductAggregate productAggregate);
}
