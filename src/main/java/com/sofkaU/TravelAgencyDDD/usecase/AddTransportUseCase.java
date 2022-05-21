package com.sofkaU.TravelAgencyDDD.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkaU.TravelAgencyDDD.plan.Plan;
import com.sofkaU.TravelAgencyDDD.plan.commands.AddTransport;

public class AddTransportUseCase extends UseCase<RequestCommand<AddTransport>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddTransport> addTransportRequestCommand) {
        var command = addTransportRequestCommand.getCommand();

        var plan = Plan.from(
                command.getPlanId(),
                repository().getEventsBy(command.getPlanId().value())
        );

        plan.addTransport(
                command.getTransportId(), command.getTransportType(), command.getNumberOfPassengers()
        );

        emit().onResponse(new ResponseEvents(plan.getUncommittedChanges()));

    }

}
