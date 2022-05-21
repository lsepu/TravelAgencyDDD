package com.sofkaU.TravelAgencyDDD.circuit.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.TravelAgencyDDD.circuit.values.*;

public class AddClient extends Command {

    private final ClientId clientId;
    private final Name name;
    private final PhoneNumber phoneNumber;
    private final PassportNumber passportNumber;
    private final IdentificationCard identificationCard;
    private final TravelPoints travelPoints;

    public AddClient(ClientId clientId, Name name,
                     PhoneNumber phoneNumber, PassportNumber passportNumber,
                     IdentificationCard identificationCard, TravelPoints travelPoints) {
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
