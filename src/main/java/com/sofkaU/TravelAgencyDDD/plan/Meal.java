package com.sofkaU.TravelAgencyDDD.plan;

import co.com.sofka.domain.generic.Entity;
import com.sofkaU.TravelAgencyDDD.plan.values.IncludeDessert;
import com.sofkaU.TravelAgencyDDD.plan.values.MealId;
import com.sofkaU.TravelAgencyDDD.plan.values.MealOption;

public class Meal extends Entity<MealId> {

    private MealOption mealOption;
    private IncludeDessert includeDessert;

    public Meal(MealId entityId, MealOption mealOption, IncludeDessert includeDessert) {
        super(entityId);
        this.mealOption = mealOption;
        this.includeDessert = includeDessert;
    }

    public void addDessert(){
        IncludeDessert dessertIncluded = new IncludeDessert(true);
        this.includeDessert = dessertIncluded;
    }

    public void changeMealOption(MealOption mealOption){
        this.mealOption = mealOption;
    }

    public MealOption getMealOption() {
        return mealOption;
    }

    public IncludeDessert getIncludeDessert() {
        return includeDessert;
    }
}
