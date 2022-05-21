package com.sofkaU.TravelAgencyDDD.plan.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.TravelAgencyDDD.plan.values.IncludeDessert;
import com.sofkaU.TravelAgencyDDD.plan.values.MealId;
import com.sofkaU.TravelAgencyDDD.plan.values.MealOption;

public class MealAdded extends DomainEvent {

    private final MealId mealId;
    private final MealOption mealOption;
    private final IncludeDessert includeDessert;

    public MealAdded(MealId mealId, MealOption mealOption, IncludeDessert includeDessert) {
        super("com.sofkaU.TravelAgencyDDD.plan.mealadded");
        this.mealId = mealId;
        this.mealOption = mealOption;
        this.includeDessert = includeDessert;
    }

    public MealId getMealId() {
        return mealId;
    }

    public MealOption getMealOption() {
        return mealOption;
    }

    public IncludeDessert getIncludeDessert() {
        return includeDessert;
    }
}
