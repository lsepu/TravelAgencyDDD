package com.sofkaU.TravelAgencyDDD.circuit.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.TravelAgencyDDD.circuit.Circuit;
import com.sofkaU.TravelAgencyDDD.circuit.values.CircuitId;
import com.sofkaU.TravelAgencyDDD.circuit.values.DestinationId;
import com.sofkaU.TravelAgencyDDD.circuit.values.Hotel;

public class ChangeDestinationHotel extends Command {

    private final CircuitId circuitId;
    private final DestinationId destinationId;
    private final Hotel hotel;

    public ChangeDestinationHotel(CircuitId circuitId, DestinationId destinationId, Hotel hotel) {
        this.circuitId = circuitId;
        this.destinationId = destinationId;
        this.hotel = hotel;
    }

    public CircuitId getCircuitId() {
        return circuitId;
    }

    public DestinationId getDestinationId() {
        return destinationId;
    }

    public Hotel getHotel() {
        return hotel;
    }
}
