package com.sofkaU.TravelAgencyDDD.plan.values;

import co.com.sofka.domain.generic.Identity;

public class MealId extends Identity {

    public MealId(){

    }

    private MealId(String id){
        super(id);
    }

    public static MealId of (String id){
        return new MealId(id);
    }

}
