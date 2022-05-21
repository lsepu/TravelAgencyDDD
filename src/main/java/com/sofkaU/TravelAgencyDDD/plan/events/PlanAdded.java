package com.sofkaU.TravelAgencyDDD.plan.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.TravelAgencyDDD.plan.Activity;
import com.sofkaU.TravelAgencyDDD.plan.Meal;
import com.sofkaU.TravelAgencyDDD.plan.Transport;
import com.sofkaU.TravelAgencyDDD.plan.values.PlanDate;
import com.sofkaU.TravelAgencyDDD.plan.values.PlanId;

import java.util.Set;

public class PlanAdded extends DomainEvent {

    private final Set<Meal> meals;
    private final Set<Activity> activities;
    private final Set<Transport> transports;
    private final PlanDate planDate;

    public PlanAdded(Set<Meal> meals, Set<Activity> activities, Set<Transport> transports, PlanDate planDate) {
        super("com.sofkaU.TravelAgencyDDD.plan.planadded");
        this.meals = meals;
        this.activities = activities;
        this.transports = transports;
        this.planDate = planDate;
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
