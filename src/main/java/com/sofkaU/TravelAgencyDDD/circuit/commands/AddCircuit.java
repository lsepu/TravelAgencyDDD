package com.sofkaU.TravelAgencyDDD.circuit.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.TravelAgencyDDD.circuit.TouristGuide;
import com.sofkaU.TravelAgencyDDD.circuit.values.CircuitDates;
import com.sofkaU.TravelAgencyDDD.circuit.values.CircuitId;
import com.sofkaU.TravelAgencyDDD.circuit.values.Price;

import javax.print.attribute.standard.Destination;

public class AddCircuit extends Command {

    private final CircuitId circuitId;
    private final Destination destination;
    private final TouristGuide touristGuide;
    private final CircuitDates circuitDates;
    private final Price price;

    public AddCircuit(CircuitId circuitId, Destination destination, TouristGuide touristGuide, CircuitDates circuitDates, Price price) {
        this.circuitId = circuitId;
        this.destination = destination;
        this.touristGuide = touristGuide;
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

    public TouristGuide getTouristGuide() {
        return touristGuide;
    }

    public Price getPrice() {
        return price;
    }
}
