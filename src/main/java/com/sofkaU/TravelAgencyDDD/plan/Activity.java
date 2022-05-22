package com.sofkaU.TravelAgencyDDD.plan;

import co.com.sofka.domain.generic.Entity;
import com.sofkaU.TravelAgencyDDD.plan.values.*;

public class Activity extends Entity<ActivityId> {

    private ActivityName activityName;
    private Time time;
    private Address address;
    private Duration duration;


    public Activity(ActivityId entityId, ActivityName activityName, Time time, Address address, Duration duration) {
        super(entityId);
        this.activityName = activityName;
        this.time = time;
        this.address = address;
        this.duration = duration;
    }

    public ActivityName getActivityName() {
        return activityName;
    }

    public void changeTime(Time time){
        this.time = time;
    }

    public void changeDuration(Duration duration){
        this.duration = duration;
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
