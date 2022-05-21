package com.sofkaU.TravelAgencyDDD.plan.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.TravelAgencyDDD.plan.Activity;
import com.sofkaU.TravelAgencyDDD.plan.Meal;
import com.sofkaU.TravelAgencyDDD.plan.Transport;
import com.sofkaU.TravelAgencyDDD.plan.values.PlanDate;
import com.sofkaU.TravelAgencyDDD.plan.values.PlanId;

import java.util.Set;

public class CreatePlan extends Command {

    private final PlanId planId;
    private final Set<Activity> activities;
    private final PlanDate planDate;

    public CreatePlan(PlanId planId, Set<Activity> activities, PlanDate planDate) {
        this.planId = planId;
        this.activities = activities;
        this.planDate = planDate;
    }

    public PlanId getPlanId() {
        return planId;
    }

    public Set<Activity> getActivities() {
        return activities;
    }

    public PlanDate getPlanDate() {
        return planDate;
    }
}
