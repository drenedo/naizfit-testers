package me.renedo.naizfit.testers.domain;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;

import me.renedo.naizfit.testers.application.tester.CreateTesterCommand;

public class TesterAggregateMother {

    private final static EasyRandom easyRandom = new EasyRandom(new EasyRandomParameters());

    public static TesterAggregate any() {
        return easyRandom.nextObject(TesterAggregate.class);
    }

    public static TesterAggregate from(CreateTesterCommand command) {
        return new TesterAggregate(TesterMother.from(command));
    }
}
