package com.sofkaU.TravelAgencyDDD.circuit;

import co.com.sofka.domain.generic.Entity;
import com.sofkaU.TravelAgencyDDD.circuit.values.*;

public class Client extends Entity<ClientId> {

    private Name name;
    private PhoneNumber phoneNumber;
    private PassportNumber passportNumber;
    private IdentificationCard identificationCard;
    private Age age;
    private TravelPoints travelPoints;

    public Client(ClientId entityId, Name name, PhoneNumber phoneNumber, PassportNumber passportNumber, IdentificationCard identificationCard, Age age, TravelPoints travelPoints) {
        super(entityId);
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.passportNumber = passportNumber;
        this.identificationCard = identificationCard;
        this.age = age;
        this.travelPoints = travelPoints;
    }

    public void AddTravelPoints(TravelPoints travelPoints){
        Integer newValue = this.travelPoints.value() + travelPoints.value;
        this.travelPoints = new TravelPoints(newValue);
    }

    public Name getName() {
        return name;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public PassportNumber getPassportNumber() {
        return passportNumber;
    }

    public IdentificationCard getIdentificationCard() {
        return identificationCard;
    }

    public Age getAge() {
        return age;
    }

    public TravelPoints getTravelPoints() {
        return travelPoints;
    }
}
