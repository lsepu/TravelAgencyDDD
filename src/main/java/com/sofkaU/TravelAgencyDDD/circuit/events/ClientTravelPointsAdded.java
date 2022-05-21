package com.sofkaU.TravelAgencyDDD.circuit.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.TravelAgencyDDD.circuit.values.ClientId;
import com.sofkaU.TravelAgencyDDD.circuit.values.TravelPoints;

public class ClientTravelPointsAdded extends DomainEvent {

    private final ClientId clientId;
    private final TravelPoints travelPoints;

    public ClientTravelPointsAdded(String type, ClientId clientId, TravelPoints travelPoints) {
        super("com.sofkaU.TravelAgencyDDD.circuit.clienttravelpointsadded");
        this.clientId = clientId;
        this.travelPoints = travelPoints;
    }

    public ClientId ClientId() {
        return clientId;
    }

    public TravelPoints TravelPoints() {
        return travelPoints;
    }
}
