package me.renedo.naizfit.testers.application;


import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import me.renedo.naizfit.testers.domain.BirthDate;
import me.renedo.naizfit.testers.domain.Dimension;
import me.renedo.naizfit.testers.domain.Email;
import me.renedo.naizfit.testers.domain.Name;
import me.renedo.naizfit.testers.domain.Sex;
import me.renedo.naizfit.testers.domain.Tester;
import me.renedo.naizfit.testers.domain.TesterAggregate;
import me.renedo.naizfit.testers.domain.TesterAggregateRepository;
import me.renedo.naizfit.testers.domain.TestsDone;

@Component
public class CreateTesterUseCase {

    private final TesterAggregateRepository testerRepository;

    public CreateTesterUseCase(TesterAggregateRepository testerRepository) {
        this.testerRepository = testerRepository;
    }


    public void execute(CreateTesterCommand command) {
        TesterAggregate testerAggregate = toDomain(command);
        testerRepository.save(testerAggregate);
    }

    private TesterAggregate toDomain(CreateTesterCommand command) {
        return new TesterAggregate(new Tester(command.id(), new Name(command.name()), new Email(command.email()), command.password(),
                new BirthDate(command.birthDate()), Sex.valueOf(command.sex()), new TestsDone(0),
                command.measures().stream()
                        .map(measure -> new me.renedo.naizfit.testers.domain.Measure(measure.id(), LocalDateTime.now(), new Dimension(measure.height()),
                                new Dimension(measure.weight()))).toList()));
    }
}
