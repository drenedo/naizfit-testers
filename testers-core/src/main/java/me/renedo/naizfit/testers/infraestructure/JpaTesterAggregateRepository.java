package me.renedo.naizfit.testers.infraestructure;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import me.renedo.naizfit.testers.domain.Measure;
import me.renedo.naizfit.testers.domain.TesterAggregate;
import me.renedo.naizfit.testers.domain.TesterAggregateRepository;
import me.renedo.naizfit.testers.infraestructure.jpa.MeasureEntity;
import me.renedo.naizfit.testers.infraestructure.jpa.MeasureEntityRepository;
import me.renedo.naizfit.testers.infraestructure.jpa.TesterEntity;
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
        TesterEntity testerEntity = testerEntityRepository.save(DomainEntityMapper.toTesterEntity(testerAggregate.getTester()));
        testerAggregate.getTester().getMeasures()
                .forEach(m -> findOrCreateMeasureEntity(m, testerEntity));
    }

    private MeasureEntity findOrCreateMeasureEntity(Measure measure, TesterEntity testerEntity) {
        return measureEntityRepository.findById(measure.getId())
                .orElseGet(() -> measureEntityRepository.save(DomainEntityMapper.toMeasureEntity(measure, testerEntity)));
    }

    @Override
    public void delete(TesterAggregate testerAggregate) {
        testerAggregate.getTester().getMeasures().forEach(m -> measureEntityRepository.deleteById(m.getId()));
        testerEntityRepository.deleteById(testerAggregate.getTesterId());
    }

    @Override
    public void update(TesterAggregate testerAggregate) {
        TesterEntity testerEntity = testerEntityRepository.save(DomainEntityMapper.toTesterEntity(testerAggregate.getTester()));
        testerAggregate.getTester().getMeasures().forEach(m -> measureEntityRepository.save(DomainEntityMapper.toMeasureEntity(m, testerEntity)));

    }
}
