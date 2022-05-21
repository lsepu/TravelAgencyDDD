package com.sofkaU.TravelAgencyDDD.circuit.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.TravelAgencyDDD.circuit.TouristGuide;
import com.sofkaU.TravelAgencyDDD.circuit.values.CircuitDates;
import com.sofkaU.TravelAgencyDDD.circuit.values.Price;

import javax.print.attribute.standard.Destination;

public class CircuitAdded extends DomainEvent {

    private final Destination destination;
    private final TouristGuide touristGuide;
    private final CircuitDates circuitDates;
    private final Price price;

    public CircuitAdded(Destination destination, TouristGuide touristGuide, CircuitDates circuitDates, Price price) {
        super("com.sofkaU.TravelAgencyDDD.circuit.circuitadded");
        this.destination = destination;
        this.touristGuide = touristGuide;
        this.circuitDates = circuitDates;
        this.price = price;
    }

    public Destination Destination() {
        return destination;
    }

    public TouristGuide TouristGuide() {
        return touristGuide;
    }

    public CircuitDates BeginningDate() {
        return circuitDates;
    }

    public Price Price() {
        return price;
    }
}
