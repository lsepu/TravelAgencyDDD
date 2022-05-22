package com.sofkaU.TravelAgencyDDD.circuit.events;

import co.com.sofka.domain.generic.DomainEvent;

public class MarketingAreaNotified extends DomainEvent {

    private final String message;

    public MarketingAreaNotified( String message) {
        super("com.sofkaU.TravelAgencyDDD.circuit.marketingareanotified");
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
