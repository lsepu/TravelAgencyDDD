package com.sofkaU.TravelAgencyDDD.circuit.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.TravelAgencyDDD.plan.values.PlanId;

public class AddPlan extends Command {

    private final PlanId planId;

    public AddPlan(PlanId planId) {
        this.planId = planId;
    }

    public PlanId getPlanId() {
        return planId;
    }
}
