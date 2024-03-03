package me.renedo.naizfit.testers.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class BirthDateTest {

    @Test
    void should_raise_error_when_birth_date_is_null() {
        // when
        assertThrows(BirthDateEmptyException.class, () -> new BirthDate(null));
    }

    @Test
    void should_raise_error_when_birth_date_is_invalid() {
        // when
        assertThrows(BirthDateInvalidException.class, () -> new BirthDate(LocalDate.now().plusDays(1)));
    }

    @Test
    void should_construct_when_birth_date_is_ok() {
        // when
        BirthDate birthDate = new BirthDate(LocalDate.now().minusYears(20));

        // then
        assertEquals(birthDate.getValue(), LocalDate.now().minusYears(20));
    }
}
