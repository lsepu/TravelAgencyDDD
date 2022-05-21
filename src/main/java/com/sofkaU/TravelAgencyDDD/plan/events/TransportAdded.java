package com.sofkaU.TravelAgencyDDD.plan.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.TravelAgencyDDD.plan.values.*;

public class TransportAdded extends DomainEvent {

    private final TransportId transportId;
    private final Type type;
    private final Model model;
    private final MaxNumberOfPassengers maxNumberOfPassengers;
    private final LicensePlate licensePlate;

    public TransportAdded(String type, TransportId transportId, Type type1, Model model, MaxNumberOfPassengers maxNumberOfPassengers, LicensePlate licensePlate) {
        super("com.sofkaU.TravelAgencyDDD.plan.transportadded");
        this.transportId = transportId;
        this.type = type1;
        this.model = model;
        this.maxNumberOfPassengers = maxNumberOfPassengers;
        this.licensePlate = licensePlate;
    }

    public TransportId TransportId() {
        return transportId;
    }

    public Type Type() {
        return type;
    }

    public Model Model() {
        return model;
    }

    public MaxNumberOfPassengers MaxNumberOfPassengers() {
        return maxNumberOfPassengers;
    }

    public LicensePlate LicensePlate() {
        return licensePlate;
    }
}
