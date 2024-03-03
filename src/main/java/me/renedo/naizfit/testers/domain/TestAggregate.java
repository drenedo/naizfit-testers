package me.renedo.naizfit.testers.domain;

public class TestAggregate {

    private final Test test;

    public TestAggregate(Test test) {
        this.test = test;
    }

    public Test getTest() {
        return test;
    }
}
