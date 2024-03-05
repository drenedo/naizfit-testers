package me.renedo.naizfit.testers.application;

import java.util.UUID;

import me.renedo.naizfit.testers.application.test.CreateTestCommand;

public class CreateTestCommandMother {

    public static CreateTestCommand any() {
        return new CreateTestCommand(UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(), "M");
    }
}
