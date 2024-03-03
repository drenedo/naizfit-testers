package me.renedo.naizfit.testers.application;

import java.util.UUID;

public class DeleteTesterCommandMother {

    public static DeleteTesterCommand any() {
        return new DeleteTesterCommand(UUID.randomUUID());
    }
}
