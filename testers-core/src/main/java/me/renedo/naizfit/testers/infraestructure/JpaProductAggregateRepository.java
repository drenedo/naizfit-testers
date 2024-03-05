package me.renedo.naizfit.testers.infraestructure;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import me.renedo.naizfit.testers.domain.ProductAggregate;
import me.renedo.naizfit.testers.domain.ProductAggregateRepository;
import me.renedo.naizfit.testers.infraestructure.jpa.BrandEntity;
import me.renedo.naizfit.testers.infraestructure.jpa.BrandEntityRepository;
import me.renedo.naizfit.testers.infraestructure.jpa.ProductEntityRepository;
import me.renedo.naizfit.testers.infraestructure.jpa.TestEntityRepository;

@Component
public class JpaProductAggregateRepository implements ProductAggregateRepository {


    private final ProductEntityRepository productEntityRepository;

    private final TestEntityRepository testEntityRepository;

    private final BrandEntityRepository brandEntityRepository;

    public JpaProductAggregateRepository(ProductEntityRepository productEntityRepository, TestEntityRepository testEntityRepository, BrandEntityRepository brandEntityRepository) {
        this.productEntityRepository = productEntityRepository;
        this.testEntityRepository = testEntityRepository;
        this.brandEntityRepository = brandEntityRepository;
    }

    @Override
    public Optional<ProductAggregate> findById(UUID id) {
        return productEntityRepository.findById(id).map(DomainEntityMapper::toProductAggregate);
    }

    @Override
    public void save(ProductAggregate productAggregate) {
        BrandEntity brandEntity = brandEntityRepository.findById(productAggregate.getProduct().getBrand().getId())
                .orElseGet(() -> brandEntityRepository.save(DomainEntityMapper.toBrandEntity(productAggregate.getProduct().getBrand())));
        productEntityRepository.save(DomainEntityMapper.toProductEntity(productAggregate.getProduct(), brandEntity));
    }

    @Override
    public void delete(ProductAggregate productAggregate) {
        testEntityRepository.deleteAll(testEntityRepository.findByProductId(productAggregate.getProductId()));
        productEntityRepository.deleteById(productAggregate.getProductId());
    }
}
