package me.renedo.naizfit.testers.domain;

import java.util.UUID;

public class TestAggregate {

    private final Test test;

    public TestAggregate(Test test) {
        this.test = test;
    }

    public Test getTest() {
        return test;
    }

    public UUID getProductId(){
        return test.getProduct().getId();
    }

    public UUID getTesterId(){
        return test.getTester().getId();
    }

    public UUID getTestId(){
        return test.getId();
    }
}
