package me.renedo.naizfit.testers.application;

import java.util.UUID;

import me.renedo.naizfit.testers.application.tester.DeleteTesterCommand;

public class DeleteTesterCommandMother {

    public static DeleteTesterCommand any() {
        return new DeleteTesterCommand(UUID.randomUUID());
    }
}
