package com.sofkaU.TravelAgencyDDD.circuit.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.TravelAgencyDDD.circuit.values.ClientId;
import com.sofkaU.TravelAgencyDDD.circuit.values.TravelPoints;

public class AddClientTravelPoints extends Command {

    private final ClientId clientId;
    private final TravelPoints travelPoints;

    public AddClientTravelPoints(ClientId clientId, TravelPoints travelPoints) {
        this.clientId = clientId;
        this.travelPoints = travelPoints;
    }

    public ClientId getClientId() {
        return clientId;
    }

    public TravelPoints getTravelPoints() {
        return travelPoints;
    }
}
