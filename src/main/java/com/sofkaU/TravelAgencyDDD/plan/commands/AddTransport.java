package com.sofkaU.TravelAgencyDDD.plan.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.TravelAgencyDDD.plan.values.*;

public class AddTransport extends Command {

    private final PlanId planId;
    private final TransportId transportId;
    private final TransportType transportType;
    private final NumberOfPassengers numberOfPassengers;

    public AddTransport(PlanId planId, TransportId transportId, TransportType transportType, NumberOfPassengers numberOfPassengers) {
        this.planId = planId;
        this.transportId = transportId;
        this.transportType = transportType;
        this.numberOfPassengers = numberOfPassengers;
    }

    public PlanId getPlanId() {
        return planId;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public NumberOfPassengers getNumberOfPassengers() {
        return numberOfPassengers;
    }


}
