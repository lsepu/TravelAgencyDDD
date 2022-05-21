package com.sofkaU.TravelAgencyDDD.circuit.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.TravelAgencyDDD.circuit.values.TouristGuideId;
import com.sofkaU.TravelAgencyDDD.circuit.values.YearsOfExperience;

public class TouristGuideYearsOfExperienceChanged extends DomainEvent {

    private final TouristGuideId touristGuideId;
    private final YearsOfExperience yearsOfExperience;

    public TouristGuideYearsOfExperienceChanged(TouristGuideId touristGuideId, YearsOfExperience yearsOfExperience) {
        super("com.sofkaU.TravelAgencyDDD.circuit.touristguideyearsofexperiencechanged");
        this.touristGuideId = touristGuideId;
        this.yearsOfExperience = yearsOfExperience;
    }

    public TouristGuideId TouristGuideId() {
        return touristGuideId;
    }

    public YearsOfExperience YearsOfExperience() {
        return yearsOfExperience;
    }
}
