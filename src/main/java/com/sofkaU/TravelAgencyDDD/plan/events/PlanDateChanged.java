package com.sofkaU.TravelAgencyDDD.plan.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.TravelAgencyDDD.plan.values.PlanDate;

public class PlanDateChanged extends DomainEvent {

    private final PlanDate planDate;

    public PlanDateChanged(PlanDate planDate) {
        super("com.sofkaU.TravelAgencyDDD.plan.datechanged");
        this.planDate = planDate;
    }

    public PlanDate getPlanDate() {
        return planDate;
    }
}
