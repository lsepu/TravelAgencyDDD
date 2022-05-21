package com.sofkaU.TravelAgencyDDD.circuit.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.TravelAgencyDDD.circuit.Destination;
import com.sofkaU.TravelAgencyDDD.circuit.TouristGuide;
import com.sofkaU.TravelAgencyDDD.circuit.values.CircuitDates;
import com.sofkaU.TravelAgencyDDD.circuit.values.CircuitId;
import com.sofkaU.TravelAgencyDDD.circuit.values.Price;


public class CreateCircuit extends Command {

    private final CircuitId circuitId;
    private final Destination destination;
    private final CircuitDates circuitDates;
    private final Price price;

    public CreateCircuit(CircuitId circuitId, Destination destination, CircuitDates circuitDates, Price price) {
        this.circuitId = circuitId;
        this.destination = destination;
        this.circuitDates = circuitDates;
        this.price = price;
    }

    public CircuitId getCircuitId() {
        return circuitId;
    }

    public CircuitDates getCircuitDates() {
        return circuitDates;
    }

    public Destination getDestination() {
        return destination;
    }

    public Price getPrice() {
        return price;
    }
}
