package com.sofkaU.TravelAgencyDDD.plan;

import co.com.sofka.domain.generic.Entity;
import com.sofkaU.TravelAgencyDDD.plan.values.NumberOfPassengers;
import com.sofkaU.TravelAgencyDDD.plan.values.TransportId;
import com.sofkaU.TravelAgencyDDD.plan.values.TransportType;

public class Transport extends Entity<TransportId> {

    private TransportType transportType;
    private NumberOfPassengers numberOfPassengers;

    public Transport(TransportId entityId, TransportType transportType, NumberOfPassengers numberOfPassengers) {
        super(entityId);
        this.transportType = transportType;
        this.numberOfPassengers = numberOfPassengers;
    }

    public void changeTransportType( TransportType transportType){
        this.transportType = transportType;
    }

    public TransportType TransportType() {
        return transportType;
    }


    public NumberOfPassengers MaxNumberOfPassengers() {
        return numberOfPassengers;
    }
}
