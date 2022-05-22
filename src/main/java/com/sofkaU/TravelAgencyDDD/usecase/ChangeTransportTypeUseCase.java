package com.sofkaU.TravelAgencyDDD.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkaU.TravelAgencyDDD.plan.Plan;
import com.sofkaU.TravelAgencyDDD.plan.commands.ChangeTransportType;

public class ChangeTransportTypeUseCase extends UseCase<RequestCommand<ChangeTransportType>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ChangeTransportType> ChangeTransportTypeRequestCommand) {
        var command = ChangeTransportTypeRequestCommand.getCommand();

        var plan = Plan.from(
                command.getPlanId(),
                repository().getEventsBy(command.getPlanId().value())
        );

        plan.changeTransportType(command.getTransportId(), command.getTransportType());

        emit().onResponse(new ResponseEvents(plan.getUncommittedChanges()));

    }

}
