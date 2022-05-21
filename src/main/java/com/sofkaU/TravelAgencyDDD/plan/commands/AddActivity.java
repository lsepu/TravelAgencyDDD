package com.sofkaU.TravelAgencyDDD.plan.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.TravelAgencyDDD.plan.values.ActivityId;
import com.sofkaU.TravelAgencyDDD.plan.values.Address;
import com.sofkaU.TravelAgencyDDD.plan.values.Duration;
import com.sofkaU.TravelAgencyDDD.plan.values.Time;

public class AddActivity extends Command {

    private final ActivityId activityId;
    private final Time time;
    private final Address address;
    private final Duration duration;

    public AddActivity(ActivityId activityId, Time time, Address address, Duration duration) {
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
