package com.sofkaU.TravelAgencyDDD.circuit.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.TravelAgencyDDD.circuit.values.DestinationExperience;
import com.sofkaU.TravelAgencyDDD.circuit.values.TouristGuideId;

public class TouristGuideDestinationExperienceAdded extends DomainEvent {

    private final TouristGuideId touristGuideId;
    private final DestinationExperience destinationExperience;

    public TouristGuideDestinationExperienceAdded(TouristGuideId touristGuideId, DestinationExperience destinationExperience) {
        super("com.sofkaU.TravelAgencyDDD.circuit.touristguidedestinationexperienceadded");
        this.touristGuideId = touristGuideId;
        this.destinationExperience = destinationExperience;
    }

    public TouristGuideId TouristGuideId() {
        return touristGuideId;
    }

    public DestinationExperience DestinationExperience() {
        return destinationExperience;
    }
}
