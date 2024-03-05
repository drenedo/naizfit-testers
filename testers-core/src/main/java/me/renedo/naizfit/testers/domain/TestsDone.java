package me.renedo.naizfit.testers.domain;

public class TestsDone {

    private final int value;

    public TestsDone(int value) {
        this.value = value;
        verify();
    }

    public int getValue() {
        return value;
    }

    private void verify() {
        if(value < 0) {
            throw new TestsDoneInvalidException();
        }
    }

    public TestsDone increase() {
        return new TestsDone(value + 1);
    }
}
