package me.renedo.naizfit.testers.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DimensionTest {

    @Test
    void should_raise_error_when_dimension_is_negative() {
        // when
        assertThrows(DimensionInvalidException.class, () -> new Dimension(-1D));
    }

    @Test
    void should_raise_error_when_dimension_has_null() {
        // when
        assertThrows(DimensionEmptyException.class, () -> new Dimension(null));
    }

    @Test
    void should_construct_when_dimension_is_ok() {
        // when
        Dimension dimension = new Dimension(0.345D);

        // then
        assertEquals(dimension.getValue(), 0.3);
    }
}
