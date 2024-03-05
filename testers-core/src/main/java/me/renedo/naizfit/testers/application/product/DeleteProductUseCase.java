package me.renedo.naizfit.testers.application.product;

import org.springframework.stereotype.Component;

import me.renedo.naizfit.testers.domain.ProductAggregate;
import me.renedo.naizfit.testers.domain.ProductAggregateRepository;

@Component
public class DeleteProductUseCase {

    private final ProductAggregateRepository productAggregateRepository;

    public DeleteProductUseCase(ProductAggregateRepository productAggregateRepository) {
        this.productAggregateRepository = productAggregateRepository;
    }

    public void execute(DeleteProductCommand command) {
        ProductAggregate productAggregate = productAggregateRepository.findById(command.id())
                .orElseThrow(() -> ProductNotFoundException.withId(command.id()));
        productAggregateRepository.delete(productAggregate);
    }
}
