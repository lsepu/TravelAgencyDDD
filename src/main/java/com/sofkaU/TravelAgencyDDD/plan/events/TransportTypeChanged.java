package com.sofkaU.TravelAgencyDDD.plan.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.TravelAgencyDDD.plan.values.TransportId;
import com.sofkaU.TravelAgencyDDD.plan.values.TransportType;

public class TransportTypeChanged extends DomainEvent {

    private final TransportId transportId;
    private final TransportType transportType;

    public TransportTypeChanged(TransportId transportId, TransportType transportType) {
        super("com.sofkaU.TravelAgencyDDD.plan.transporttypechanged");
        this.transportId = transportId;
        this.transportType = transportType;
    }

    public TransportId getTransportId() {
        return transportId;
    }

    public TransportType getTransportType() {
        return transportType;
    }
}
