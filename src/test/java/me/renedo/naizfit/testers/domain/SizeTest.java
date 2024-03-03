package me.renedo.naizfit.testers.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SizeTest {

    @Test
    public void should_raise_error_when_empty_name(){
        // when
        assertThrows(SizeEmptyException.class, () -> new Size(""));
    }

    @Test
    public void should_raise_error_when_name_is_null(){
        // when
        assertThrows(SizeEmptyException.class, () -> new Size(null));
    }

    @Test
    public void should_construct_when_sku_is_ok(){
        // when
        Size size  = new Size("size");

        // then
        assertEquals(size.getValue(), "size");
    }
}
