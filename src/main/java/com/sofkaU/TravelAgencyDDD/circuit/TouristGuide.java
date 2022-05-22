package com.sofkaU.TravelAgencyDDD.circuit;

import co.com.sofka.domain.generic.Entity;
import com.sofkaU.TravelAgencyDDD.circuit.values.*;

import java.util.Set;


public class TouristGuide extends Entity<TouristGuideId> {

    private YearsOfExperience yearsOfExperience;
    private Name name;
    private Set<DestinationExperience> destinationsExperience;

    public TouristGuide(TouristGuideId entityId, YearsOfExperience yearsOfExperience, Name name, Set<DestinationExperience> destinationsExperience) {
        super(entityId);
        this.yearsOfExperience = yearsOfExperience;
        this.name = name;
        this.destinationsExperience = destinationsExperience;
    }

    public void changeYearsOfExperience(YearsOfExperience yearsOfExperience){
        this.yearsOfExperience = yearsOfExperience;
    }

    public void addDestinationExperience(DestinationExperience destinationExperience){
        this.destinationsExperience.add(destinationExperience);
    }

    public YearsOfExperience YearsOfExperience() {
        return yearsOfExperience;
    }

    public Name Name() {
        return name;
    }

    public Set<DestinationExperience> DestinationsExperience() {
        return destinationsExperience;
    }
}
