package com.sofkaU.TravelAgencyDDD.plan.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.TravelAgencyDDD.plan.values.MealId;
import com.sofkaU.TravelAgencyDDD.plan.values.MealOption;

public class MealOptionChanged extends DomainEvent {

    private final MealId mealId;
    private final MealOption mealOption;

    public MealOptionChanged(MealId mealId, MealOption mealOption) {
        super("com.sofkaU.TravelAgencyDDD.plan.mealoptionchanged");
        this.mealId = mealId;
        this.mealOption = mealOption;
    }

    public MealId getMealId() {
        return mealId;
    }

    public MealOption getMealOption() {
        return mealOption;
    }
}
