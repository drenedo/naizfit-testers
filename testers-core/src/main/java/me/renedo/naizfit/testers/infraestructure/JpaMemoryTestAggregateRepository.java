package me.renedo.naizfit.testers.infraestructure;

import org.springframework.stereotype.Component;

import me.renedo.naizfit.testers.domain.TestAggregate;
import me.renedo.naizfit.testers.domain.TestAggregateRepository;

@Component
public class JpaMemoryTestAggregateRepository implements TestAggregateRepository {
    @Override
    public void save(TestAggregate testAggregate) {

    }
}
