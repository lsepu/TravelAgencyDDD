package com.sofkaU.TravelAgencyDDD.circuit.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.TravelAgencyDDD.circuit.values.*;

public class ClientAdded extends DomainEvent {

    private final ClientId clientId;
    private final Name name;
    private final PhoneNumber phoneNumber;
    private final PassportNumber passportNumber;
    private final IdentificationCard identificationCard;
    private final TravelPoints travelPoints;

    public ClientAdded(ClientId clientId, Name name, PhoneNumber phoneNumber,
                       PassportNumber passportNumber, IdentificationCard identificationCard, TravelPoints travelPoints) {
        super("com.sofkaU.TravelAgencyDDD.circuit.clientadded");
        this.clientId = clientId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.passportNumber = passportNumber;
        this.identificationCard = identificationCard;
        this.travelPoints = travelPoints;
    }


    public ClientId getClientId() {
        return clientId;
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

    public TravelPoints getTravelPoints() {
        return travelPoints;
    }
}
