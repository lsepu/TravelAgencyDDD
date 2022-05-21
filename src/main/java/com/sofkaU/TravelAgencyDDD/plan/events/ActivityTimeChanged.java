package com.sofkaU.TravelAgencyDDD.plan.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.TravelAgencyDDD.plan.values.ActivityId;
import com.sofkaU.TravelAgencyDDD.plan.values.Time;

public class ActivityTimeChanged extends DomainEvent {

    private final ActivityId activityId;
    private final Time time;

    public ActivityTimeChanged(ActivityId activityId, Time time) {
        super("com.sofkaU.TravelAgencyDDD.plan.activitytimechanged");
        this.activityId = activityId;
        this.time = time;
    }

    public ActivityId ActivityId() {
        return activityId;
    }

    public Time Time() {
        return time;
    }
}
