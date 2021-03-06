package com.sofkaU.TravelAgencyDDD.circuit.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.TravelAgencyDDD.circuit.Destination;
import com.sofkaU.TravelAgencyDDD.circuit.TouristGuide;
import com.sofkaU.TravelAgencyDDD.circuit.values.CircuitDates;
import com.sofkaU.TravelAgencyDDD.circuit.values.Price;



public class CircuitCreated extends DomainEvent {

    private final Destination destination;
    private final CircuitDates circuitDates;
    private final Price price;

    public CircuitCreated(Destination destination,  CircuitDates circuitDates, Price price) {
        super("com.sofkaU.TravelAgencyDDD.circuit.circuitadded");
        this.destination = destination;
        this.circuitDates = circuitDates;
        this.price = price;
    }

    public Destination getDestination() {
        return destination;
    }

    public CircuitDates getCircuitDates() {
        return circuitDates;
    }

    public Price getPrice() {
        return price;
    }
}
