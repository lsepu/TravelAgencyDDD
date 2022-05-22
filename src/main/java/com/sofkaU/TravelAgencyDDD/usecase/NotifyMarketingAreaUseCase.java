package com.sofkaU.TravelAgencyDDD.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofkaU.TravelAgencyDDD.circuit.Circuit;
import com.sofkaU.TravelAgencyDDD.circuit.events.CircuitCreated;
import com.sofkaU.TravelAgencyDDD.circuit.values.CircuitId;

public class NotifyMarketingAreaUseCase extends UseCase<TriggeredEvent<CircuitCreated>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<CircuitCreated> CircuitCreatedTriggeredEvent) {
        var event = CircuitCreatedTriggeredEvent.getDomainEvent();


        var circuit = Circuit.from(
                CircuitId.of(event.aggregateRootId()),
                this.retrieveEvents()
        );

       circuit.notifyMarketingArea("A new circuit has been created");

        emit().onResponse(new ResponseEvents(circuit.getUncommittedChanges()));

    }

}
