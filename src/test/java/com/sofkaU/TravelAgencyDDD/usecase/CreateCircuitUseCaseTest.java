package com.sofkaU.TravelAgencyDDD.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.TravelAgencyDDD.circuit.Destination;
import com.sofkaU.TravelAgencyDDD.circuit.commands.CreateCircuit;
import com.sofkaU.TravelAgencyDDD.circuit.events.CircuitCreated;
import com.sofkaU.TravelAgencyDDD.circuit.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
class CreateCircuitUseCaseTest {

    @Test
    void CreateCircuit(){
        //Arrange
        CircuitId circuitId = CircuitId.of("XXXXX");

        //destination object construction
        DestinationId destinationId = DestinationId.of("XXXXX");
        Destination destination = new Destination(
                destinationId,
                new Hotel("Hilton","Street 123"),
                new Weather(Weather.WeatherTypes.COLD),
                new City("Bogota"),
                new Country("Colombia")
        );

        //rest of circuit params creation
        Date beginningDate = parseDate("2022-09-14");
        Date endDate = parseDate("20122-09-20");
        CircuitDates circuitDates = new CircuitDates(beginningDate, endDate);

        Price price = new Price(225650.0);

        var command = new CreateCircuit(circuitId, destination, circuitDates, price);
        var useCase = new CreateCircuitUseCase();

        //act
        List<DomainEvent> events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(()-> new IllegalArgumentException("Something went wrong creating the circuit"))
                .getDomainEvents();

        //assert
        CircuitCreated event = (CircuitCreated)events.get(0);
        Assertions.assertEquals("Bogota", event.getDestination().City().value());
        Assertions.assertEquals(circuitDates, event.getCircuitDates());
        Assertions.assertEquals(225650.0, event.getPrice().value());


    }

    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

}