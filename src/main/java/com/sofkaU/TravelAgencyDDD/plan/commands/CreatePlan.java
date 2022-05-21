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
    private final Set<Meal> meals;
    private final Set<Activity> activities;
    private final Set<Transport> transports;
    private final PlanDate planDate;

    public CreatePlan(PlanId planId, Set<Meal> meals, Set<Activity> activities, Set<Transport> transports, PlanDate planDate) {
        this.planId = planId;
        this.meals = meals;
        this.activities = activities;
        this.transports = transports;
        this.planDate = planDate;
    }

    public PlanId getPlanId() {
        return planId;
    }

    public Set<Meal> getMeals() {
        return meals;
    }

    public Set<Activity> getActivities() {
        return activities;
    }

    public Set<Transport> getTransports() {
        return transports;
    }

    public PlanDate getPlanDate() {
        return planDate;
    }
}
