package com.sofkaU.TravelAgencyDDD.plan.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.TravelAgencyDDD.plan.Activity;
import com.sofkaU.TravelAgencyDDD.plan.Meal;
import com.sofkaU.TravelAgencyDDD.plan.Transport;
import com.sofkaU.TravelAgencyDDD.plan.values.PlanDate;

import java.util.Set;

public class PlanCreated extends DomainEvent {

    private final Set<Activity> activities;
    private final PlanDate planDate;

    public PlanCreated(Set<Activity> activities, PlanDate planDate) {
        super("com.sofkaU.TravelAgencyDDD.plan.planadded");
        this.activities = activities;
        this.planDate = planDate;
    }

    public Set<Activity> getActivities() {
        return activities;
    }


    public PlanDate getPlanDate() {
        return planDate;
    }
}
