package me.renedo.naizfit.testers.application;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.ApplicationEventPublisher;

import me.renedo.naizfit.testers.domain.ProductAggregate;
import me.renedo.naizfit.testers.domain.ProductAggregateMother;
import me.renedo.naizfit.testers.domain.ProductAggregateRepository;

class DeleteProductUseCaseTest {

    private final ProductAggregateRepository productRepository = Mockito.mock(ProductAggregateRepository.class);

    private final ApplicationEventPublisher eventPublisher = Mockito.mock(ApplicationEventPublisher.class);

    private final DeleteProductUseCase deleteProductUseCase = new DeleteProductUseCase(productRepository, eventPublisher);

    @Test
    void should_raise_error_when_product_does_not_exist() {
        // given
        DeleteProductCommand command = DeleteProductCommandMother.any();

        // when
        assertThrows(ProductNotFoundException.class, () -> deleteProductUseCase.execute(command));
    }

    @Test
    void should_call_repository() {
        // given
        DeleteProductCommand command = DeleteProductCommandMother.any();
        ProductAggregate productAggregate = ProductAggregateMother.any();
        when(productRepository.findById(command.id())).thenReturn(Optional.of(productAggregate));

        // when
        deleteProductUseCase.execute(command);

        // then
        verify(productRepository).delete(productAggregate);
        verify(eventPublisher).publishEvent(
                ProductDeletedCommandMother.from(productAggregate.getProduct().getId(), productAggregate.getProduct().getBrand().getId()));
    }
}
