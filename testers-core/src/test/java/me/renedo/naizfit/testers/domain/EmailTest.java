package me.renedo.naizfit.testers.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class EmailTest {

    @Test
    void should_raise_error_when_email_is_invalid() {
        // when
        assertThrows(EmailInvalidException.class, () -> new Email("invalid"));
    }

    @Test
    void should_raise_error_when_email_is_null() {
        // when
        assertThrows(EmailInvalidException.class, () -> new Email("null"));
    }

    @Test
    void should_construct_when_email_is_ok() {
        // when
        Email email = new Email("test@naiz.fit");

        // then
        Assertions.assertThat(email.getValue()).isEqualTo("test@naiz.fit");
    }
}
