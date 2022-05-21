package com.sofkaU.TravelAgencyDDD.circuit;

import co.com.sofka.domain.generic.Entity;
import com.sofkaU.TravelAgencyDDD.circuit.values.*;

public class Client extends Entity<ClientId> {

    private Name name;
    private PhoneNumber phoneNumber;
    private PassportNumber passportNumber;
    private IdentificationCard identificationCard;

    private TravelPoints travelPoints;

    public Client(ClientId entityId, Name name, PhoneNumber phoneNumber, PassportNumber passportNumber, IdentificationCard identificationCard, TravelPoints travelPoints) {
        super(entityId);
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.passportNumber = passportNumber;
        this.identificationCard = identificationCard;
        this.travelPoints = travelPoints;
    }

    public void AddTravelPoints(TravelPoints travelPoints){
        Integer newValue = this.travelPoints.value() + travelPoints.value;
        this.travelPoints = new TravelPoints(newValue);
    }

    public Name getName() {
        return name;
    }

    public PhoneNumber PhoneNumber() {
        return phoneNumber;
    }

    public PassportNumber PassportNumber() {
        return passportNumber;
    }

    public IdentificationCard IdentificationCard() {
        return identificationCard;
    }


    public TravelPoints TravelPoints() {
        return travelPoints;
    }
}
