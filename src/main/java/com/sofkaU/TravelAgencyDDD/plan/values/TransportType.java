package com.sofkaU.TravelAgencyDDD.plan.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TransportType implements ValueObject<TransportType.Vehicles> {

    private final Vehicles value;

    public TransportType(Vehicles value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Vehicles value(){
        return value;
    }

    public enum Vehicles {
        CAR, VAN, BUS
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransportType that = (TransportType) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
