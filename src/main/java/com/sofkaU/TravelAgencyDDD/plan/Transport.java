package com.sofkaU.TravelAgencyDDD.plan;

import co.com.sofka.domain.generic.Entity;
import com.sofkaU.TravelAgencyDDD.plan.values.MaxNumberOfPassengers;
import com.sofkaU.TravelAgencyDDD.plan.values.TransportId;
import com.sofkaU.TravelAgencyDDD.plan.values.TransportType;

public class Transport extends Entity<TransportId> {

    private TransportType transportType;
    private MaxNumberOfPassengers maxNumberOfPassengers;

    public Transport(TransportId entityId, TransportType transportType, MaxNumberOfPassengers maxNumberOfPassengers) {
        super(entityId);
        this.transportType = transportType;
        this.maxNumberOfPassengers = maxNumberOfPassengers;
    }

    public TransportType getTransportType() {
        return transportType;
    }


    public MaxNumberOfPassengers getMaxNumberOfPassengers() {
        return maxNumberOfPassengers;
    }
}
