package com.sofkaU.TravelAgencyDDD.plan.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.TravelAgencyDDD.plan.values.PlanDate;

public class ChangePlanDate extends Command {

    private final PlanDate planDate;

    public ChangePlanDate(PlanDate planDate) {
        this.planDate = planDate;
    }

    public PlanDate getPlanDate() {
        return planDate;
    }
}
