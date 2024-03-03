package me.renedo.naizfit.testers.infraestructure;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import me.renedo.naizfit.testers.domain.Tester;
import me.renedo.naizfit.testers.domain.TesterRepository;

@Component
public class InMemoryTesterRepository implements TesterRepository {
    @Override
    public Optional<Tester> findById(UUID id) {
        return Optional.empty();
    }
}
