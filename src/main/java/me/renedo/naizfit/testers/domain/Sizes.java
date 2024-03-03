package me.renedo.naizfit.testers.domain;

import java.util.Comparator;
import java.util.List;

public class Sizes {

    private final List<Size> value;

    public Sizes(List<Size> value) {
        this.value = value.stream().sorted(Comparator.comparing(Size::getValue)).toList();
    }

    public List<Size> getValue() {
        return value;
    }
}
