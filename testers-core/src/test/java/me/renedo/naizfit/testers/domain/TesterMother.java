package me.renedo.naizfit.testers.domain;

import java.time.LocalDateTime;

import org.jeasy.random.EasyRandom;

import me.renedo.naizfit.testers.application.tester.CreateTesterCommand;

public class TesterMother {

    private final static EasyRandom EASY_RANDOM = new EasyRandom();

    public static Tester any() {
        return EASY_RANDOM.nextObject(Tester.class);
    }

    public static Tester from(CreateTesterCommand command) {
        return new Tester(command.id(), new Name(command.name()), new Email(command.email()), command.password(), new BirthDate(command.birthDate()),
                Sex.valueOf(command.sex()), new TestsDone(0), command.measures().stream()
                .map(measure -> new Measure(measure.id(), LocalDateTime.now(), new Dimension(measure.height()), new Dimension(measure.weight())))
                .toList());
    }
}
