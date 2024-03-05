package me.renedo.naizfit.testers.application.tester;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import me.renedo.naizfit.testers.application.test.TestCreatedCommand;
import me.renedo.naizfit.testers.domain.TesterAggregate;
import me.renedo.naizfit.testers.domain.TesterAggregateRepository;

@Component
public class UpdateTesterWhenTestCreatedUseCase {

    private final TesterAggregateRepository repository;

    private final TesterInstrumentation instrumentation;

    public UpdateTesterWhenTestCreatedUseCase(TesterAggregateRepository repository) {
        this.repository = repository;
        this.instrumentation = new TesterInstrumentation();
    }

    @EventListener
    public void execute(TestCreatedCommand command) {
        repository.findById(command.testerId())
                .ifPresentOrElse(this::increaseTestDoneAndUpdate,
                        () -> instrumentation.notifyError(command.testerId()));

    }

    private void increaseTestDoneAndUpdate(TesterAggregate testerAggregate) {
        repository.update(testerAggregate.increaseTestDone());
    }
}
