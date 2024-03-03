package me.renedo.naizfit.testers.application;

import static org.mockito.Mockito.verify;
import static org.springframework.test.util.AssertionErrors.fail;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import me.renedo.naizfit.testers.domain.TesterAggregate;
import me.renedo.naizfit.testers.domain.TesterAggregateMother;
import me.renedo.naizfit.testers.domain.TesterAggregateRepository;

class CreateTesterUseCaseTest {

    private final TesterAggregateRepository repository = Mockito.mock(TesterAggregateRepository.class);

    private final CreateTesterUseCase useCase = new CreateTesterUseCase(repository);

    @Test
    void should_call_repository() {
        // given
        CreateTesterCommand command = CreateTesterCommandMother.any() ;

        // when
        useCase.execute(command);

        // then
        ArgumentCaptor<TesterAggregate> captor = ArgumentCaptor.forClass(TesterAggregate.class);
        verify(repository).save(captor.capture());
        Assertions.assertThat(captor.getValue()).usingRecursiveComparison().isEqualTo(TesterAggregateMother.from(command));
    }

}
