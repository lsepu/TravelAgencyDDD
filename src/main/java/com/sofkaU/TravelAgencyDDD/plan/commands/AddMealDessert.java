package com.sofkaU.TravelAgencyDDD.plan.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.TravelAgencyDDD.plan.values.MealId;

public class AddMealDessert extends Command {

    private final MealId mealId;

    public AddMealDessert(MealId mealId) {
        this.mealId = mealId;
    }

    public MealId getMealId() {
        return mealId;
    }
}
