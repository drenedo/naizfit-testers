package me.renedo.naizfit.testers.application;

import org.springframework.context.ApplicationEventPublisher;

import me.renedo.naizfit.testers.domain.ProductRepository;
import me.renedo.naizfit.testers.domain.Size;
import me.renedo.naizfit.testers.domain.Test;
import me.renedo.naizfit.testers.domain.TestAggregate;
import me.renedo.naizfit.testers.domain.TestAggregateRepository;
import me.renedo.naizfit.testers.domain.TesterRepository;

public class CreateTestUseCase {

    private final TestAggregateRepository testRepository;

    private final ApplicationEventPublisher eventPublisher;

    private final ProductRepository productRepository;

    private final TesterRepository testerRepository;

    public CreateTestUseCase(TestAggregateRepository repository, ApplicationEventPublisher eventPublisher, ProductRepository productRepository,
            TesterRepository testerRepository) {
        this.testRepository = repository;
        this.eventPublisher = eventPublisher;
        this.productRepository = productRepository;
        this.testerRepository = testerRepository;
    }

    public void execute(CreateTestCommand command) {
        TestAggregate testAggregate = toDomain(command);
        testRepository.save(testAggregate);
        eventPublisher.publishEvent(new TestCreatedCommand(testAggregate.getTest().getId(), testAggregate.getTest().getTester().getId()));
    }

    private TestAggregate toDomain(CreateTestCommand command) {
        return new TestAggregate(new Test(command.id(), testerRepository.findById(command.testerId())
                    .orElseThrow(() -> TesterNotFoundException.withId(command.testerId())),
                productRepository.findById(command.productId())
                    .orElseThrow(() -> ProductNotFoundException.withId(command.productId())), new Size(command.size())));
    }
}
