package me.renedo.naizfit.testers.infraestructure.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

public interface TestEntityRepository extends CrudRepository<TestEntity, UUID> {

    List<TestEntity> findByProductId(UUID id);
}
