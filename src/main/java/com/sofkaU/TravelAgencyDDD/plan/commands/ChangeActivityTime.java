package com.sofkaU.TravelAgencyDDD.plan.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.TravelAgencyDDD.plan.values.ActivityId;
import com.sofkaU.TravelAgencyDDD.plan.values.PlanId;
import com.sofkaU.TravelAgencyDDD.plan.values.Time;

public class ChangeActivityTime extends Command {

    private final PlanId planId;
    private final ActivityId activityId;
    private final Time time;


    public ChangeActivityTime(PlanId planId, ActivityId activityId, Time time) {
        this.planId = planId;
        this.activityId = activityId;
        this.time = time;
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
}
