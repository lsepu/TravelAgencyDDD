package com.sofkaU.TravelAgencyDDD.plan.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.TravelAgencyDDD.plan.values.*;

public class AddTransport extends Command {

    private final TransportId transportId;
    private final Type type;
    private final Model model;
    private final MaxNumberOfPassengers maxNumberOfPassengers;
    private final LicensePlate licensePlate;

    public AddTransport(TransportId transportId, Type type, Model model, MaxNumberOfPassengers maxNumberOfPassengers, LicensePlate licensePlate) {
        this.transportId = transportId;
        this.type = type;
        this.model = model;
        this.maxNumberOfPassengers = maxNumberOfPassengers;
        this.licensePlate = licensePlate;
    }

    public TransportId getTransportId() {
        return transportId;
    }

    public Type getType() {
        return type;
    }

    public Model getModel() {
        return model;
    }

    public MaxNumberOfPassengers getMaxNumberOfPassengers() {
        return maxNumberOfPassengers;
    }

    public LicensePlate getLicensePlate() {
        return licensePlate;
    }
}
