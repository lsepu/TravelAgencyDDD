package com.sofkaU.TravelAgencyDDD.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkaU.TravelAgencyDDD.plan.Plan;
import com.sofkaU.TravelAgencyDDD.plan.commands.CreatePlan;

public class CreatePlanUseCase extends UseCase<RequestCommand<CreatePlan>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreatePlan> createCircuitRequestCommand) {
        var command = createCircuitRequestCommand.getCommand();

        var plan = new Plan(command.getPlanId(), command.getActivities(), command.getPlanDate());

        emit().onResponse(new ResponseEvents(plan.getUncommittedChanges()));

    }

}
