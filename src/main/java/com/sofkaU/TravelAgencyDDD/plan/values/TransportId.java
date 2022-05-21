package com.sofkaU.TravelAgencyDDD.plan.values;

import co.com.sofka.domain.generic.Identity;

public class TransportId extends Identity {

    public TransportId(){

    }

    private TransportId(String id){
        super(id);
    }

    public static TransportId of (String id){
        return new TransportId(id);
    }

}
