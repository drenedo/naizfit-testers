package me.renedo.naizfit.testers.domain;

import java.util.Optional;
import java.util.UUID;

public interface TestAggregateRepository {

    void save(TestAggregate testAggregate);

    Optional<TestAggregate> findById(UUID id);
}
