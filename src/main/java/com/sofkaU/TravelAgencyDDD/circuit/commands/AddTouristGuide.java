package com.sofkaU.TravelAgencyDDD.circuit.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.TravelAgencyDDD.circuit.values.*;

import java.util.Set;

public class AddTouristGuide extends Command {

    private final CircuitId circuitId;
    private final TouristGuideId touristGuideId;
    private final Name name;
    private final YearsOfExperience yearsOfExperience;
    private final Set<DestinationExperience> destinationsExperience;

    public AddTouristGuide(CircuitId circuitId, TouristGuideId touristGuideId, Name name,
                           Set<DestinationExperience> destinationsExperience, YearsOfExperience yearsOfExperience) {
        this.circuitId = circuitId;
        this.touristGuideId = touristGuideId;
        this.name = name;
        this.destinationsExperience = destinationsExperience;
        this.yearsOfExperience = yearsOfExperience;
    }

    public YearsOfExperience getYearsOfExperience() {
        return yearsOfExperience;
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


    public Set<DestinationExperience> getDestinationsExperience() {
        return destinationsExperience;
    }
}
