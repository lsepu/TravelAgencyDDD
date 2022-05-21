package com.sofkaU.TravelAgencyDDD.plan.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class MaxNumberOfPassengers implements ValueObject<Integer> {

    public final Integer value;

    public MaxNumberOfPassengers(Integer value) {
        this.value = Objects.requireNonNull(value);
        if(this.value < 0){
            throw new IllegalArgumentException("The maximum number of passengers cannot be a negative number");
        }
    }

    public Integer value() {
        return value;
    }

}
