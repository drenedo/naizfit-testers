package me.renedo.naizfit.testers.application;

import java.util.UUID;

public class TesterNotFoundException extends RuntimeException{

    private final UUID id;

    public TesterNotFoundException(UUID id) {
        this.id = id;
    }

    public static TesterNotFoundException withId(UUID id) {
        return new TesterNotFoundException(id);
    }
}
