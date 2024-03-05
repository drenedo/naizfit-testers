package me.renedo.naizfit.testers.application;

import static org.mockito.Mockito.verify;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import me.renedo.naizfit.testers.application.product.CreateProductCommand;
import me.renedo.naizfit.testers.application.product.CreateProductUseCase;
import me.renedo.naizfit.testers.domain.ProductAggregate;
import me.renedo.naizfit.testers.domain.ProductAggregateMother;
import me.renedo.naizfit.testers.domain.ProductAggregateRepository;

class CreateProductUseCaseTest {

    private final ProductAggregateRepository repository = Mockito.mock(ProductAggregateRepository.class);

    private final CreateProductUseCase useCase = new CreateProductUseCase(repository);

    @Test
    void should_call_repository() {
        // given
        CreateProductCommand command = CreateProductCommandMother.any() ;

        // when
        useCase.execute(command);

        // then
        ArgumentCaptor<ProductAggregate> captor = ArgumentCaptor.forClass(ProductAggregate.class);
        verify(repository).save(captor.capture());
        Assertions.assertThat(captor.getValue()).usingRecursiveComparison().isEqualTo(ProductAggregateMother.from(command));
    }
}
