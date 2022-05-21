package com.sofkaU.TravelAgencyDDD.circuit.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class IdentificationCard implements ValueObject<String> {

    public final String value;

    public IdentificationCard(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("The identification card cannot be empty");
        }
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdentificationCard that = (IdentificationCard) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
