package com.sofkaU.TravelAgencyDDD.plan.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.TravelAgencyDDD.plan.values.ActivityId;
import com.sofkaU.TravelAgencyDDD.plan.values.Address;
import com.sofkaU.TravelAgencyDDD.plan.values.Duration;
import com.sofkaU.TravelAgencyDDD.plan.values.Time;



public class ActivityAdded extends DomainEvent {

    private final ActivityId activityId;
    private final Time time;
    private final Address address;
    private final Duration duration;

    public ActivityAdded(ActivityId activityId, Time time, Address address, Duration duration) {
        super("com.sofkaU.TravelAgencyDDD.plan.activityadded");
        this.activityId = activityId;
        this.time = time;
        this.address = address;
        this.duration = duration;
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
