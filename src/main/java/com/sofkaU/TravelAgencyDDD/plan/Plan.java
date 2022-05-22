package com.sofkaU.TravelAgencyDDD.plan;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.TravelAgencyDDD.plan.events.*;
import com.sofkaU.TravelAgencyDDD.plan.values.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Plan extends AggregateEvent<PlanId> {

    protected Set<Meal> meals;
    protected Set<Activity> activities;
    protected PlanDate planDate;
    protected Set<Transport> transports;


    public Plan(PlanId entityId, Set<Activity> activities, PlanDate planDate) {
        super(entityId);
        appendChange(new PlanCreated(activities, planDate));
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

    public void addMealDessert(MealId mealId){
        Objects.requireNonNull(mealId);

        appendChange(new MealDessertAdded(mealId)).apply();
    }

    public void addTransport(TransportId transportId, TransportType transportType,  NumberOfPassengers numberOfPassengers){
        Objects.requireNonNull(transportId);
        Objects.requireNonNull(transportType);
        Objects.requireNonNull(numberOfPassengers);

        appendChange(new TransportAdded(transportId, transportType, numberOfPassengers)).apply();
    }

    public void changeActivityDuration(ActivityId activityId, Duration duration){
        Objects.requireNonNull(activityId);
        Objects.requireNonNull(duration);

        appendChange(new ActivityDurationChanged(activityId, duration)).apply();
    }

    public void changeActivityTime(ActivityId activityId, Time time){
        Objects.requireNonNull(activityId);
        Objects.requireNonNull(time);

        appendChange(new ActivityTimeChanged(activityId, time)).apply();
    }

    public void changeDate(PlanDate planDate){
        Objects.requireNonNull(planDate);

        appendChange(new PlanDateChanged(planDate)).apply();
    }

    public void changeMealOption(MealId mealId, MealOption mealOption){
        Objects.requireNonNull(mealId);
        Objects.requireNonNull(mealOption);

        appendChange(new MealOptionChanged(mealId, mealOption)).apply();
    }

    public void addMeal(MealId mealId, MealOption mealOption, IncludeDessert includeDessert){
        Objects.requireNonNull(mealId);
        Objects.requireNonNull(mealOption);
        Objects.requireNonNull(includeDessert);

        appendChange(new MealAdded(mealId, mealOption, includeDessert));
    }

    public void changeTransportType(TransportId transportId, TransportType transportType){
        Objects.requireNonNull(transportId);
        Objects.requireNonNull(transportType);

        appendChange(new TransportTypeChanged(transportId, transportType));
    }

    public void notifyItinerary(String notification){
        Objects.requireNonNull(notification);

        appendChange(new ItineraryNotification(notification));
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

    protected Optional<Meal> getMealById(MealId entityId){
        return meals
                .stream()
                .filter(meal -> meal.identity().equals(entityId))
                .findFirst();
    }

}
