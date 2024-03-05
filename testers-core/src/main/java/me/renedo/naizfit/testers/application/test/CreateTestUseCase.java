package me.renedo.naizfit.testers.application.test;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import me.renedo.naizfit.testers.application.product.ProductNotFoundException;
import me.renedo.naizfit.testers.application.tester.TesterNotFoundException;
import me.renedo.naizfit.testers.domain.ProductRepository;
import me.renedo.naizfit.testers.domain.Size;
import me.renedo.naizfit.testers.domain.Test;
import me.renedo.naizfit.testers.domain.TestAggregate;
import me.renedo.naizfit.testers.domain.TestAggregateRepository;
import me.renedo.naizfit.testers.domain.TesterRepository;

@Component
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
        eventPublisher.publishEvent(new TestCreatedCommand(testAggregate.getTestId(), testAggregate.getTesterId()));
    }

    private TestAggregate toDomain(CreateTestCommand command) {
        return new TestAggregate(new Test(command.id(), testerRepository.findById(command.testerId())
                    .orElseThrow(() -> TesterNotFoundException.withId(command.testerId())),
                productRepository.findById(command.productId())
                    .orElseThrow(() -> ProductNotFoundException.withId(command.productId())), new Size(command.size())));
    }
}
