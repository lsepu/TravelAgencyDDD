package com.sofkaU.TravelAgencyDDD.plan.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.TravelAgencyDDD.plan.values.*;

public class AddTransport extends Command {

    private final TransportId transportId;
    private final TransportType transportType;
    private final NumberOfPassengers numberOfPassengers;

    public AddTransport(TransportId transportId, TransportType transportType, NumberOfPassengers numberOfPassengers) {
        this.transportId = transportId;
        this.transportType = transportType;
        this.numberOfPassengers = numberOfPassengers;
    }

    public TransportId getTransportId() {
        return transportId;
    }

    public TransportType getType() {
        return transportType;
    }

    public NumberOfPassengers getMaxNumberOfPassengers() {
        return numberOfPassengers;
    }

}
