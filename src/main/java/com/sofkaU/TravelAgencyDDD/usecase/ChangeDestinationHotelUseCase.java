package com.sofkaU.TravelAgencyDDD.usecase;


import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkaU.TravelAgencyDDD.circuit.Circuit;
import com.sofkaU.TravelAgencyDDD.circuit.commands.ChangeDestinationHotel;


public class ChangeDestinationHotelUseCase extends UseCase<RequestCommand<ChangeDestinationHotel>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ChangeDestinationHotel> ChangeDestinationHotelRequestCommand) {
        var command = ChangeDestinationHotelRequestCommand.getCommand();

        var circuit = Circuit.from(
                command.getCircuitId(),
                repository().getEventsBy(command.getCircuitId().value())
        );

        circuit.changeDestinationHotel(command.getDestinationId(), command.getHotel());

        emit().onResponse(new ResponseEvents(circuit.getUncommittedChanges()));

    }

}
