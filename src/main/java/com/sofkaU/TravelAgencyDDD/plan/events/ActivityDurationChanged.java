package com.sofkaU.TravelAgencyDDD.plan.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.TravelAgencyDDD.plan.values.ActivityId;
import com.sofkaU.TravelAgencyDDD.plan.values.Duration;

public class ActivityDurationChanged extends DomainEvent {

    private final ActivityId activityId;
    private final Duration duration;

    public ActivityDurationChanged(ActivityId activityId, Duration duration) {
        super("com.sofkaU.TravelAgencyDDD.plan.activitydurationchanged");
        this.activityId = activityId;
        this.duration = duration;
    }

    public ActivityId getActivityId() {
        return activityId;
    }

    public Duration getDuration() {
        return duration;
    }
}
