package com.sofkaU.TravelAgencyDDD.plan.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.TravelAgencyDDD.plan.values.MealId;
import com.sofkaU.TravelAgencyDDD.plan.values.MealOption;

public class RestaurantNotified extends DomainEvent {

    private final MealId mealId;
    private final MealOption option;

    public RestaurantNotified(MealId mealId, MealOption option) {
        super("com.sofkaU.TravelAgencyDDD.plan.restaurantnotified");
        this.mealId = mealId;
        this.option = option;
    }

    public MealId MealId() {
        return mealId;
    }

    public MealOption Option() {
        return option;
    }
}
