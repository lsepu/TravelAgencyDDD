package com.sofkaU.TravelAgencyDDD.plan;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.TravelAgencyDDD.plan.events.ActivityAdded;
import com.sofkaU.TravelAgencyDDD.plan.events.PlanAdded;
import com.sofkaU.TravelAgencyDDD.plan.values.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Plan extends AggregateEvent<PlanId> {

    protected Set<Meal> meals;
    protected Set<Activity> activities;
    protected Set<Transport> transports;
    protected PlanDate planDate;


    public Plan(PlanId entityId, Set<Meal> meals, Set<Activity> activities, Set<Transport> transports, PlanDate planDate) {
        super(entityId);
        appendChange(new PlanAdded(meals, activities, transports, planDate));
        subscribe(new PlanChange(this));
    }

    private Plan(PlanId entityId){
        super(entityId);
        subscribe(new PlanChange(this));
    }

    public static Plan from (PlanId entityId, List<DomainEvent> events){
        var circuit = new Plan(entityId);
        events.forEach(circuit::applyEvent);
        return circuit;
    }

    //behaviours

    public void addActivity(ActivityId activityId, Time time, Address address, Duration duration){
        Objects.requireNonNull(activityId);
        Objects.requireNonNull(address);
        Objects.requireNonNull(duration);

        appendChange(new ActivityAdded(activityId, time, address, duration)).apply();
    }

    public void addMealDessert(){

    }

    public void addPlan(){

    }

    public void addTransport(){

    }

    public void changeActivityDuration(){

    }

    public void changeActivityTime(){

    }

    public void changeDate(){

    }

    public void changeMealOption(){

    }

    public void addMeal(){

    }

    public void changeTransportType(){

    }

    protected Optional<Activity> getActivityById(ActivityId entityId){
        return activities
                .stream()
                .filter(activity -> activity.identity().equals(entityId))
                .findFirst();
    }

    protected Optional<Transport> getTransportById(TransportId entityId){
        return transports
                .stream()
                .filter(transport -> transport.identity().equals(entityId))
                .findFirst();
    }

}
