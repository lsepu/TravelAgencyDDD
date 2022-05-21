package com.sofkaU.TravelAgencyDDD.circuit.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.TravelAgencyDDD.circuit.values.DestinationId;
import com.sofkaU.TravelAgencyDDD.circuit.values.Hotel;

public class ChangeDestinationHotel extends Command {

    private final DestinationId destinationId;
    private final Hotel hotel;

    public ChangeDestinationHotel(DestinationId destinationId, Hotel hotel) {
        this.destinationId = destinationId;
        this.hotel = hotel;
    }

    public DestinationId getDestinationId() {
        return destinationId;
    }

    public Hotel getHotel() {
        return hotel;
    }
}
