package com.sofkaU.TravelAgencyDDD.circuit.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.TravelAgencyDDD.circuit.TouristGuide;
import com.sofkaU.TravelAgencyDDD.circuit.values.BeginningDate;
import com.sofkaU.TravelAgencyDDD.circuit.values.EndDate;
import com.sofkaU.TravelAgencyDDD.circuit.values.Price;

import javax.print.attribute.standard.Destination;

public class CircuitAdded extends DomainEvent {

    private final Destination destination;
    private final TouristGuide touristGuide;
    private final BeginningDate beginningDate;
    private final EndDate endDate;
    private final Price price;

    public CircuitAdded(Destination destination, TouristGuide touristGuide, BeginningDate beginningDate, EndDate endDate, Price price) {
        super("com.sofkaU.TravelAgencyDDD.circuit.circuitadded");
        this.destination = destination;
        this.touristGuide = touristGuide;
        this.beginningDate = beginningDate;
        this.endDate = endDate;
        this.price = price;
    }

    public Destination Destination() {
        return destination;
    }

    public TouristGuide TouristGuide() {
        return touristGuide;
    }

    public BeginningDate BeginningDate() {
        return beginningDate;
    }

    public EndDate EndDate() {
        return endDate;
    }

    public Price Price() {
        return price;
    }
}
