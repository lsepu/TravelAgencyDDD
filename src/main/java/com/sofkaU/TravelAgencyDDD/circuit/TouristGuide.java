package com.sofkaU.TravelAgencyDDD.circuit;

import co.com.sofka.domain.generic.Entity;
import com.sofkaU.TravelAgencyDDD.circuit.values.*;

import java.util.Set;


public class TouristGuide extends Entity<TouristGuideId> {

    private YearsOfExperience yearsOfExperience;
    private Name name;
    private PhoneNumber phoneNumber;
    private Set<DestinationExperience> destinationsExperience;

    public TouristGuide(TouristGuideId entityId, YearsOfExperience yearsOfExperience, Name name, PhoneNumber phoneNumber, Set<DestinationExperience> destinationsExperience) {
        super(entityId);
        this.yearsOfExperience = yearsOfExperience;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.destinationsExperience = destinationsExperience;
    }

    public void ChangeYearsOfExperience(YearsOfExperience yearsOfExperience){
        this.yearsOfExperience = yearsOfExperience;
    }

    public void AddDestinationExperience(DestinationExperience destinationExperience){
        this.destinationsExperience.add(destinationExperience);
    }

    public YearsOfExperience getYearsOfExperience() {
        return yearsOfExperience;
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
