package me.renedo.naizfit.testers.application;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.ApplicationEventPublisher;

import me.renedo.naizfit.testers.domain.Product;
import me.renedo.naizfit.testers.domain.ProductMother;
import me.renedo.naizfit.testers.domain.ProductRepository;
import me.renedo.naizfit.testers.domain.TestAggregateRepository;
import me.renedo.naizfit.testers.domain.Tester;
import me.renedo.naizfit.testers.domain.TesterMother;
import me.renedo.naizfit.testers.domain.TesterRepository;

class CreateTestUseCaseTest {

    private final TestAggregateRepository testRepository = Mockito.mock(TestAggregateRepository.class);

    private final TesterRepository testerRepository = Mockito.mock(TesterRepository.class);

    private final ApplicationEventPublisher eventPublisher = Mockito.mock(ApplicationEventPublisher.class);

    private final ProductRepository productRepository = Mockito.mock(ProductRepository.class);

    private final CreateTestUseCase createTestUseCase = new CreateTestUseCase(testRepository, eventPublisher, productRepository, testerRepository);

    @Test
    void should_raise_error_when_product_does_not_exits() {
        // given
        CreateTestCommand command = CreateTestCommandMother.any();
        when(testerRepository.findById(command.testerId())).thenReturn(Optional.of(TesterMother.any()));
        when(productRepository.findById(command.productId())).thenReturn(Optional.empty());

        // when
        Assertions.assertThrows(ProductNotFoundException.class, () -> createTestUseCase.execute(command));
    }

    @Test
    void should_raise_error_when_tester_does_not_exits() {
        // given
        CreateTestCommand command = CreateTestCommandMother.any();
        when(productRepository.findById(command.productId())).thenReturn(Optional.of(ProductMother.any()));
        when(testerRepository.findById(command.testerId())).thenReturn(Optional.empty());

        // when
        Assertions.assertThrows(TesterNotFoundException.class, () -> createTestUseCase.execute(command));
    }

    @Test
    void should_call_repository() {
        // given
        CreateTestCommand command = CreateTestCommandMother.any();
        Tester tester = TesterMother.any();
        when(testerRepository.findById(command.testerId())).thenReturn(Optional.of(tester));
        Product product = ProductMother.any();
        when(productRepository.findById(command.productId())).thenReturn(Optional.of(product));

        // when
        createTestUseCase.execute(command);

        // then
        verify(testRepository).save(Mockito.any());
        verify(eventPublisher).publishEvent(TestCreatedCommandMother.from(command, product));
    }
}
