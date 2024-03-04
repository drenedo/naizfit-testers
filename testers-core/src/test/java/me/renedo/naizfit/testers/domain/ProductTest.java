package me.renedo.naizfit.testers.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ProductTest {

    @Test
    void should_throw_exception_when_product_has_no_id() {
        // when
        assertThrows(ProductWithOutIdException.class, () -> new Product(null, SKUMother.any(), null, null, BrandMother.any(), "Red"));
    }

}
