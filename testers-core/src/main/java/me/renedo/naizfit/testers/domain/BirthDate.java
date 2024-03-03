package me.renedo.naizfit.testers.domain;

import java.time.LocalDate;

public class BirthDate {

    private final LocalDate value;

    public BirthDate(LocalDate value) {
        this.value = value;
        verify();
    }

    public LocalDate getValue() {
        return value;
    }

    public void verify() {
        if (value == null) {
            throw new BirthDateEmptyException();
        }
        if (value.isAfter(LocalDate.now())) {
            throw new BirthDateInvalidException();
        }
    }
}
