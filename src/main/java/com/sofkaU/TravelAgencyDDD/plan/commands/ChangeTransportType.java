package com.sofkaU.TravelAgencyDDD.plan.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.TravelAgencyDDD.plan.values.PlanId;
import com.sofkaU.TravelAgencyDDD.plan.values.TransportId;
import com.sofkaU.TravelAgencyDDD.plan.values.TransportType;

public class ChangeTransportType extends Command {

    private final PlanId planId;
    private final TransportId transportId;
    private final TransportType transportType;

    public ChangeTransportType(PlanId planId, TransportId transportId, TransportType transportType) {
        this.planId = planId;
        this.transportId = transportId;
        this.transportType = transportType;
    }

    public PlanId getPlanId() {
        return planId;
    }

    public TransportId getTransportId() {
        return transportId;
    }

    public TransportType getTransportType() {
        return transportType;
    }
}
