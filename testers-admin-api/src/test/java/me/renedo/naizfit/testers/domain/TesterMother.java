package me.renedo.naizfit.testers.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.stream.Collectors;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;

public class TesterMother {

    private final static EasyRandom EASY_RANDOM = new EasyRandom(new EasyRandomParameters()
            .dateRange(LocalDate.of(1800, 1, 1), LocalDate.now().minusYears(10)));

    public static Tester any() {
        return new Tester(UUID.randomUUID(), new Name(EASY_RANDOM.nextObject(String.class)), new Email("tester@naiz.fit"),
                EASY_RANDOM.nextObject(String.class), EASY_RANDOM.nextObject(BirthDate.class),
                EASY_RANDOM.nextObject(Sex.class), new TestsDone(0), EASY_RANDOM.objects(Double.class, 3)
                .map(v -> new Measure(UUID.randomUUID(), EASY_RANDOM.nextObject(LocalDateTime.class), EASY_RANDOM.nextObject(Dimension.class),
                        EASY_RANDOM.nextObject(Dimension.class)))
                .collect(Collectors.toSet()));
    }
}
