package me.renedo.naizfit.testers.application;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.ApplicationEventPublisher;

import me.renedo.naizfit.testers.domain.TesterAggregate;
import me.renedo.naizfit.testers.domain.TesterAggregateMother;
import me.renedo.naizfit.testers.domain.TesterAggregateRepository;

class DeleteTesterUseCaseTest {
    private final TesterAggregateRepository testerRepository = Mockito.mock(TesterAggregateRepository.class);

    private final ApplicationEventPublisher eventPublisher = Mockito.mock(ApplicationEventPublisher.class);

    private final DeleteTesterUseCase deleteTesterUseCase = new DeleteTesterUseCase(testerRepository, eventPublisher);

    @Test
    void should_raise_error_when_tester_does_not_exist() {
        // given
        DeleteTesterCommand command = DeleteTesterCommandMother.any();

        // when
        Assertions.assertThrows(TesterNotFoundException.class, () -> deleteTesterUseCase.execute(command));
    }

    @Test
    void should_call_repository() {
        // given
        DeleteTesterCommand command = DeleteTesterCommandMother.any();
        TesterAggregate testerAggregate = TesterAggregateMother.any();
        when(testerRepository.findById(command.id())).thenReturn(Optional.of(testerAggregate));

        // when
        deleteTesterUseCase.execute(command);

        // then
        verify(testerRepository).delete(testerAggregate);
        verify(eventPublisher).publishEvent(TesterDeletedCommandMother.from(testerAggregate.getTester()));
    }

}
