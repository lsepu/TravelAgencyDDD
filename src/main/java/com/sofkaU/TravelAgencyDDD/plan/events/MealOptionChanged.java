package com.sofkaU.TravelAgencyDDD.plan.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.TravelAgencyDDD.plan.values.MealId;
import com.sofkaU.TravelAgencyDDD.plan.values.MealOption;

public class MealOptionChanged extends DomainEvent {

    private final MealId mealId;
    private final MealOption option;

    public MealOptionChanged(MealId mealId, MealOption option) {
        super("com.sofkaU.TravelAgencyDDD.plan.mealoptionchanged");
        this.mealId = mealId;
        this.option = option;
    }

    public MealId getMealId() {
        return mealId;
    }

    public MealOption getOption() {
        return option;
    }
}
