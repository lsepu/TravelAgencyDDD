package com.sofkaU.TravelAgencyDDD.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofkaU.TravelAgencyDDD.circuit.Destination;
import com.sofkaU.TravelAgencyDDD.circuit.events.CircuitCreated;
import com.sofkaU.TravelAgencyDDD.circuit.events.MarketingAreaNotified;
import com.sofkaU.TravelAgencyDDD.circuit.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NotifyMarketingAreaUseCaseTest {

    private final String ROOT_ID = "XXXX";

    @Mock
    private DomainEventRepository repository;

    @Test
    void notifyMarketingArea() {

        var event = circuitCreatedEvent();
        event.setAggregateRootId(ROOT_ID);

        var useCase = new NotifyMarketingAreaUseCase();
        useCase.addRepository(repository);

        when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(event));
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOT_ID)
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow(()->new IllegalArgumentException("Something went wrong while notifying the marketing area"))
                .getDomainEvents();

        //Assert
        var message = (MarketingAreaNotified) events.get(0);
        Assertions.assertEquals("A new circuit has been created", message.getMessage());
        Mockito.verify(repository).getEventsBy(ROOT_ID);

    }

    private CircuitCreated circuitCreatedEvent() {
        DestinationId destinationId = DestinationId.of("YYYYY");
        Destination destination = new Destination(
                destinationId,
                new Hotel("Hilton", "Street 123"),
                new Weather(Weather.WeatherTypes.COLD),
                new City("Bogota"),
                new Country("Colombia")
        );

        Date beginningDate = parseDate("2022-09-14");
        Date endDate = parseDate("20122-09-20");
        CircuitDates circuitDates = new CircuitDates(beginningDate, endDate);

        Price price = new Price(225650.0);

        var event = new CircuitCreated(destination, circuitDates, price);
        return event;
    }

    public static Date parseDate (String date){
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

}