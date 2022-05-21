package com.sofkaU.TravelAgencyDDD.circuit;

import co.com.sofka.domain.generic.EventChange;
import com.sofkaU.TravelAgencyDDD.circuit.events.*;

import java.util.HashSet;

public class CircuitChange extends EventChange {
    public CircuitChange(Circuit circuit){

        apply((CircuitAdded event) -> {
            circuit.touristGuide = event.getTouristGuide();
            circuit.destination = event.getDestination();
            circuit.circuitDates = event.getCircuitDates();
            circuit.price = event.getPrice();
            circuit.planIds = new HashSet<>();
            circuit.clients = new HashSet<>();
        });

        apply((ClientAdded event) -> {
            circuit.clients.add(new Client(event.getClientId(), event.getName(), event.getPhoneNumber(), event.getPassportNumber(),
                    event.getIdentificationCard(), event.getTravelPoints()));
        });

        apply((ClientTravelPointsAdded event) ->{
            var client = circuit.getClientById(event.getClientId())
                    .orElseThrow(() -> new IllegalArgumentException("The client was not found"));

            client.AddTravelPoints(event.getTravelPoints());
        });

        apply((PlanAdded event) -> {
            circuit.planIds.add(event.getPlanId());
        });

        apply((TouristGuideYearsOfExperienceChanged event) -> {
            circuit.touristGuide.changeYearsOfExperience(event.getYearsOfExperience());
        });

        apply((DestinationHotelChanged event) -> {
            circuit.destination.changeHotel(event.getHotel());
        });

        apply((TouristGuideDestinationExperienceAdded event) -> {
            circuit.touristGuide.addDestinationExperience(event.getDestinationExperience());
        });

    }


}
