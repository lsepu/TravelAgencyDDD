package com.sofkaU.TravelAgencyDDD.circuit.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.TravelAgencyDDD.circuit.TouristGuide;
import com.sofkaU.TravelAgencyDDD.circuit.values.CircuitDates;
import com.sofkaU.TravelAgencyDDD.circuit.values.Price;

import javax.print.attribute.standard.Destination;

public class AddCircuit extends Command {

    private final Destination destination;
    private final TouristGuide touristGuide;
    private final CircuitDates circuitDates;
    private final Price price;

    public AddCircuit(Destination destination, TouristGuide touristGuide, CircuitDates circuitDates, Price price) {
        this.destination = destination;
        this.touristGuide = touristGuide;
        this.circuitDates = circuitDates;
        this.price = price;
    }

    public Destination getDestination() {
        return destination;
    }

    public TouristGuide getTouristGuide() {
        return touristGuide;
    }

    public CircuitDates getBeginningDate() {
        return circuitDates;
    }

    public Price getPrice() {
        return price;
    }
}
