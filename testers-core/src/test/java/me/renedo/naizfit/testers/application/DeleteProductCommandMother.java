package me.renedo.naizfit.testers.application;

import java.util.UUID;

import me.renedo.naizfit.testers.application.product.DeleteProductCommand;

public class DeleteProductCommandMother {

    public static DeleteProductCommand any(){
        return new DeleteProductCommand(UUID.randomUUID());
    }
}
