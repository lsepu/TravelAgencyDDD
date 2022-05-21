package com.sofkaU.TravelAgencyDDD.plan;

import co.com.sofka.domain.generic.Entity;
import com.sofkaU.TravelAgencyDDD.plan.values.ActivityId;
import com.sofkaU.TravelAgencyDDD.plan.values.Address;
import com.sofkaU.TravelAgencyDDD.plan.values.Duration;
import com.sofkaU.TravelAgencyDDD.plan.values.Time;

public class Activity extends Entity<ActivityId> {

    private Time time;
    private Address address;
    private Duration duration;

    public Activity(ActivityId entityId, Time time, Address address, Duration duration) {
        super(entityId);
        this.time = time;
        this.address = address;
        this.duration = duration;
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
