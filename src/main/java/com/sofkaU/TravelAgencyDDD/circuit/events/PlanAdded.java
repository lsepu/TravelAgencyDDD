package com.sofkaU.TravelAgencyDDD.circuit.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.TravelAgencyDDD.plan.values.PlanId;

public class PlanAdded extends DomainEvent {

    private final PlanId planId;

    public PlanAdded(PlanId planId) {
        super("com.sofkaU.TravelAgencyDDD.circuit.planadded");
        this.planId = planId;
    }

    public PlanId PlanId() {
        return planId;
    }
}
