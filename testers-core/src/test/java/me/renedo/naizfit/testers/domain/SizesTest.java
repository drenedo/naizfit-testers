package me.renedo.naizfit.testers.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

class SizesTest {

    @Test
    void should_create_ordered_list(){
        // when
        var sizes = new Sizes(List.of(SizeMother.any(), SizeMother.any(), SizeMother.any()));

        assertThat(sizes.getValue()).hasSize(3);
        assertThat(sizes.getValue().get(0).getValue()).isLessThan(sizes.getValue().get(1).getValue());
        assertThat(sizes.getValue().get(1).getValue()).isLessThan(sizes.getValue().get(2).getValue());
    }

}
