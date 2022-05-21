package com.sofkaU.TravelAgencyDDD.plan;

import co.com.sofka.domain.generic.EventChange;
import com.sofkaU.TravelAgencyDDD.plan.events.*;

public class PlanChange extends EventChange {

    public PlanChange(Plan plan){

        apply((PlanCreated event) -> {
            plan.meals = event.getMeals();
            plan.activities = event.getActivities();
            plan.transports = event.getTransports();
            plan.planDate = event.getPlanDate();
        });

        apply((ActivityAdded event) -> {
            plan.activities.add(new Activity(event.getActivityId(), event.getTime(), event.getAddress(), event.getDuration()));
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

        apply((DateChanged event) -> {
            plan.planDate = event.getPlanDate();
        });

        apply((MealOptionChanged event) -> {
            var meal = plan.getMealById(event.getMealId())
                    .orElseThrow(() -> new IllegalArgumentException("The meal was not found"));
            meal.changeMealOption(event.getOption());
        });

        apply((MealAdded event) -> {
            plan.meals.add(new Meal(event.getMealId(), event.getMealOption(), event.getIncludeDessert()));
        });

        apply((TransportTypeChanged event) -> {
            var transport = plan.getTransportById(event.getTransportId())
                    .orElseThrow(() -> new IllegalArgumentException("The trasnport was not found"));
            transport.changeTransportType(event.getTransportType());
        });


    }
}
