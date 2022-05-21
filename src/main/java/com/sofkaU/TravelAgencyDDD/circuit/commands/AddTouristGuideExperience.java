package com.sofkaU.TravelAgencyDDD.circuit.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.TravelAgencyDDD.circuit.values.DestinationExperience;
import com.sofkaU.TravelAgencyDDD.circuit.values.TouristGuideId;

public class AddTouristGuideExperience extends Command {

    private final TouristGuideId touristGuideId;
    private final DestinationExperience destinationExperience;

    public AddTouristGuideExperience(TouristGuideId touristGuideId, DestinationExperience destinationExperience) {
        this.touristGuideId = touristGuideId;
        this.destinationExperience = destinationExperience;
    }

    public TouristGuideId getTouristGuideId() {
        return touristGuideId;
    }

    public DestinationExperience getDestinationExperience() {
        return destinationExperience;
    }
}
