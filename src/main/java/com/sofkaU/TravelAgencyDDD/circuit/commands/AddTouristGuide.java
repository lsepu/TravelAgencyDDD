package com.sofkaU.TravelAgencyDDD.circuit.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.TravelAgencyDDD.circuit.values.*;

import java.util.Set;

public class AddTouristGuide extends Command {

    private final CircuitId circuitId;
    private final TouristGuideId touristGuideId;
    private final Name name;
    private final PhoneNumber phoneNumber;
    private final Set<DestinationExperience> destinationsExperience;

    public AddTouristGuide( CircuitId circuitId, TouristGuideId touristGuideId, Name name, PhoneNumber phoneNumber,
            Set<DestinationExperience> destinationsExperience) {
        this.circuitId = circuitId;
        this.touristGuideId = touristGuideId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.destinationsExperience = destinationsExperience;
    }

    public CircuitId getCircuitId() {
        return circuitId;
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
