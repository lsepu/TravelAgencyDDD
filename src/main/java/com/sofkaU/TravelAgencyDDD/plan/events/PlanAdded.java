package com.sofkaU.TravelAgencyDDD.plan.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.TravelAgencyDDD.plan.Activity;
import com.sofkaU.TravelAgencyDDD.plan.Meal;
import com.sofkaU.TravelAgencyDDD.plan.Transport;
import com.sofkaU.TravelAgencyDDD.plan.values.PlanDate;
import com.sofkaU.TravelAgencyDDD.plan.values.PlanId;

import java.util.Set;

public class PlanAdded extends DomainEvent {

    private final PlanId planId;
    private final Set<Meal> meals;
    private final Set<Activity> activities;
    private final Set<Transport> transports;
    private final PlanDate planDate;

    public PlanAdded(String type, PlanId planId, Set<Meal> meals, Set<Activity> activities, Set<Transport> transports, PlanDate planDate) {
        super("com.sofkaU.TravelAgencyDDD.plan.planadded");
        this.planId = planId;
        this.meals = meals;
        this.activities = activities;
        this.transports = transports;
        this.planDate = planDate;
    }

    public PlanId PlanId() {
        return planId;
    }

    public Set<Meal> Meals() {
        return meals;
    }

    public Set<Activity> Activities() {
        return activities;
    }

    public Set<Transport> Transports() {
        return transports;
    }

    public PlanDate PlanDate() {
        return planDate;
    }
}
