package com.sofkaU.TravelAgencyDDD.plan;

import co.com.sofka.domain.generic.EventChange;
import com.sofkaU.TravelAgencyDDD.plan.events.*;

import java.util.HashSet;

public class PlanChange extends EventChange {

    public PlanChange(Plan plan){

        apply((PlanCreated event) -> {
            plan.activities = event.getActivities();
            plan.planDate = event.getPlanDate();
            plan.transports = new HashSet<>();
            plan.meals = new HashSet<>();
        });

        apply((ActivityAdded event) -> {
            plan.activities.add(new Activity(event.getActivityId(), event.getActivityName(), event.getTime(), event.getAddress(), event.getDuration()));
        });

        apply((MealDessertAdded event) -> {
            var meal = plan.getMealById(event.getMealId())
                    .orElseThrow(() -> new IllegalArgumentException("The meal was not found"));
            meal.IncludeDessert();
        });

        apply((TransportAdded event) -> {
            plan.transports.add(new Transport(event.getTransportId(), event.getTransportType(), event.getNumberOfPassengers()));
        });

        apply((ActivityDurationChanged event) -> {
            var activity = plan.getActivityById(event.getActivityId())
                    .orElseThrow(() -> new IllegalArgumentException("The activity was not found"));
            activity.changeDuration(event.getDuration());
        });

        apply((ActivityTimeChanged event) -> {
            var activity = plan.getActivityById(event.getActivityId())
                    .orElseThrow(() -> new IllegalArgumentException("The activity was not found"));
            activity.changeTime(event.getTime());
        });

        apply((PlanDateChanged event) -> {
            plan.planDate = event.getPlanDate();
        });

        apply((MealOptionChanged event) -> {
            var meal = plan.getMealById(event.getMealId())
                    .orElseThrow(() -> new IllegalArgumentException("The meal was not found"));
            meal.changeMealOption(event.getMealOption());
        });

        apply((MealAdded event) -> {
            plan.meals.add(new Meal(event.getMealId(), event.getMealOption(), event.getIncludeDessert()));
        });

        apply((TransportTypeChanged event) -> {
            var transport = plan.getTransportById(event.getTransportId())
                    .orElseThrow(() -> new IllegalArgumentException("The transport was not found"));
            transport.changeTransportType(event.getTransportType());
        });


    }
}
