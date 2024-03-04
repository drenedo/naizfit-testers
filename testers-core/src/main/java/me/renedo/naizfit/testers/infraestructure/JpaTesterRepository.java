package me.renedo.naizfit.testers.infraestructure;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import me.renedo.naizfit.testers.domain.Tester;
import me.renedo.naizfit.testers.domain.TesterRepository;
import me.renedo.naizfit.testers.infraestructure.jpa.TesterEntityRepository;

@Component
public class JpaTesterRepository implements TesterRepository {

    private final TesterEntityRepository testerEntityRepository;

    public JpaTesterRepository(TesterEntityRepository testerEntityRepository) {
        this.testerEntityRepository = testerEntityRepository;
    }


    @Override
    public Optional<Tester> findById(UUID id) {
        return testerEntityRepository.findById(id).map(DomainEntityMapper::toTester);
    }
}
