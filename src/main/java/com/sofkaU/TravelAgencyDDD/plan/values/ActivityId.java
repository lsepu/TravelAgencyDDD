package com.sofkaU.TravelAgencyDDD.plan.values;

import co.com.sofka.domain.generic.Identity;
import com.sofkaU.TravelAgencyDDD.plan.Activity;

public class ActivityId extends Identity {

    public ActivityId(){

    }

    private ActivityId(String id){
        super(id);
    }

    public static ActivityId of (String id){
        return new ActivityId(id);
    }

}
