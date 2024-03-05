package me.renedo.naizfit.testers.application;

import java.net.URL;
import java.util.UUID;
import java.util.stream.Collectors;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;

import me.renedo.naizfit.testers.application.product.CreateProductCommand;

class CreateProductCommandMother {

    private final static EasyRandom easyRandom = new EasyRandom(new EasyRandomParameters());

    public static CreateProductCommand any() {
        return new CreateProductCommand(UUID.randomUUID(), easyRandom.nextObject(String.class), easyRandom.objects(String.class, 3).toList(),
                easyRandom.objects(URL.class, 3).collect(Collectors.toSet()), easyRandom.nextObject(String.class),
                new CreateProductCommand.Brand(UUID.randomUUID(), easyRandom.nextObject(String.class), easyRandom.nextObject(URL.class)));
    }

}
