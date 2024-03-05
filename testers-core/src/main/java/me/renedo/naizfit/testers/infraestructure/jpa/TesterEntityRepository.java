package me.renedo.naizfit.testers.infraestructure.jpa;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

public interface TesterEntityRepository extends CrudRepository<TesterEntity, UUID> {

    Optional<TesterEntity> findByEmail(String email);
}
