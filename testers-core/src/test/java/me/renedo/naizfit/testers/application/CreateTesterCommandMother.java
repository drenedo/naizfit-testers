package me.renedo.naizfit.testers.application;

import java.time.LocalDate;
import java.util.UUID;
import java.util.stream.Collectors;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;

public class CreateTesterCommandMother {

    private final static EasyRandom easyRandom = new EasyRandom(new EasyRandomParameters()
            .dateRange(LocalDate.of(1800, 1, 1), LocalDate.now().minusYears(10)));

    public static CreateTesterCommand any() {
        return new CreateTesterCommand(UUID.randomUUID(), easyRandom.nextObject(String.class), "test@naiz.fit", easyRandom.nextObject(String.class),
                easyRandom.nextObject(LocalDate.class), "MALE",
                easyRandom.objects(Double.class, 3)
                        .map(v -> new CreateTesterCommand.Measure(UUID.randomUUID(), v, easyRandom.nextObject(Double.class)))
                        .collect(Collectors.toSet()));
    }
}
