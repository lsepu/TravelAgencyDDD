package com.sofkaU.TravelAgencyDDD.circuit.values;

import co.com.sofka.domain.generic.Identity;

public class CircuitId extends Identity {

    public CircuitId(){

    }

    private CircuitId(String id){
        super(id);
    }

    public static CircuitId of (String id){
        return new CircuitId(id);
    }

}
