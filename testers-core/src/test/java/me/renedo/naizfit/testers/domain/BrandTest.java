package me.renedo.naizfit.testers.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

import org.junit.jupiter.api.Test;

class BrandTest {

    @Test
    void should_throw_exception_when_brand_has_no_id() {
        // when
        assertThrows(BrandWithOutIdException.class, () -> new Brand(null, NameMother.any(), new URL("https://naiz.fit/")));
    }

    @Test
    void should_return_brand_id() throws MalformedURLException {
        // given
        UUID id = UUID.randomUUID();

        // when
        var brand = new Brand(id, NameMother.any(), new URL("https://naiz.fit/"));

        // then
        assertThat(brand.getId()).isEqualTo(id);
    }
}
