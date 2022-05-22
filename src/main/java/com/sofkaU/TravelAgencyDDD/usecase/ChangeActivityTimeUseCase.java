package com.sofkaU.TravelAgencyDDD.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkaU.TravelAgencyDDD.plan.Plan;
import com.sofkaU.TravelAgencyDDD.plan.commands.ChangeActivityTime;

public class ChangeActivityTimeUseCase extends UseCase<RequestCommand<ChangeActivityTime>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ChangeActivityTime> ChangeActivityTimeRequestCommand) {
        var command = ChangeActivityTimeRequestCommand.getCommand();

        var plan = Plan.from(
                command.getPlanId(),
                repository().getEventsBy(command.getPlanId().value())
        );

        plan.changeActivityTime(command.getActivityId(), command.getTime());

        emit().onResponse(new ResponseEvents(plan.getUncommittedChanges()));

    }

}
