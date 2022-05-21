package com.sofkaU.TravelAgencyDDD.circuit.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.TravelAgencyDDD.circuit.TouristGuide;
import com.sofkaU.TravelAgencyDDD.circuit.values.BeginningDate;
import com.sofkaU.TravelAgencyDDD.circuit.values.EndDate;
import com.sofkaU.TravelAgencyDDD.circuit.values.Price;

import javax.print.attribute.standard.Destination;

public class AddCircuit extends Command {

    private final Destination destination;
    private final TouristGuide touristGuide;
    private final BeginningDate beginningDate;
    private final EndDate endDate;
    private final Price price;

    public AddCircuit(Destination destination, TouristGuide touristGuide, BeginningDate beginningDate, EndDate endDate, Price price) {
        this.destination = destination;
        this.touristGuide = touristGuide;
        this.beginningDate = beginningDate;
        this.endDate = endDate;
        this.price = price;
    }

    public Destination getDestination() {
        return destination;
    }

    public TouristGuide getTouristGuide() {
        return touristGuide;
    }

    public BeginningDate getBeginningDate() {
        return beginningDate;
    }

    public EndDate getEndDate() {
        return endDate;
    }

    public Price getPrice() {
        return price;
    }
}
