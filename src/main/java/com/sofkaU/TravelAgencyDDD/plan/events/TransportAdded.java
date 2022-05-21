package com.sofkaU.TravelAgencyDDD.plan.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.TravelAgencyDDD.plan.values.*;

public class TransportAdded extends DomainEvent {

    private final TransportId transportId;
    private final TransportType transportType;
    private final NumberOfPassengers numberOfPassengers;

    public TransportAdded(String type, TransportId transportId, TransportType transportType1,  NumberOfPassengers numberOfPassengers) {
        super("com.sofkaU.TravelAgencyDDD.plan.transportadded");
        this.transportId = transportId;
        this.transportType = transportType1;
        this.numberOfPassengers = numberOfPassengers;
    }

    public TransportId getTransportId() {
        return transportId;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public NumberOfPassengers getNumberOfPassengers() {
        return numberOfPassengers;
    }
}
