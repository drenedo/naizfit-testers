package me.renedo.naizfit.testers.application;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import me.renedo.naizfit.testers.domain.ProductAggregate;
import me.renedo.naizfit.testers.domain.ProductAggregateRepository;

@Component
public class DeleteProductUseCase {

    private final ProductAggregateRepository productAggregateRepository;

    private final ApplicationEventPublisher eventPublisher;

    public DeleteProductUseCase(ProductAggregateRepository productAggregateRepository, ApplicationEventPublisher eventPublisher) {
        this.productAggregateRepository = productAggregateRepository;
        this.eventPublisher = eventPublisher;
    }

    public void execute(DeleteProductCommand command) {
        ProductAggregate productAggregate = productAggregateRepository.findById(command.id())
                .orElseThrow(() -> ProductNotFoundException.withId(command.id()));
        productAggregateRepository.delete(productAggregate);
        //TODO think about this
        eventPublisher.publishEvent(
                new ProductDeletedCommand(productAggregate.getProduct().getId(), productAggregate.getProduct().getBrand().getId()));
    }
}
