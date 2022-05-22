package com.sofkaU.TravelAgencyDDD.plan.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.TravelAgencyDDD.plan.values.*;


public class ActivityAdded extends DomainEvent {

    private final ActivityId activityId;
    private final ActivityName activityName;
    private final Time time;
    private final Address address;
    private final Duration duration;

    public ActivityAdded(ActivityId activityId, ActivityName activityName, Time time, Address address, Duration duration) {
        super("com.sofkaU.TravelAgencyDDD.plan.activityadded");
        this.activityId = activityId;
        this.activityName = activityName;
        this.time = time;
        this.address = address;
        this.duration = duration;
    }

    public ActivityName getActivityName() {
        return activityName;
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
