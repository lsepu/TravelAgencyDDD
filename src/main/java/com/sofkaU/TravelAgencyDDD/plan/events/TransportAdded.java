package com.sofkaU.TravelAgencyDDD.plan.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.TravelAgencyDDD.plan.values.*;

public class TransportAdded extends DomainEvent {

    private final TransportId transportId;
    private final TransportType transportType;
    private final MaxNumberOfPassengers maxNumberOfPassengers;

    public TransportAdded(String type, TransportId transportId, TransportType transportType1,  MaxNumberOfPassengers maxNumberOfPassengers) {
        super("com.sofkaU.TravelAgencyDDD.plan.transportadded");
        this.transportId = transportId;
        this.transportType = transportType1;
        this.maxNumberOfPassengers = maxNumberOfPassengers;
    }

    public TransportId TransportId() {
        return transportId;
    }

    public TransportType Type() {
        return transportType;
    }

    public MaxNumberOfPassengers MaxNumberOfPassengers() {
        return maxNumberOfPassengers;
    }


}
