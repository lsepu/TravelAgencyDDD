package com.sofkaU.TravelAgencyDDD.plan.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
import java.util.Properties;

public class Duration implements ValueObject<Properties> {

    private final Double durationNumber;
    private final String timeUnit;

    public Duration(Double durationNumber, String timeUnit) {
        this.durationNumber = Objects.requireNonNull(durationNumber);
        this.timeUnit = Objects.requireNonNull(timeUnit);

        if(this.durationNumber <= 0){
            throw new IllegalArgumentException("Duration time can't be 0 or negative");
        }
        if(this.timeUnit.isBlank()){
            throw new IllegalArgumentException("Time unit can't be blank");
        }
    }

    @Override
    public Properties value() {
        return new Properties() {

            public Double durationNumber() {
                return durationNumber;
            }

            public String timeUnit() {
                return timeUnit;
            }
        };
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Duration duration = (Duration) o;
        return Objects.equals(durationNumber, duration.durationNumber) && Objects.equals(timeUnit, duration.timeUnit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(durationNumber, timeUnit);
    }
}
