package com.sofkaU.TravelAgencyDDD.plan.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.TravelAgencyDDD.plan.values.IncludeDessert;
import com.sofkaU.TravelAgencyDDD.plan.values.MealId;
import com.sofkaU.TravelAgencyDDD.plan.values.MealOption;
import com.sofkaU.TravelAgencyDDD.plan.values.PlanId;

public class AddMeal extends Command {

    private final PlanId planId;
    private final MealId mealId;
    private final MealOption mealOption;
    private final IncludeDessert includeDessert;

    public AddMeal(PlanId planId, MealId mealId, MealOption mealOption, IncludeDessert includeDessert) {
        this.planId = planId;
        this.mealId = mealId;
        this.mealOption = mealOption;
        this.includeDessert = includeDessert;
    }

    public PlanId getPlanId() {
        return planId;
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
