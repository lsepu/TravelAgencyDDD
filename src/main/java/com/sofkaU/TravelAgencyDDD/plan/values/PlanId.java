package com.sofkaU.TravelAgencyDDD.plan.values;

import co.com.sofka.domain.generic.Identity;

public class PlanId extends Identity {

    public PlanId(){

    }

    private PlanId(String id){
        super(id);
    }

    public static PlanId of (String id){
        return new PlanId(id);
    }

}

