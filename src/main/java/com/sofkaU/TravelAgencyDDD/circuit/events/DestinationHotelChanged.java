package com.sofkaU.TravelAgencyDDD.circuit.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.TravelAgencyDDD.circuit.values.DestinationId;
import com.sofkaU.TravelAgencyDDD.circuit.values.Hotel;

public class DestinationHotelChanged extends DomainEvent {

    private final DestinationId destinationId;
    private final Hotel hotel;

    public DestinationHotelChanged(DestinationId destinationId, Hotel hotel) {
        super("com.sofkaU.TravelAgencyDDD.circuit.destinationhotelchanged");
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
