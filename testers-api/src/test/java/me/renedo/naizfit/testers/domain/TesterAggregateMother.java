package me.renedo.naizfit.testers.domain;

public class TesterAggregateMother {

    public static TesterAggregate any() {
        return new TesterAggregate(TesterMother.any());
    }
}
