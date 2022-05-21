package com.sofkaU.TravelAgencyDDD.plan.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.TravelAgencyDDD.plan.values.*;

public class AddTransport extends Command {

    private final TransportId transportId;
    private final TransportType transportType;
    private final MaxNumberOfPassengers maxNumberOfPassengers;

    public AddTransport(TransportId transportId, TransportType transportType, MaxNumberOfPassengers maxNumberOfPassengers) {
        this.transportId = transportId;
        this.transportType = transportType;
        this.maxNumberOfPassengers = maxNumberOfPassengers;
    }

    public TransportId getTransportId() {
        return transportId;
    }

    public TransportType getType() {
        return transportType;
    }

    public MaxNumberOfPassengers getMaxNumberOfPassengers() {
        return maxNumberOfPassengers;
    }

}
