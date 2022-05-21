package com.sofkaU.TravelAgencyDDD.plan.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class LicensePlate implements ValueObject<String> {

    public final String value;

    public LicensePlate(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("The license plate cannot be empty");
        }
    }

    public String value() {
        return value;
    }

}
