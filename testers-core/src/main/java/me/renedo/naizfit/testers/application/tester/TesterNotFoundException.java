package me.renedo.naizfit.testers.application.tester;

import java.util.UUID;

public class TesterNotFoundException extends RuntimeException{


    public TesterNotFoundException(UUID id) {
        super("Tester with id " + id + " not found");
    }

    public static TesterNotFoundException withId(UUID id) {
        return new TesterNotFoundException(id);
    }
}
