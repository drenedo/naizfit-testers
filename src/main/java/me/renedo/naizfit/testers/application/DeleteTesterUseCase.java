package me.renedo.naizfit.testers.application;

import org.springframework.context.ApplicationEventPublisher;

import me.renedo.naizfit.testers.domain.TesterAggregate;
import me.renedo.naizfit.testers.domain.TesterAggregateRepository;

public class DeleteTesterUseCase {

    private final TesterAggregateRepository repository;

    private final ApplicationEventPublisher eventPublisher;

    public DeleteTesterUseCase(TesterAggregateRepository repository, ApplicationEventPublisher eventPublisher) {
        this.repository = repository;
        this.eventPublisher = eventPublisher;
    }

    public void execute(DeleteTesterCommand command) {
        TesterAggregate testerAggregate = repository.findById(command.id())
                .orElseThrow(() -> TesterNotFoundException.withId(command.id()));
        repository.delete(testerAggregate);
        //TODO think about this
        eventPublisher.publishEvent(
                new TesterDeletedCommand(testerAggregate.getTester().getId()));
    }
}
