package me.renedo.naizfit.testers.infraestructure;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import me.renedo.naizfit.testers.domain.TesterAggregate;
import me.renedo.naizfit.testers.domain.TesterAggregateRepository;

@Component
public class JpaMemoryTesterAggregateRepository implements TesterAggregateRepository {
    @Override
    public Optional<TesterAggregate> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public void save(TesterAggregate testerAggregate) {

    }

    @Override
    public void delete(TesterAggregate testerAggregate) {

    }
}
