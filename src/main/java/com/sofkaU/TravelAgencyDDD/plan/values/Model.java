package com.sofkaU.TravelAgencyDDD.plan.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Model implements ValueObject<String> {

    public final String value;

    public Model(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("The address cannot be empty");
        }
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Model model = (Model) o;
        return Objects.equals(value, model.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
