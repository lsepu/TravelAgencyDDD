package com.sofkaU.TravelAgencyDDD.circuit.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TravelPoints implements ValueObject<Integer> {

    public final Integer value;

    public TravelPoints(Integer value) {
        this.value = Objects.requireNonNull(value);
        if (this.value < 0) {
            throw new IllegalArgumentException("The travel points cannot be a negative number");
        }
    }

    public Integer value() {
        return value;
    }

}
