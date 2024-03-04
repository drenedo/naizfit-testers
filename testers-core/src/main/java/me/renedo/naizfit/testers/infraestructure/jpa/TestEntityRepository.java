package me.renedo.naizfit.testers.infraestructure.jpa;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

public interface TestEntityRepository extends CrudRepository<TestEntity, UUID> {

}
