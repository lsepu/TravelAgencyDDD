package com.sofkaU.TravelAgencyDDD.plan.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.TravelAgencyDDD.plan.values.*;

public class AddActivity extends Command {

    private final PlanId planId;
    private final ActivityId activityId;
    private final Time time;
    private final Address address;
    private final Duration duration;

    public AddActivity(PlanId planId, ActivityId activityId, Time time, Address address, Duration duration) {
        this.planId = planId;
        this.activityId = activityId;
        this.time = time;
        this.address = address;
        this.duration = duration;
    }

    public PlanId getPlanId() {
        return planId;
    }

    public ActivityId getActivityId() {
        return activityId;
    }

    public Time getTime() {
        return time;
    }

    public Address getAddress() {
        return address;
    }

    public Duration getDuration() {
        return duration;
    }
}
