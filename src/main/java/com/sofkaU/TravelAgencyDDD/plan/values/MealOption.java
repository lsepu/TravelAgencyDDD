package com.sofkaU.TravelAgencyDDD.plan.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class MealOption implements ValueObject<MealOption.MealOptions> {

    private final MealOptions value;

    public MealOption(MealOptions value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public MealOptions value(){
        return value;
    }

    public enum MealOptions {
        REGULAR, VEGETARIAN
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MealOption that = (MealOption) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
