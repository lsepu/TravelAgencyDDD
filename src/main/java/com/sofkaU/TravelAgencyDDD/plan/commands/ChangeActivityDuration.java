package com.sofkaU.TravelAgencyDDD.plan.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.TravelAgencyDDD.plan.values.ActivityId;
import com.sofkaU.TravelAgencyDDD.plan.values.Duration;


public class ChangeActivityDuration extends Command {

    private final ActivityId activityId;
    private final Duration duration;

    public ChangeActivityDuration(ActivityId activityId, Duration duration) {
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
