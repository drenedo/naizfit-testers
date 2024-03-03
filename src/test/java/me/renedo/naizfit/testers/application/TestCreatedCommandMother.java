package me.renedo.naizfit.testers.application;

import me.renedo.naizfit.testers.domain.Product;

public class TestCreatedCommandMother {
    public static TestCreatedCommand from(CreateTestCommand command, Product product) {
        return new TestCreatedCommand(command.id(), product.getId());
    }
}
