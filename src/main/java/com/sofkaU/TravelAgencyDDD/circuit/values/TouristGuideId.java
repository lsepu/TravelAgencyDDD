package com.sofkaU.TravelAgencyDDD.circuit.values;

import co.com.sofka.domain.generic.Identity;

public class TouristGuideId extends Identity {

    public TouristGuideId(){

    }

    private TouristGuideId(String id){
        super(id);
    }

    public static TouristGuideId of (String id){
        return new TouristGuideId(id);
    }

}
