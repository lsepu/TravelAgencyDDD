package com.sofkaU.TravelAgencyDDD.plan.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.TravelAgencyDDD.plan.values.MealId;
import com.sofkaU.TravelAgencyDDD.plan.values.MealOption;
import com.sofkaU.TravelAgencyDDD.plan.values.PlanId;

public class ChangeMealOption extends Command {

    private final PlanId planId;
    private final MealId mealId;
    private final MealOption mealOption;

    public ChangeMealOption(PlanId planId, MealId mealId, MealOption mealOption) {
        this.planId = planId;
        this.mealId = mealId;
        this.mealOption = mealOption;
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
}
