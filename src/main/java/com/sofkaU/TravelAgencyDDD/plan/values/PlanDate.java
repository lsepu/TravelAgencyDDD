package com.sofkaU.TravelAgencyDDD.plan.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Date;
import java.util.Objects;

public class PlanDate implements ValueObject<Date>  {

    public final Date value;

    public PlanDate (Date value) {
        this.value = Objects.requireNonNull(value);
        if(!verifyValidDate(value)){
            throw new IllegalArgumentException("The date cannot be before today");
        }
    }

    public boolean verifyValidDate(Date date){
        Date currentDate = new Date();
        if (date.before(currentDate)){
            return false;
        }
        return true;
    }

    public Date value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlanDate planDate = (PlanDate) o;
        return Objects.equals(value, planDate.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
