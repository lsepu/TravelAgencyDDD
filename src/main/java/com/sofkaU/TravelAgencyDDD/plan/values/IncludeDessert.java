package com.sofkaU.TravelAgencyDDD.plan.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class IncludeDessert implements ValueObject<Boolean> {

    public final Boolean value;

    public IncludeDessert(Boolean value) {
        this.value = Objects.requireNonNull(value);
    }

    public Boolean value() {
        return value;
    }


}
