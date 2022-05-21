package com.sofkaU.TravelAgencyDDD.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.TravelAgencyDDD.circuit.Destination;
import com.sofkaU.TravelAgencyDDD.circuit.commands.AddClient;
import com.sofkaU.TravelAgencyDDD.circuit.commands.CreateCircuit;
import com.sofkaU.TravelAgencyDDD.circuit.events.CircuitCreated;
import com.sofkaU.TravelAgencyDDD.circuit.events.ClientAdded;
import com.sofkaU.TravelAgencyDDD.circuit.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AddClientUseCaseTest {
    private final String ROOT_ID = "XXXX";

    @InjectMocks
    private AddClientUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void addClientUser(){

        var command = new AddClient(
                CircuitId.of(ROOT_ID),
                ClientId.of("YYYYY"),
                new Name("Juan"),
                new PhoneNumber("3046534527"),
                new PassportNumber("WGS8749XC"),
                new IdentificationCard("4687389732"),
                new TravelPoints(0)
                );

        var useCase = new AddClientUseCase();
        Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(history());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOT_ID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(()->new IllegalArgumentException("Something went wrong while adding the client"))
                .getDomainEvents();

        //Assert
        var event = (ClientAdded)events.get(0);
        Assertions.assertEquals(command.getName().value(), event.getName().value());
        Assertions.assertEquals(command.getPhoneNumber().value(), event.getPhoneNumber().value());
        Assertions.assertEquals(command.getPassportNumber().value(), event.getPassportNumber().value());
        Assertions.assertEquals(command.getIdentificationCard().value(), event.getIdentificationCard().value());
        Assertions.assertEquals(command.getTravelPoints().value(), event.getTravelPoints().value());


    }

    private List<DomainEvent> history(){
        DestinationId destinationId = DestinationId.of("YYYYY");
        Destination destination = new Destination(
                destinationId,
                new Hotel("Hilton","Street 123"),
                new Weather(Weather.WeatherTypes.COLD),
                new City("Bogota"),
                new Country("Colombia")
        );

        Date beginningDate = parseDate("2022-09-14");
        Date endDate = parseDate("20122-09-20");
        CircuitDates circuitDates = new CircuitDates(beginningDate, endDate);

        Price price = new Price(225650.0);

        var event = new CircuitCreated(destination, circuitDates, price);
        return List.of(event);
    }

    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }



}