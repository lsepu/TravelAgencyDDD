package com.sofkaU.TravelAgencyDDD.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkaU.TravelAgencyDDD.circuit.Circuit;
import com.sofkaU.TravelAgencyDDD.circuit.commands.CreateCircuit;

public class CreateCircuitUseCase extends UseCase<RequestCommand<CreateCircuit>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreateCircuit> createCircuitRequestCommand) {
        var command = createCircuitRequestCommand.getCommand();

        var circuit = new Circuit(command.getCircuitId(), command.getDestination(),
                command.getCircuitDates(), command.getPrice());

        emit().onResponse(new ResponseEvents(circuit.getUncommittedChanges()));

    }

}
