package me.renedo.naizfit.testers.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SKUTest {

    @Test
    public void should_raise_error_when_empty_name(){
        // when
        assertThrows(SKUEmptyException.class, () -> new SKU(""));
    }

    @Test
    public void should_raise_error_when_name_is_null(){
        // when
        assertThrows(SKUEmptyException.class, () -> new SKU(null));
    }


    @Test
    public void should_construct_when_name_is_ok(){
        // when
        SKU sku  = new SKU("sku");

        // then
        assertThat(sku.getValue()).isEqualTo("sku");
    }

}
