package me.renedo.naizfit.testers.application;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;


public record CreateTesterCommand(UUID id, String name, String email, String password, LocalDate birthDate, String sex, Set<Measure> measures) {

    public record Measure(UUID id, Double height, Double weight) {
    }
}
