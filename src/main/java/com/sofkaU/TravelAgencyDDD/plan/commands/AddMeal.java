package com.sofkaU.TravelAgencyDDD.plan.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.TravelAgencyDDD.plan.values.IncludeDessert;
import com.sofkaU.TravelAgencyDDD.plan.values.MealId;
import com.sofkaU.TravelAgencyDDD.plan.values.MealOption;

public class AddMeal extends Command {

    private final MealId mealId;
    private final MealOption mealOption;
    private final IncludeDessert includeDessert;

    public AddMeal(MealId mealId, MealOption mealOption, IncludeDessert includeDessert) {
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
