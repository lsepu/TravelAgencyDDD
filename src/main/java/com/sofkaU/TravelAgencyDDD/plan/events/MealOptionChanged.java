package com.sofkaU.TravelAgencyDDD.plan.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.TravelAgencyDDD.plan.values.MealId;
import com.sofkaU.TravelAgencyDDD.plan.values.Option;

public class MealOptionChanged extends DomainEvent {

    private final MealId mealId;
    private final Option option;

    public MealOptionChanged(MealId mealId, Option option) {
        super("com.sofkaU.TravelAgencyDDD.plan.mealoptionchanged");
        this.mealId = mealId;
        this.option = option;
    }

    public MealId MealId() {
        return mealId;
    }

    public Option Option() {
        return option;
    }
}
