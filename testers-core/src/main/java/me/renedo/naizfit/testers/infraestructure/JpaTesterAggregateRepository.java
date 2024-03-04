package me.renedo.naizfit.testers.infraestructure;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import me.renedo.naizfit.testers.domain.Measure;
import me.renedo.naizfit.testers.domain.TesterAggregate;
import me.renedo.naizfit.testers.domain.TesterAggregateRepository;
import me.renedo.naizfit.testers.infraestructure.jpa.MeasureEntity;
import me.renedo.naizfit.testers.infraestructure.jpa.MeasureEntityRepository;
import me.renedo.naizfit.testers.infraestructure.jpa.TesterEntityRepository;

@Component
public class JpaTesterAggregateRepository implements TesterAggregateRepository {

    private final TesterEntityRepository testerEntityRepository;

    private final MeasureEntityRepository measureEntityRepository;

    public JpaTesterAggregateRepository(TesterEntityRepository testerEntityRepository, MeasureEntityRepository measureEntityRepository) {
        this.testerEntityRepository = testerEntityRepository;
        this.measureEntityRepository = measureEntityRepository;
    }

    @Override
    public Optional<TesterAggregate> findById(UUID id) {
        return testerEntityRepository.findById(id).map(DomainEntityMapper::toTesterAggregate);
    }

    @Override
    public void save(TesterAggregate testerAggregate) {
        Set<MeasureEntity> measureEntities = testerAggregate.getTester().getMeasures().stream()
                .map(this::findOrCreateMeasureEntity)
                .collect(Collectors.toSet());
        testerEntityRepository.save(DomainEntityMapper.toTesterEntity(testerAggregate.getTester(), measureEntities));
    }

    private MeasureEntity findOrCreateMeasureEntity(Measure measure) {
        return measureEntityRepository.findById(measure.getId())
                .orElseGet(() -> measureEntityRepository.save(DomainEntityMapper.toMeasureEntity(measure)));
    }

    @Override
    public void delete(TesterAggregate testerAggregate) {
        testerEntityRepository.deleteById(testerAggregate.getTester().getId());
    }
}
