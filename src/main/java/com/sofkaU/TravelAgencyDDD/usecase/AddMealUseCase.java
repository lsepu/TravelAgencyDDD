package com.sofkaU.TravelAgencyDDD.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkaU.TravelAgencyDDD.plan.Plan;
import com.sofkaU.TravelAgencyDDD.plan.commands.AddMeal;

public class AddMealUseCase extends UseCase<RequestCommand<AddMeal>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddMeal> addMealRequestCommand) {
        var command = addMealRequestCommand.getCommand();

        var plan = Plan.from(
                command.getPlanId(),
                repository().getEventsBy(command.getPlanId().value())
        );

        plan.addMeal(command.getMealId(), command.getMealOption(), command.getIncludeDessert());

        emit().onResponse(new ResponseEvents(plan.getUncommittedChanges()));

    }
}
