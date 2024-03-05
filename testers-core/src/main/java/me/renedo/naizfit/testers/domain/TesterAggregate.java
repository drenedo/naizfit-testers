package me.renedo.naizfit.testers.domain;

import java.util.UUID;

public class TesterAggregate {

    private final Tester tester;

    public TesterAggregate(Tester tester) {
        this.tester = tester;
    }

    public Tester getTester() {
        return tester;
    }

    public TesterAggregate increaseTestDone() {
        return new TesterAggregate(new Tester(tester.getId(), tester.getName(), tester.getEmail(), tester.getPassword(),
                tester.getBirthDate(), tester.getSex(), tester.getTestsDone().increase(), tester.getMeasures()));
    }

    public UUID getTesterId(){
        return tester.getId();
    }
}
