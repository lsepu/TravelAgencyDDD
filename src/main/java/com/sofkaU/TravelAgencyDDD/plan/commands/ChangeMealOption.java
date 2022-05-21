package com.sofkaU.TravelAgencyDDD.plan.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.TravelAgencyDDD.plan.values.MealId;
import com.sofkaU.TravelAgencyDDD.plan.values.MealOption;

public class ChangeMealOption extends Command {

    private final MealId mealId;
    private final MealOption option;

    public ChangeMealOption(MealId mealId, MealOption mealOption) {
        this.mealId = mealId;
        this.option = mealOption;
    }

    public MealId getMealId() {
        return mealId;
    }

    public MealOption getOption() {
        return option;
    }
}
