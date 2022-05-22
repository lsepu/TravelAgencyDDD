package com.sofkaU.TravelAgencyDDD.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofkaU.TravelAgencyDDD.plan.Plan;
import com.sofkaU.TravelAgencyDDD.plan.events.PlanCreated;
import com.sofkaU.TravelAgencyDDD.plan.values.PlanId;

public class NotifyItineraryUseCase extends UseCase<TriggeredEvent<PlanCreated>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<PlanCreated> PlanDateChangedTriggeredEvent) {
        var event = PlanDateChangedTriggeredEvent.getDomainEvent();

        var plan = Plan.from(
                PlanId.of(event.aggregateRootId()),
                this.retrieveEvents()
        );

        plan.notifyItinerary("email sent with the day itinerary information");

        emit().onResponse(new ResponseEvents(plan.getUncommittedChanges()));

    }


}
