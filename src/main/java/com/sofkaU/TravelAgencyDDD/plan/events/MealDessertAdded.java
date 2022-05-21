package com.sofkaU.TravelAgencyDDD.plan.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.TravelAgencyDDD.plan.values.MealId;

public class MealDessertAdded extends DomainEvent {

    private final MealId mealId;

    public MealDessertAdded(MealId mealId) {
        super("com.sofkaU.TravelAgencyDDD.plan.mealdessertadded");
        this.mealId = mealId;
    }

    public MealId getMealId() {
        return mealId;
    }
}
