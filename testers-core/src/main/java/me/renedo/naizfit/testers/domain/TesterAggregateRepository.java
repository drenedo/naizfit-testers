package me.renedo.naizfit.testers.domain;

import java.util.Optional;
import java.util.UUID;

public interface TesterAggregateRepository {

    Optional<TesterAggregate> findById(UUID id);

    void save(TesterAggregate testerAggregate);

    void delete(TesterAggregate testerAggregate);

    void update(TesterAggregate testerAggregate);

}
