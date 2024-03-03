package me.renedo.naizfit.testers.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Dimension {

    private final Double value;

    public Dimension(Double value) {
        if(value == null) {
            throw new DimensionEmptyException();
        }
        if(value < 0) {
            throw new DimensionInvalidException();
        }
        this.value = new BigDecimal(value.toString()).setScale(1, RoundingMode.HALF_UP).doubleValue();
    }

    public Double getValue() {
        return value;
    }
}
