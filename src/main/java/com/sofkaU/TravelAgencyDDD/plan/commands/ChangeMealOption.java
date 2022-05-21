package com.sofkaU.TravelAgencyDDD.plan.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.TravelAgencyDDD.plan.values.MealId;
import com.sofkaU.TravelAgencyDDD.plan.values.Option;

public class ChangeMealOption extends Command {

    private final MealId mealId;
    private final Option option;

    public ChangeMealOption(MealId mealId, Option option) {
        this.mealId = mealId;
        this.option = option;
    }

    public MealId getMealId() {
        return mealId;
    }

    public Option getOption() {
        return option;
    }
}
