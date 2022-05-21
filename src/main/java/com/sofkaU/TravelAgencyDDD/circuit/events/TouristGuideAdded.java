package com.sofkaU.TravelAgencyDDD.circuit.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.TravelAgencyDDD.circuit.values.DestinationExperience;
import com.sofkaU.TravelAgencyDDD.circuit.values.Name;
import com.sofkaU.TravelAgencyDDD.circuit.values.PhoneNumber;
import com.sofkaU.TravelAgencyDDD.circuit.values.TouristGuideId;

import java.util.Set;

public class TouristGuideAdded extends DomainEvent {

    private final TouristGuideId touristGuideId;
    private final Name name;
    private final PhoneNumber phoneNumber;
    private final Set<DestinationExperience> destinationsExperience;

    public TouristGuideAdded(TouristGuideId touristGuideId, Name name, PhoneNumber phoneNumber, Set<DestinationExperience> destinationsExperience) {
        super("com.sofkaU.TravelAgencyDDD.circuit.touristguideadded");
        this.touristGuideId = touristGuideId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.destinationsExperience = destinationsExperience;
    }

    public TouristGuideId getTouristGuideId() {
        return touristGuideId;
    }

    public Name getName() {
        return name;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public Set<DestinationExperience> getDestinationsExperience() {
        return destinationsExperience;
    }
}

