package me.renedo.naizfit.testers.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class NameTest {

    @Test
    public void should_raise_error_when_empty_name(){
        // when
        assertThrows(NameEmptyException.class, () -> new Name(""));
    }

    @Test
    public void should_raise_error_when_name_is_null(){
        // when
        assertThrows(NameEmptyException.class, () -> new Name(null));
    }


    @Test
    public void should_construct_when_name_is_ok(){
        // when
        Name name  = new Name("name");

        // then
        assertThat(name.getValue()).isEqualTo("name");
    }
}
