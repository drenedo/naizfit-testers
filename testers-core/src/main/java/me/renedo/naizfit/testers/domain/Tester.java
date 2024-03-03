package me.renedo.naizfit.testers.domain;

import java.util.Collection;
import java.util.UUID;

public class Tester {

    private final UUID id;

    private final Name name;

    private final Email email;

    private final String password;

    private final BirthDate birthDate;

    private final Sex sex;

    private final TestsDone testsDone;

    private final Collection<Measure> measures;

    public Tester(UUID id, Name name, Email email, String password, BirthDate birthDate, Sex sex, TestsDone testsDone, Collection<Measure> measures) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
        this.sex = sex;
        this.testsDone = testsDone;
        this.measures = measures;
    }

    public Email getEmail() {
        return email;
    }

    public UUID getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public BirthDate getBirthDate() {
        return birthDate;
    }

    public Sex getSex() {
        return sex;
    }

    public TestsDone getTestsDone() {
        return testsDone;
    }

    public Collection<Measure> getMeasures() {
        return measures;
    }
}
