package com.sofkaU.TravelAgencyDDD.plan.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.TravelAgencyDDD.plan.values.ActivityId;
import com.sofkaU.TravelAgencyDDD.plan.values.Address;
import com.sofkaU.TravelAgencyDDD.plan.values.Time;

import java.time.Duration;

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

    public ActivityId ActivityId() {
        return activityId;
    }

    public Time Time() {
        return time;
    }

    public Address Address() {
        return address;
    }

    public Duration Duration() {
        return duration;
    }
}
