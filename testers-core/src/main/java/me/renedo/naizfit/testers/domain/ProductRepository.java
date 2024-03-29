package me.renedo.naizfit.testers.domain;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepository {

    Optional<Product> findById(UUID id);
}
