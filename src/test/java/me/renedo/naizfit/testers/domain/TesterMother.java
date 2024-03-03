package me.renedo.naizfit.testers.domain;

import java.time.LocalDateTime;

import me.renedo.naizfit.testers.application.CreateTesterCommand;

public class TesterMother {
    public static Tester from(CreateTesterCommand command) {
        return new Tester(command.id(), new Name(command.name()), new Email(command.email()), command.password(), new BirthDate(command.birthDate()),
                Sex.valueOf(command.sex()), new TestsDone(0), command.measures().stream()
                .map(measure -> new Measure(measure.id(), LocalDateTime.now(), new Dimension(measure.height()), new Dimension(measure.weight())))
                .toList());
    }
}
