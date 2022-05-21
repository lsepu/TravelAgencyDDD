package com.sofkaU.TravelAgencyDDD.circuit;

import co.com.sofka.domain.generic.EventChange;
import com.sofkaU.TravelAgencyDDD.circuit.events.CircuitAdded;

public class CircuitChange extends EventChange {
    public CircuitChange(Circuit circuit){

        apply((CircuitAdded event) -> {
            circuit.touristGuide = event.getTouristGuide();
        });


    }


}
