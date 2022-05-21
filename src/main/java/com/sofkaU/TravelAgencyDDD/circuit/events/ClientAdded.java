package com.sofkaU.TravelAgencyDDD.circuit.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.TravelAgencyDDD.circuit.values.*;

public class ClientAdded extends DomainEvent {

    private final Name name;
    private final PhoneNumber phoneNumber;
    private final PassportNumber passportNumber;
    private final IdentificationCard identificationCard;
    private final Age age;
    private final TravelPoints travelPoints;

    public ClientAdded(String type, Name name, PhoneNumber phoneNumber, PassportNumber passportNumber, IdentificationCard identificationCard, Age age, TravelPoints travelPoints) {
        super("com.sofkaU.TravelAgencyDDD.circuit.clientadded");
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.passportNumber = passportNumber;
        this.identificationCard = identificationCard;
        this.age = age;
        this.travelPoints = travelPoints;
    }

    public Name Name() {
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

    public Age Age() {
        return age;
    }

    public TravelPoints TravelPoints() {
        return travelPoints;
    }
}
