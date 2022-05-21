package com.sofkaU.TravelAgencyDDD.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkaU.TravelAgencyDDD.circuit.Circuit;
import com.sofkaU.TravelAgencyDDD.circuit.commands.AddClient;

public class AddClientUseCase extends UseCase<RequestCommand<AddClient>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddClient> addClientRequestCommand) {
        var command = addClientRequestCommand.getCommand();

        var circuit = Circuit.from(
                command.getCircuitId(),
                repository().getEventsBy(command.getCircuitId().value())
        );

        circuit.addClient(command.getClientId(), command.getName(), command.getPhoneNumber(),
                command.getPassportNumber(), command.getIdentificationCard(), command.getTravelPoints());

        emit().onResponse(new ResponseEvents(circuit.getUncommittedChanges()));

}
}
