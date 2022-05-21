package com.sofkaU.TravelAgencyDDD.circuit.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Date;
import java.util.Objects;

public class EndDate implements ValueObject<Date> {

    public final Date value;

    public EndDate(Date value) {
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

}
