package com.sofkaU.TravelAgencyDDD.circuit.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.TravelAgencyDDD.circuit.values.TouristGuideId;
import com.sofkaU.TravelAgencyDDD.circuit.values.YearsOfExperience;

public class ChangeTouristGuideYearsOfExperience extends Command {

    private final TouristGuideId touristGuideId;
    private final YearsOfExperience yearsOfExperience;

    public ChangeTouristGuideYearsOfExperience(TouristGuideId touristGuideId, YearsOfExperience yearsOfExperience) {
        this.touristGuideId = touristGuideId;
        this.yearsOfExperience = yearsOfExperience;
    }

    public TouristGuideId getTouristGuideId() {
        return touristGuideId;
    }

    public YearsOfExperience getYearsOfExperience() {
        return yearsOfExperience;
    }
}
