package com.sofkaU.TravelAgencyDDD.circuit.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Date;
import java.util.Objects;
import java.util.Properties;

public class CircuitDates implements ValueObject<Properties> {

    private final Date beginningDate;
    private final Date endDate;

    public CircuitDates(Date beginningDate, Date endDate) {
        this.beginningDate = Objects.requireNonNull(beginningDate);
        this.endDate = Objects.requireNonNull(endDate);

        if(!verifyValidDate(beginningDate)){
            throw new IllegalArgumentException("The beginning date cannot be before today");
        }

        if(!verifyValidDate(endDate)){
            throw new IllegalArgumentException("The end date cannot be before today");
        }

        if(endDate.before(beginningDate)){
            throw new IllegalArgumentException("the end date can't be before the beginning date");
        }

    }

    public boolean verifyValidDate(Date date){
        Date currentDate = new Date();
        if (date.before(currentDate)){
            return false;
        }
        return true;
    }

    @Override
    public Properties value() {
        return new Properties() {

            public Date beginningDate() {
                return beginningDate;
            }

            public Date endDate() {
                return endDate;
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CircuitDates that = (CircuitDates) o;
        return Objects.equals(beginningDate, that.beginningDate) && Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(beginningDate, endDate);
    }
}
