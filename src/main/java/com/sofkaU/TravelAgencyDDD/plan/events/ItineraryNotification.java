package com.sofkaU.TravelAgencyDDD.plan.events;

import co.com.sofka.domain.generic.DomainEvent;

public class ItineraryNotification extends DomainEvent {

    private final String notification;

    public ItineraryNotification(String notification) {
        super("com.sofkaU.TravelAgencyDDD.plan.datechangenotification");
        this.notification = notification;
    }

    public String getNotification() {
        return notification;
    }
}
