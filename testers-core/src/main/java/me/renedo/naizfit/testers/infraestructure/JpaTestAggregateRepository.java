package me.renedo.naizfit.testers.infraestructure;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import me.renedo.naizfit.testers.application.product.ProductNotFoundException;
import me.renedo.naizfit.testers.application.tester.TesterNotFoundException;
import me.renedo.naizfit.testers.domain.TestAggregate;
import me.renedo.naizfit.testers.domain.TestAggregateRepository;
import me.renedo.naizfit.testers.infraestructure.jpa.ProductEntity;
import me.renedo.naizfit.testers.infraestructure.jpa.ProductEntityRepository;
import me.renedo.naizfit.testers.infraestructure.jpa.TestEntityRepository;
import me.renedo.naizfit.testers.infraestructure.jpa.TesterEntity;
import me.renedo.naizfit.testers.infraestructure.jpa.TesterEntityRepository;

@Component
public class JpaTestAggregateRepository implements TestAggregateRepository {

    private final ProductEntityRepository productEntityRepository;

    private final TesterEntityRepository testerEntityRepository;

    private final TestEntityRepository testEntityRepository;

    public JpaTestAggregateRepository(ProductEntityRepository productEntityRepository, TesterEntityRepository testerEntityRepository,
            TestEntityRepository testEntityRepository) {
        this.productEntityRepository = productEntityRepository;
        this.testerEntityRepository = testerEntityRepository;
        this.testEntityRepository = testEntityRepository;
    }

    @Override
    public void save(TestAggregate testAggregate) {
        ProductEntity productEntity = productEntityRepository.findById(testAggregate.getProductId())
                .orElseThrow(() -> new ProductNotFoundException(testAggregate.getProductId()));
        TesterEntity testerEntity = testerEntityRepository.findById(testAggregate.getTesterId())
                .orElseThrow(() -> new TesterNotFoundException(testAggregate.getTesterId()));
        testEntityRepository.save(DomainEntityMapper.toTestEntity(testAggregate.getTest(), productEntity, testerEntity));
    }

    @Override
    public Optional<TestAggregate> findById(UUID id) {
        return testEntityRepository.findById(id).map(DomainEntityMapper::toTestAggregate);
    }
}
