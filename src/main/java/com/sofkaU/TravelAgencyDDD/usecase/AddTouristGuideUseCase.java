package com.sofkaU.TravelAgencyDDD.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkaU.TravelAgencyDDD.circuit.Circuit;
import com.sofkaU.TravelAgencyDDD.circuit.commands.AddTouristGuide;

public class AddTouristGuideUseCase extends UseCase<RequestCommand<AddTouristGuide>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddTouristGuide> addTouristGuideRequestCommand) {
        var command = addTouristGuideRequestCommand.getCommand();

        var circuit = Circuit.from(
                command.getCircuitId(),
                repository().getEventsBy(command.getCircuitId().value())
        );

        circuit.addTouristGuide(command.getTouristGuideId(),command.getName(),command.getPhoneNumber(),
                command.getDestinationsExperience(),command.getYearsOfExperience());

        emit().onResponse(new ResponseEvents(circuit.getUncommittedChanges()));

    }
}
