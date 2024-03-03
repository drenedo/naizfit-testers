package me.renedo.naizfit.testers.domain;

public class TesterAggregate {

    private final Tester tester;

    public TesterAggregate(Tester tester) {
        this.tester = tester;
    }

    public Tester getTester() {
        return tester;
    }
}
