package com.sofkaU.TravelAgencyDDD.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkaU.TravelAgencyDDD.plan.Plan;
import com.sofkaU.TravelAgencyDDD.plan.commands.AddActivity;

public class AddActivityUseCase extends UseCase<RequestCommand<AddActivity>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<AddActivity> addActivityRequestCommand) {
        var command = addActivityRequestCommand.getCommand();

        var plan = Plan.from(
                command.getPlanId(),
                repository().getEventsBy(command.getPlanId().value())
        );

        plan.addActivity(command.getActivityId(), command.getActivityName(), command.getTime(),command.getAddress(),command.getDuration());

        emit().onResponse(new ResponseEvents(plan.getUncommittedChanges()));

    }

}
