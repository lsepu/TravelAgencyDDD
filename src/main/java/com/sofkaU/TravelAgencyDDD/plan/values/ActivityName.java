package com.sofkaU.TravelAgencyDDD.plan.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ActivityName implements ValueObject<String> {

    public final String value;

    public ActivityName(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("The activity name cannot be empty");
        }
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActivityName that = (ActivityName) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
