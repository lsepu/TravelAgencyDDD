package com.sofkaU.TravelAgencyDDD.circuit.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.TravelAgencyDDD.circuit.values.*;

import java.util.Set;

public class TouristGuideAdded extends DomainEvent {

    private final TouristGuideId touristGuideId;
    private final Name name;
    private final Set<DestinationExperience> destinationsExperience;
    private final YearsOfExperience yearsOfExperience;

    public TouristGuideAdded(TouristGuideId touristGuideId, Name name, Set<DestinationExperience> destinationsExperience,
                             YearsOfExperience yearsOfExperience) {
        super("com.sofkaU.TravelAgencyDDD.circuit.touristguideadded");
        this.touristGuideId = touristGuideId;
        this.name = name;
        this.destinationsExperience = destinationsExperience;
        this.yearsOfExperience = yearsOfExperience;
    }


    public TouristGuideId getTouristGuideId() {
        return touristGuideId;
    }

    public YearsOfExperience getYearsOfExperience() {
        return yearsOfExperience;
    }

    public Name getName() {
        return name;
    }


    public Set<DestinationExperience> getDestinationsExperience() {
        return destinationsExperience;
    }
}

