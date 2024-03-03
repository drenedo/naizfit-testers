package me.renedo.naizfit.testers.application;

import java.util.UUID;

public class DeleteProductCommandMother {

    public static DeleteProductCommand any(){
        return new DeleteProductCommand(UUID.randomUUID());
    }
}
